package com.example.lineage.impact.detector;

import com.example.lineage.domain.enums.UsageDecision;
import com.example.lineage.domain.model.ChangeEvent;
import com.example.lineage.domain.model.ImpactEvidence;
import com.example.lineage.parser.model.SparkSqlIr;
import java.util.ArrayList;
import java.util.List;

public class RuleBasedDetector implements FieldUsageDetector {

    @Override
    public DetectionResult detect(ChangeEvent changeEvent, SparkSqlIr ir) {
        String field = changeEvent.getFieldName();
        List<String> matches = new ArrayList<>();
        List<String> udfCalls = new ArrayList<>();
        boolean matched = false;
        boolean hasStar = ir.isHasStarSelect();

        // TODO actual parsing of expressions
        // placeholder iteration over lists
        if (ir.getSelectExprs() != null) {
            ir.getSelectExprs().stream()
                    .filter(expr -> expr.contains(field))
                    .forEach(expr -> { matched = true; matches.add(expr); });
        }
        if (ir.getWherePredicates() != null) {
            ir.getWherePredicates().stream()
                    .filter(expr -> expr.contains(field))
                    .forEach(expr -> { matched = true; matches.add(expr); });
        }
        if (ir.getJoinConditions() != null) {
            ir.getJoinConditions().stream()
                    .filter(expr -> expr.contains(field))
                    .forEach(expr -> { matched = true; matches.add(expr); });
        }
        if (ir.getGroupByFields() != null) {
            ir.getGroupByFields().stream()
                    .filter(expr -> expr.contains(field))
                    .forEach(expr -> { matched = true; matches.add(expr); });
        }
        if (ir.getUdfCalls() != null) {
            ir.getUdfCalls().stream()
                    .filter(expr -> expr.contains(field))
                    .forEach(expr -> { matched = true; udfCalls.add(expr); });
        }

        ImpactEvidence evidence = new ImpactEvidence();
        evidence.setMatchedExpressions(matches);
        evidence.setUdfCalls(udfCalls);
        evidence.setStarSelect(hasStar);
        evidence.setDecision(hasStar && !matched ? UsageDecision.UNKNOWN : matched ? UsageDecision.USED : UsageDecision.NOT_USED);
        evidence.setReasoning("Rule based evaluation");

        UsageDecision decision = evidence.getDecision();
        double confidence;
        if (decision == UsageDecision.USED) {
            confidence = 0.9;
        } else if (decision == UsageDecision.NOT_USED) {
            confidence = 0.8;
        } else {
            confidence = 0.5;
        }
        return new DetectionResult(decision, confidence, evidence);
    }
}
