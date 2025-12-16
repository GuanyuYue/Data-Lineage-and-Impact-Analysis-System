package com.example.lineage.domain.model;

import java.time.Instant;
import java.util.List;

public class ImpactReport {

    private ChangeEvent changeEvent;
    private Instant generatedAt;
    private List<ImpactResult> impactedTables;
    private String traceId;

    public ChangeEvent getChangeEvent() {
        return changeEvent;
    }

    public void setChangeEvent(ChangeEvent changeEvent) {
        this.changeEvent = changeEvent;
    }

    public Instant getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Instant generatedAt) {
        this.generatedAt = generatedAt;
    }

    public List<ImpactResult> getImpactedTables() {
        return impactedTables;
    }

    public void setImpactedTables(List<ImpactResult> impactedTables) {
        this.impactedTables = impactedTables;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
