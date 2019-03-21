package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.IDevelopmentDAO;
import com.zhaw.ch.skill7.model.Development;

public class DevelopmentDAO extends GenericDAO<Development> implements IDevelopmentDAO {

    @Override
    protected void updateObject(Development object, Development newValuesObject) {
        object.setDevelopmentRating(newValuesObject.getDevelopmentRating());
    }
}
