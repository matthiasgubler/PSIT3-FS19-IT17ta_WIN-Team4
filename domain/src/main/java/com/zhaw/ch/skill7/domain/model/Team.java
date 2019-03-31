package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.business.ServiceRegistry;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import com.zhaw.ch.skill7.model.IdUpdateableEntity;

import java.util.*;
import java.util.stream.Collectors;

public class Team extends IdUpdateableEntity<Team> {

    private final IGenericDAO<SkillTeamRating> skillRatingIGenericDAO;
    private final IGenericDAO<Employee> employeeIGenericDAO;

    public Team() {
        skillRatingIGenericDAO = ServiceRegistry.getInstance().getSkillTeamRatingDAO();
        employeeIGenericDAO = ServiceRegistry.getInstance().getEmployeeDAO();
    }

    public Team(IGenericDAO<SkillTeamRating> skillRatingIGenericDAO, IGenericDAO<Employee> employeeIGenericDAO) {
        this.skillRatingIGenericDAO = skillRatingIGenericDAO;
        this.employeeIGenericDAO = employeeIGenericDAO;
    }

    private String name;

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
        return employeeIGenericDAO.read().stream().filter(employee -> employee.getTeam().equals(this)).collect(Collectors.toList());
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

    public Map<String, Map<String, Long>> getMemberSkills() {
        Map<String, Map<String, Long>> result = new HashMap<>();

        List<SkillEmployeeRating> allSkillEmployeeRatingList = new ArrayList<>();
        for (Employee employee : getEmployeeList()) {
            allSkillEmployeeRatingList.addAll(employee.getSkillRatingList());
        }

        List<Skill> allSkillsInTeamList = allSkillEmployeeRatingList.stream().map(SkillEmployeeRating::getSkill).distinct().collect(Collectors.toList());
        for (Skill skill : allSkillsInTeamList) {
            Map<String, Long> employeePerSkillRating = allSkillEmployeeRatingList.stream().filter(skillEmployeeRating -> skillEmployeeRating.getSkill().equals(skill)).collect(Collectors.toMap(skillRating -> skillRating.getEmployee().getFirstname() + " " + skillRating.getEmployee().getLastname(), skillRating -> Integer.valueOf(skillRating.getRating()).longValue()));

            result.put(skill.getName(), employeePerSkillRating);
        }

        return result;
    }
}
