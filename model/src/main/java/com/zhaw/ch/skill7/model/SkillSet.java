package com.zhaw.ch.skill7.model;

import java.util.ArrayList;
import java.util.List;

public class SkillSet extends Identifyable {

    private List<Skill> skillList = new ArrayList<>();

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }
}
