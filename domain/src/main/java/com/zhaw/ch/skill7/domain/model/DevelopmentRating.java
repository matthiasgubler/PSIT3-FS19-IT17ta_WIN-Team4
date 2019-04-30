package com.zhaw.ch.skill7.domain.model;

public enum DevelopmentRating {
    /**
     * Tiefer Entwicklungsbedarf
     */
    LOW(1),

    /**
     * Mittlerer Entwicklungsbedarf
     */
    MEDIUM(2),

    /**
     * Hoher Entwicklungsbedarf
     */
    HIGH(3);

    private final int intValue;

    DevelopmentRating(int value) {
        this.intValue = value;
    }

    public int getIntValue() {
        return intValue;
    }
}
