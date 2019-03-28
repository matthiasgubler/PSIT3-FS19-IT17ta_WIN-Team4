package com.zhaw.ch.skill7.model;

public abstract class IdUpdateableEntity<T> extends Identifyable implements Updateable<T> {

    public IdUpdateableEntity() {
    }

    public IdUpdateableEntity(long id) {
        super(id);
    }
}
