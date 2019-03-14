package com.zhaw.ch.skill7.model;

import java.util.ArrayList;
import java.util.List;

public class SkillSet {

    private long id;

    private List<Skill> skillList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }
}
