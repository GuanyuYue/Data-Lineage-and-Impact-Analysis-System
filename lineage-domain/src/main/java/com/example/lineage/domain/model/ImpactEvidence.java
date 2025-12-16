package com.example.lineage.domain.model;

import com.example.lineage.domain.enums.UsageDecision;
import java.util.List;

public class ImpactEvidence {

    private UsageDecision decision;
    private List<String> matchedExpressions;
    private List<String> udfCalls;
    private boolean starSelect;
    private String reasoning;

    public UsageDecision getDecision() {
        return decision;
    }

    public void setDecision(UsageDecision decision) {
        this.decision = decision;
    }

    public List<String> getMatchedExpressions() {
        return matchedExpressions;
    }

    public void setMatchedExpressions(List<String> matchedExpressions) {
        this.matchedExpressions = matchedExpressions;
    }

    public List<String> getUdfCalls() {
        return udfCalls;
    }

    public void setUdfCalls(List<String> udfCalls) {
        this.udfCalls = udfCalls;
    }

    public boolean isStarSelect() {
        return starSelect;
    }

    public void setStarSelect(boolean starSelect) {
        this.starSelect = starSelect;
    }

    public String getReasoning() {
        return reasoning;
    }

    public void setReasoning(String reasoning) {
        this.reasoning = reasoning;
    }
}
