package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.model.IdUpdateableEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse SkillSet hält eine Liste von Skills als Template z.B. für einen neuen Mitarbeiter
 */
public class SkillSet extends IdUpdateableEntity<SkillSet> {

    private List<Skill> skillList = new ArrayList<>();

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    /**
     * Speichtert die Daten des objectWithNewData in das aktuelle SkillSet
     *
     * @param objectWithNewData Objekt mit den neuen Daten, die auf das Updateable Objekt übernommen werden
     */
    @Override
    public void update(SkillSet objectWithNewData) {
        this.setSkillList(objectWithNewData.skillList);
    }
}
