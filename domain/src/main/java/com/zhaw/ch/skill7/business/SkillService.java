package com.zhaw.ch.skill7.business;

import com.zhaw.ch.skill7.interfaces.ISkillDAO;
import com.zhaw.ch.skill7.interfaces.ISkillService;
import com.zhaw.ch.skill7.model.Skill;

import java.util.List;

public class SkillService implements ISkillService {

    private ISkillDAO skillDAO;

    public SkillService() {
        this.skillDAO = ServiceRegistry.getInstance().getSkillDAO();
    }

    public SkillService(ISkillDAO skillDAO) {
        this.skillDAO = skillDAO;
    }

    @Override
    public void createSkill(Skill skill) {
        skillDAO.addSkill(skill);
    }

    public List<Skill> readSkills() {
        return skillDAO.readSkills();
    }
}