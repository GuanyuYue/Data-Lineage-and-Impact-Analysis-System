package com.example.lineage.impact.detector;

import com.example.lineage.domain.model.ChangeEvent;
import com.example.lineage.domain.model.ImpactEvidence;
import com.example.lineage.parser.model.SparkSqlIr;

public interface LlmFallbackDetector {

    FieldUsageDetector.DetectionResult infer(ChangeEvent changeEvent, SparkSqlIr ir);

    // TODO integrate with LLM gateway client
}
