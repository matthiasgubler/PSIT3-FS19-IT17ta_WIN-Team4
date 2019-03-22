package com.zhaw.ch.skill7.model;

import java.util.ArrayList;
import java.util.List;

public class Employee extends IdUpdateableEntity<Employee> {

    private String lastname;

    private String firstname;

    private List<SkillRating> skillRatingList = new ArrayList<>();

    private Team team;

    private AvailabilityPlan availabilityPlan;

    public Employee(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public Employee(String lastname, String firstname, Team team, AvailabilityPlan availabilityPlan) {
        this(lastname, firstname);
        this.team = team;
        this.availabilityPlan = availabilityPlan;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public SkillEmployeeRating createSkillRating(int rating, Skill skill) {
        return new SkillEmployeeRating(rating, skill, this);
    }

    @Override
    public void update(Employee objectWithNewData) {
        this.setFirstname(objectWithNewData.getFirstname());
        this.setLastname(objectWithNewData.getLastname());
        this.setTeam(objectWithNewData.getTeam());
    }
}
