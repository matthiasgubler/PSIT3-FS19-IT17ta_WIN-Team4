package com.zhaw.ch.skill7.model;

import com.zhaw.ch.skill7.domain.model.Skill;
import javafx.beans.property.SimpleStringProperty;

public class SkillAdminDevelopmentUI extends SkillUI {
    private final SimpleStringProperty count = new SimpleStringProperty("");

    public SkillAdminDevelopmentUI(Skill skill, int count) {
        super(skill);
        setCount(String.valueOf(count));
    }

    public long getCount() {
        return Long.valueOf(count.get());
    }

    public void setCount(String count) {
        this.count.set(count);
    }

    public SimpleStringProperty countProperty() {
        return count;
    }
}
