package com.example.lineage.domain.enums;

public enum ConfidenceLevel {
    HIGH(0.9),
    MEDIUM(0.7),
    LOW(0.4),
    UNKNOWN(0.0);

    private final double score;

    ConfidenceLevel(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}
