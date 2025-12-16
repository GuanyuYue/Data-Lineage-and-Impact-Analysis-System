package com.example.lineage.impact.detector;

import com.example.lineage.domain.enums.UsageDecision;
import com.example.lineage.domain.model.ChangeEvent;
import com.example.lineage.domain.model.ImpactEvidence;
import com.example.lineage.gateway.client.LlmGatewayClient;
import com.example.lineage.parser.model.SparkSqlIr;
import java.util.Map;

public class LlmGatewayDetector implements LlmFallbackDetector {

    private final LlmGatewayClient llmGatewayClient;

    public LlmGatewayDetector(LlmGatewayClient llmGatewayClient) {
        this.llmGatewayClient = llmGatewayClient;
    }

    @Override
    public FieldUsageDetector.DetectionResult infer(ChangeEvent changeEvent, SparkSqlIr ir) {
        Map<String, Object> response = llmGatewayClient.inferUsage(changeEvent.getFieldName(), ir);
        // TODO interpret LLM response JSON
        ImpactEvidence evidence = new ImpactEvidence();
        evidence.setDecision(UsageDecision.UNKNOWN);
        evidence.setReasoning("LLM fallback not implemented");
        return new FieldUsageDetector.DetectionResult(UsageDecision.UNKNOWN, 0.5, evidence);
    }
}
