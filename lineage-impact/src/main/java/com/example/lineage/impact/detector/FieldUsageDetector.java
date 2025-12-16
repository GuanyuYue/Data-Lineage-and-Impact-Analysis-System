package com.example.lineage.impact.detector;

import com.example.lineage.domain.enums.UsageDecision;
import com.example.lineage.domain.model.ChangeEvent;
import com.example.lineage.domain.model.ImpactEvidence;
import com.example.lineage.parser.model.SparkSqlIr;

public interface FieldUsageDetector {

    DetectionResult detect(ChangeEvent changeEvent, SparkSqlIr ir);

    class DetectionResult {
        private UsageDecision decision;
        private double confidence;
        private ImpactEvidence evidence;

        public DetectionResult(UsageDecision decision, double confidence, ImpactEvidence evidence) {
            this.decision = decision;
            this.confidence = confidence;
            this.evidence = evidence;
        }

        public UsageDecision getDecision() {
            return decision;
        }

        public double getConfidence() {
            return confidence;
        }

        public ImpactEvidence getEvidence() {
            return evidence;
        }
    }
}
