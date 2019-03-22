package com.zhaw.ch.skill7.model;

public class Identifyable {

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
}
