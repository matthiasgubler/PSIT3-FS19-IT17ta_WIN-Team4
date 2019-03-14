package com.zhaw.ch.skill7.interfaces;

import com.zhaw.ch.skill7.model.Skill;

import java.util.List;

public interface ISkillDAO {

    List<Skill> readSkills();

    void addSkill(Skill skill);

    void removeSkill(Skill skill);

    void updateSkill(Skill skill);

}
