package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.ITeamDAO;
import com.zhaw.ch.skill7.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamDAO implements ITeamDAO {

    private int currentId = 1;

    private List<Team> teamDatabase = new ArrayList<>();

    @Override
    public List<Team> readTeams() {
        return teamDatabase;
    }

    @Override
    public void addTeam(Team team) {
        team.setId(currentId++);
        teamDatabase.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        teamDatabase.remove(team);
    }

    @Override
    public void updateTeam(Team team) {
        for (Team currentTeam : teamDatabase) {
            if (currentTeam.getId() == team.getId()) {
                currentTeam.setName(team.getName());
            }
        }
    }
}
