package com.zhaw.ch.skill7.model;

import com.zhaw.ch.skill7.domain.model.Skill;
import javafx.beans.property.SimpleStringProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AdminDevelopmentSkillUI extends SkillUI {
    private final SimpleStringProperty count = new SimpleStringProperty("");

    public AdminDevelopmentSkillUI(Skill skill, int count) {
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
