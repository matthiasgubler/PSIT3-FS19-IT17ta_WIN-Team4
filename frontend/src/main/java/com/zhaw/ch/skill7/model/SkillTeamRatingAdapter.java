package com.zhaw.ch.skill7.model;

import com.zhaw.ch.skill7.domain.model.SkillTeamRating;
import com.zhaw.ch.skill7.interfaces.ISkillTeamRating;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SkillTeamRatingAdapter implements ISkillTeamRating {

    private SkillTeamRating skillTeamRating;
    private SimpleStringProperty skill;
    private SimpleIntegerProperty actualRating;
    private SimpleIntegerProperty requiredRating;
    private SimpleStringProperty semaphore;

    public SkillTeamRatingAdapter(SkillTeamRating skillTeamRating) {
        this.skillTeamRating = skillTeamRating;
        skill = new SimpleStringProperty();
        actualRating = new SimpleIntegerProperty();
        requiredRating = new SimpleIntegerProperty();
        semaphore = new SimpleStringProperty();
    }

    @Override
    public String getSkill() {
        this.skill.set(this.skillTeamRating.getSkill().getName());
        return this.skill.get();
    }

    @Override
    public int getActualRating() {
        this.actualRating.set(this.skillTeamRating.getActualRating());
        return this.actualRating.get();
    }

    @Override
    public int getRequiredRating() {
        this.requiredRating.set(this.skillTeamRating.getRequiredRating());
        return this.requiredRating.get();
    }

    @Override
    public String getSemaphore() {
        this.semaphore.set(this.skillTeamRating.getSemaphoreString());
        return this.semaphore.get();
    }
}
