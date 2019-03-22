package com.zhaw.ch.skill7.model;

import java.util.ArrayList;
import java.util.List;

public class Team extends IdUpdateableEntity<Team> {

    private String name;

    private List<Employee> employeeList = new ArrayList<>();

    private List<SkillRating> skillRatingList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<SkillRating> getSkillRatingList() {
        return skillRatingList;
    }

    public void setSkillRatingList(List<SkillRating> skillRatingList) {
        this.skillRatingList = skillRatingList;
    }

    public SkillTeamRating createSkillRating(int rating, Skill skill) {
        return new SkillTeamRating(rating, skill, this);
    }

    @Override
    public void update(Team objectWithNewData) {
        this.setName(objectWithNewData.getName());
    }
}
