package com.zhaw.ch.skill7.interfaces;

import com.zhaw.ch.skill7.model.Skill;

import java.util.List;

public interface ISkillService {

    void createSkill(Skill skill);

    List<Skill> readSkills();

}
