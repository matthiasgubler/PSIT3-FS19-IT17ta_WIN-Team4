package com.zhaw.ch.skill7.domain.model;

/**
 * Enum für die Bewertung des Entwicklungsbedürfnisses. Gibt an wie gross der Bedarf für die Entwicklung ist.
 */
public enum DevelopmentRating {
    /**
     * Tiefer Entwicklungsbedarf, LOW = 1
     */
    LOW(1),

    /**
     * Mittlerer Entwicklungsbedarf, MEDIUM = 2
     */
    MEDIUM(2),

    /**
     * Hoher Entwicklungsbedarf, HIGH = 3
     */
    HIGH(3);

    private final int intValue;

    DevelopmentRating(int value) {
        this.intValue = value;
    }

    /**
     * Gibt den Wert des Entwicklungsbedürfnisses als int zurück
     *
     * @return int Wert des Entwicklungsbedürfnisses
     */
    public int getIntValue() {
        return intValue;
    }
}
