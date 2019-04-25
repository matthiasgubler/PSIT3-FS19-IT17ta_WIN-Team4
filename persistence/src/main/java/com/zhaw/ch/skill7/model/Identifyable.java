package com.zhaw.ch.skill7.model;

import java.util.Objects;

/**
 * Objekt welches idenzifizierbar ist (eine ID besitzt)
 */
public abstract class Identifyable {

    private long id;

    Identifyable() {
    }

    /**
     * Instanziert ein Identifyable Objekt mit einer ID
     *
     * @param id die zu setzende ID
     */
    public Identifyable(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Vergleicht zwei Identifyable Objekte anhand der ID
     * @param identifyable Objekt, welches mit dem aktuellen Objekt verglichen wird
     * @return True, wenn die beiden Objekte die gleiche ID haben.
     */
    public boolean isIdEquals(Identifyable identifyable) {
        return this.getId() == identifyable.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identifyable)) return false;
        Identifyable that = (Identifyable) o;
        return isIdEquals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
