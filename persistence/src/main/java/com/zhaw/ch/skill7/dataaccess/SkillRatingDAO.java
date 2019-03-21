package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.ISkillRatingDAO;
import com.zhaw.ch.skill7.model.SkillRating;

public class SkillRatingDAO extends GenericDAO<SkillRating> implements ISkillRatingDAO {

    @Override
    protected void updateObject(SkillRating object, SkillRating newValuesObject) {
        object.setRating(newValuesObject.getRating());
    }
}
