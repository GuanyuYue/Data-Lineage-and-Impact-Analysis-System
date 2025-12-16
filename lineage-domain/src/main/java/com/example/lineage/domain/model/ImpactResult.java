package com.example.lineage.domain.model;

import com.example.lineage.domain.enums.RiskLevel;
import com.example.lineage.domain.enums.UsageDecision;
import java.util.List;

public class ImpactResult {

    private String tableId;
    private UsageDecision usageDecision;
    private RiskLevel riskLevel;
    private double confidence;
    private List<String> usageKinds;
    private ImpactEvidence evidence;
    private String jobId;
    private String jobType;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public UsageDecision getUsageDecision() {
        return usageDecision;
    }

    public void setUsageDecision(UsageDecision usageDecision) {
        this.usageDecision = usageDecision;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public List<String> getUsageKinds() {
        return usageKinds;
    }

    public void setUsageKinds(List<String> usageKinds) {
        this.usageKinds = usageKinds;
    }

    public ImpactEvidence getEvidence() {
        return evidence;
    }

    public void setEvidence(ImpactEvidence evidence) {
        this.evidence = evidence;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
}
