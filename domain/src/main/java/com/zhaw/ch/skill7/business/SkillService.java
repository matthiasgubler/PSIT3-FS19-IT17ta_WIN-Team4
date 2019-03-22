package com.zhaw.ch.skill7.business;

import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import com.zhaw.ch.skill7.interfaces.ISkillService;
import com.zhaw.ch.skill7.model.Skill;

import java.util.List;

public class SkillService implements ISkillService {

    private final IGenericDAO<Skill> skillDAO;

    public SkillService() {
        this.skillDAO = ServiceRegistry.getInstance().getSkillDAO();
    }

    public SkillService(IGenericDAO<Skill> skillDAO) {
        this.skillDAO = skillDAO;
    }

    @Override
    public void createSkill(Skill skill) {
        skillDAO.add(skill);
    }

    public List<Skill> readSkills() {
        return skillDAO.read();
    }
}