package com.zhaw.ch.skill7.interfaces;

import com.zhaw.ch.skill7.domain.model.SkillTeamRating;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public interface ISimplePropertySkillTeamRating {

    public String getSkill();

    public int getActualRating();

    public int getRequiredRating();

    public String getSemaphore();
}
