package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.ITeamDAO;
import com.zhaw.ch.skill7.model.Team;

public class TeamDAO extends GenericDAO<Team> implements ITeamDAO {

    @Override
    protected void updateObject(Team object, Team newValuesObject) {
        object.setName(newValuesObject.getName());
    }
}
