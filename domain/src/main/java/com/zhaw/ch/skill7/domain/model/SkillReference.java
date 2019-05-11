package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.model.IdUpdateableEntity;

/**
 * Referenz-Klasse um einen beliebigen Skill zu referenzieren
 *
 * @param <T> Gibt die Klasse an, welche den Skill referenziert
 */
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
