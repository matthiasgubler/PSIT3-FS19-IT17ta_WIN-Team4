package com.zhaw.ch.skill7.model;

import java.util.ArrayList;
import java.util.List;

public class Employee extends IdUpdateableEntity<Employee> {

    private String surname;

    private String firstname;

    private List<SkillRating> skillRatingList = new ArrayList<>();

    private Team team;

    private AvailabilityPlan availabilityPlan;

    public Employee(String surname, String firstname, Team team, AvailabilityPlan availabilityPlan) {
        this.surname = surname;
        this.firstname = firstname;
        this.team = team;
        this.availabilityPlan = availabilityPlan;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<SkillRating> getSkillRatingList() {
        return skillRatingList;
    }

    public void setSkillRatingList(List<SkillRating> skillRatingList) {
        this.skillRatingList = skillRatingList;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public AvailabilityPlan getAvailabilityPlan() {
        return availabilityPlan;
    }

    public void setAvailabilityPlan(AvailabilityPlan availabilityPlan) {
        this.availabilityPlan = availabilityPlan;
    }

    @Override
    public void update(Employee objectWithNewData) {
        this.setFirstname(objectWithNewData.getFirstname());
        this.setSurname(objectWithNewData.getSurname());
        this.setTeam(objectWithNewData.getTeam());
    }
}
