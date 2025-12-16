package com.example.lineage.impact.engine;

import com.example.lineage.domain.enums.RiskLevel;
import com.example.lineage.domain.enums.UsageDecision;
import com.example.lineage.domain.model.ChangeEvent;
import com.example.lineage.domain.model.ImpactEvidence;
import com.example.lineage.domain.model.ImpactResult;
import com.example.lineage.domain.model.JobLineage;
import com.example.lineage.graph.service.LineageTraversalService;
import com.example.lineage.impact.detector.FieldUsageDetector;
import com.example.lineage.impact.detector.LlmFallbackDetector;
import com.example.lineage.parser.SparkSqlParser;
import com.example.lineage.parser.model.SparkSqlIr;
import java.util.ArrayList;
import java.util.List;

public class ImpactInferenceEngine {

    private final LineageTraversalService traversalService;
    private final SparkSqlParser sparkSqlParser;
    private final FieldUsageDetector ruleBasedDetector;
    private final LlmFallbackDetector llmFallbackDetector;

    public ImpactInferenceEngine(LineageTraversalService traversalService,
                                 SparkSqlParser sparkSqlParser,
                                 FieldUsageDetector ruleBasedDetector,
                                 LlmFallbackDetector llmFallbackDetector) {
        this.traversalService = traversalService;
        this.sparkSqlParser = sparkSqlParser;
        this.ruleBasedDetector = ruleBasedDetector;
        this.llmFallbackDetector = llmFallbackDetector;
    }

    public List<ImpactResult> analyze(ChangeEvent event, int maxDepth) {
        List<JobLineage> edges = traversalService.bfsDownstreamEdges(event.getTableId(), maxDepth);
        List<ImpactResult> results = new ArrayList<>();
        for (JobLineage edge : edges) {
            SparkSqlIr ir = sparkSqlParser.parse(edge.getRawScript());
            FieldUsageDetector.DetectionResult detection = ruleBasedDetector.detect(event, ir);
            if (detection.getDecision() == UsageDecision.UNKNOWN && ir.isHasStarSelect()) {
                detection = llmFallbackDetector.infer(event, ir);
            }
            ImpactResult result = toImpactResult(event, edge, detection);
            results.add(result);
            if (shouldStopPropagation(detection)) {
                // TODO mark downstream edges of this branch as skipped
            }
        }
        return results;
    }

    private ImpactResult toImpactResult(ChangeEvent event, JobLineage edge, FieldUsageDetector.DetectionResult detection) {
        ImpactResult result = new ImpactResult();
        result.setTableId(edge.getDownstreamTableId());
        result.setJobId(edge.getJobId());
        result.setJobType(edge.getJobType());
        result.setUsageDecision(detection.getDecision());
        result.setConfidence(detection.getConfidence());
        result.setEvidence(detection.getEvidence());
        result.setRiskLevel(mapRisk(detection));
        // TODO fill usageKinds based on matched expressions categories
        return result;
    }

    private boolean shouldStopPropagation(FieldUsageDetector.DetectionResult detection) {
        return detection.getDecision() == UsageDecision.NOT_USED && detection.getConfidence() >= 0.7;
    }

    private RiskLevel mapRisk(FieldUsageDetector.DetectionResult detection) {
        UsageDecision decision = detection.getDecision();
        if (decision == UsageDecision.USED) {
            return RiskLevel.HIGH;
        }
        if (decision == UsageDecision.UNKNOWN) {
            return RiskLevel.MEDIUM;
        }
        return RiskLevel.LOW;
    }
}
