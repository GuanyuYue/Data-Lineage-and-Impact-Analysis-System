package com.example.lineage.domain.model;

public class JobLineage {

    private String edgeId;
    private String upstreamTableId;
    private String downstreamTableId;
    private String jobId;
    private String jobType;
    private String rawScript;
    private String scriptDigest;

    public String getEdgeId() {
        return edgeId;
    }

    public void setEdgeId(String edgeId) {
        this.edgeId = edgeId;
    }

    public String getUpstreamTableId() {
        return upstreamTableId;
    }

    public void setUpstreamTableId(String upstreamTableId) {
        this.upstreamTableId = upstreamTableId;
    }

    public String getDownstreamTableId() {
        return downstreamTableId;
    }

    public void setDownstreamTableId(String downstreamTableId) {
        this.downstreamTableId = downstreamTableId;
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

    public String getRawScript() {
        return rawScript;
    }

    public void setRawScript(String rawScript) {
        this.rawScript = rawScript;
    }

    public String getScriptDigest() {
        return scriptDigest;
    }

    public void setScriptDigest(String scriptDigest) {
        this.scriptDigest = scriptDigest;
    }
}
