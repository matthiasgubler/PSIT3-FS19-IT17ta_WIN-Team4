package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.model.IdUpdateableEntity;

import java.util.ArrayList;
import java.util.List;

public class SkillSet extends IdUpdateableEntity<SkillSet> {

    private List<Skill> skillList = new ArrayList<>();

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public void update(SkillSet objectWithNewData) {
        this.setSkillList(objectWithNewData.skillList);
    }
}
