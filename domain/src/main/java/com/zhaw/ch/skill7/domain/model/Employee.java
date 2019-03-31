package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.business.ServiceRegistry;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import com.zhaw.ch.skill7.model.IdUpdateableEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Employee extends IdUpdateableEntity<Employee> {

    private final IGenericDAO<SkillEmployeeRating> skillRatingIGenericDAO;

    private String lastname;

    private String firstname;

    private Team team;

    private AvailabilityPlan availabilityPlan;

    public Employee() {
        this.skillRatingIGenericDAO = ServiceRegistry.getInstance().getSkillEmployeeRatingDAO();
    }

    public Employee(String lastname, String firstname) {
        this();
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

    public List<SkillEmployeeRating> getSkillRatingList() {
        return skillRatingIGenericDAO.read().stream().filter(skillEmployeeRating -> skillEmployeeRating.getEmployee().equals(this)).collect(Collectors.toList());
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
