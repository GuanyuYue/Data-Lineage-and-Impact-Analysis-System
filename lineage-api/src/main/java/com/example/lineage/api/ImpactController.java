package com.example.lineage.api;

import com.example.lineage.domain.model.ChangeEvent;
import com.example.lineage.domain.model.ImpactReport;
import com.example.lineage.impact.engine.ImpactInferenceEngine;
import java.time.Instant;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/impact")
public class ImpactController {

    private final ImpactInferenceEngine inferenceEngine;

    public ImpactController(ImpactInferenceEngine inferenceEngine) {
        this.inferenceEngine = inferenceEngine;
    }

    @PostMapping("/analyze")
    public ImpactReport analyze(@RequestBody ChangeEvent event) {
        // TODO add validation, auth, tracing
        ImpactReport report = new ImpactReport();
        report.setChangeEvent(event);
        report.setGeneratedAt(Instant.now());
        report.setTraceId(UUID.randomUUID().toString());
        report.setImpactedTables(inferenceEngine.analyze(event, 5));
        return report;
    }
}
