package com.zhaw.ch.skill7.domain;

import com.zhaw.ch.skill7.business.ServiceRegistry;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import com.zhaw.ch.skill7.model.Skill;

public class SkillData extends Skill {

    private final IGenericDAO<Skill> skillIGenericDAO;

    public SkillData() {
        super();
        this.skillIGenericDAO = ServiceRegistry.getInstance().getSkillDAO();
    }

    public SkillData(String name) {
        super(name);
        this.skillIGenericDAO = ServiceRegistry.getInstance().getSkillDAO();
    }

    public SkillData(String name, IGenericDAO<Skill> skillIGenericDAO) {
        super(name);
        this.skillIGenericDAO = skillIGenericDAO;
    }

    public void update() {
        skillIGenericDAO.update(this);
    }

}
