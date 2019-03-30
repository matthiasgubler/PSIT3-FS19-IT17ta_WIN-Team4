package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.business.ServiceRegistry;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import com.zhaw.ch.skill7.model.IdUpdateableEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Team extends IdUpdateableEntity<Team> {

    private final IGenericDAO<SkillTeamRating> skillRatingIGenericDAO;

    public Team() {
        skillRatingIGenericDAO = ServiceRegistry.getInstance().getSkillTeamRatingDAO();
    }

    public Team(IGenericDAO<SkillTeamRating> skillRatingIGenericDAO) {
        this.skillRatingIGenericDAO = skillRatingIGenericDAO;
    }

    private String name;

    private List<Employee> employeeList = new ArrayList<>();

    public Team(String name) {
        this();
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

    public List<SkillTeamRating> getSkillRatingList() {
        return skillRatingIGenericDAO.read().stream().filter(skillTeamRating -> skillTeamRating.getTeam().equals(this)).collect(Collectors.toList());
    }

    public void addSkillRating(SkillTeamRating skillTeamRating) {
        skillTeamRating.setTeam(this);
        skillRatingIGenericDAO.add(skillTeamRating);
    }

    public SkillTeamRating createSkillRating(int rating, Skill skill) {
        return new SkillTeamRating(rating, skill, this);
    }

    @Override
    public void update(Team objectWithNewData) {
        this.setName(objectWithNewData.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;
        if (!super.equals(o)) return false;
        Team team = (Team) o;
        return Objects.equals(getName(), team.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName());
    }

    public Map getSkillNeeds() {
        return getSkillRatingList().stream().collect(Collectors.toMap(skillRating -> skillRating.getSkill().getName(), skillRating -> Integer.valueOf(skillRating.getRating()).longValue()));
    }
}
