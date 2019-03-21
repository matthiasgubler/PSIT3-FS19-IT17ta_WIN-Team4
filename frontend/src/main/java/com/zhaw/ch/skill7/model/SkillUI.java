package com.zhaw.ch.skill7.model;

import javafx.beans.property.SimpleStringProperty;

public class SkillUI {
    private final SimpleStringProperty id = new SimpleStringProperty("");
    private final SimpleStringProperty name = new SimpleStringProperty("");

    public SkillUI(Skill skill) {
        setId(String.valueOf(skill.getId()));
        setName(skill.getName());
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }
}
