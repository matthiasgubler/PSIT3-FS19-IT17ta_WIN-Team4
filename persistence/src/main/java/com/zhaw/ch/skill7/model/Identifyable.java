package com.zhaw.ch.skill7.model;

import java.util.Objects;

public abstract class Identifyable {

    private long id;

    Identifyable() {
    }

    public Identifyable(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isIdEquals(Identifyable identifyable) {
        return this.getId() == identifyable.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identifyable)) return false;
        Identifyable that = (Identifyable) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
