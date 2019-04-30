package com.zhaw.ch.skill7.model;

import com.zhaw.ch.skill7.domain.model.Team;
import com.zhaw.ch.skill7.interfaces.ICompany;
import javafx.util.StringConverter;

public class TeamComboBoxConverter extends StringConverter<Team> {

    private final ICompany company;

    public TeamComboBoxConverter(ICompany company) {
        this.company = company;
    }

    @Override
    public String toString(Team team) {
        return team.getId() + ", " + team.getName();
    }

    @Override
    public Team fromString(String teamAsString) {
        return company.getTeamById(Long.valueOf(teamAsString.split(",")[0])).orElseThrow(() -> new IllegalArgumentException("No Team found with " + teamAsString));
    }

}
