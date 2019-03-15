package com.zhaw.ch.skill7.interfaces;

import com.zhaw.ch.skill7.model.Team;

import java.util.List;

public interface ITeamDAO {

    List<Team> readTeams();

    void addTeam(Team team);

    void removeTeam(Team team);

    void updateTeam(Team team);


}
