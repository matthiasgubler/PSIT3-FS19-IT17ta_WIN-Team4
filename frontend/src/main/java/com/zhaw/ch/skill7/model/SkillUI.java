package com.zhaw.ch.skill7.model;

import javafx.beans.property.SimpleStringProperty;

public class SkillUI extends Skill{
    private final SimpleStringProperty id = new SimpleStringProperty("");
    private final SimpleStringProperty name = new SimpleStringProperty("");

    public SkillUI(Skill skill) {
        setId(String.valueOf(skill.getId()));
        setName(skill.getName());
    }

    public long getId() {
        return Long.valueOf(id.get());
    }

    private void setId(String id) {
        this.id.set(id);
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public String getNameProperty() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }
}
