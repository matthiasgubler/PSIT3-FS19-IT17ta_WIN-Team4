package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.ISkillDAO;
import com.zhaw.ch.skill7.model.Skill;

public class SkillDAO extends GenericDAO<Skill> implements ISkillDAO {

    @Override
    protected void updateObject(Skill object, Skill newValuesObject) {
        object.setName(newValuesObject.getName());
    }

}
