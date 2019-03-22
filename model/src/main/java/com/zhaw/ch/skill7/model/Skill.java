package com.zhaw.ch.skill7.model;

public class Skill extends IdUpdateableEntity<Skill> {

    private String name;

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Skill objectWithNewData) {
        this.setName(objectWithNewData.getName());
    }
}
