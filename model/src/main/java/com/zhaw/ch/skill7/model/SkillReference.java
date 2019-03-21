package com.zhaw.ch.skill7.model;

public abstract class SkillReference extends Identifyable{

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
