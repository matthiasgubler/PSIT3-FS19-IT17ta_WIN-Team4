package com.zhaw.ch.skill7.helper;

import java.util.List;

/**
 * Helper-Klasse für Mathematik-bezogene Methoden
 */
public final class MathHelper {

    private MathHelper() {
    }

    /**
     * Berechnet den Median einer Liste von Ineger
     *
     * @param m des Typs List&lt;Integer&gt;
     *          Enthät eine Liste von 0 oder mehr Integer, deren Median gesucht ist.
     * @return ganzzahliger Wert als int, der den Median repräsentiert.
     */
    public static int calculateMedian(List<Integer> m) {
        if(m.isEmpty()) {
            return 0;
        }
        int middle = m.size() / 2;
        if (m.size() % 2 == 1) {
            return m.get(middle);
        } else {
            return (m.get(middle - 1) + m.get(middle)) / 2;
        }
    }
}