package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.model.IdUpdateableEntity;

public abstract class SkillReference<T> extends IdUpdateableEntity<T> {

    private Skill skill;

    SkillReference(Skill skill){
        this.skill = skill;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

}
