package com.zhaw.ch.skill7.domain;

import com.zhaw.ch.skill7.business.ServiceRegistry;
import com.zhaw.ch.skill7.domain.model.Employee;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.domain.model.SkillEmployeeRating;
import com.zhaw.ch.skill7.domain.model.Team;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyData implements ICompany {

    private final IGenericDAO<Skill> skillIGenericDAO;
    private final IGenericDAO<Employee> employeeIGenericDAO;
    private final IGenericDAO<Team> teamIGenericDAO;

    public CompanyData() {
        this.skillIGenericDAO = ServiceRegistry.getInstance().getSkillDAO();
        this.employeeIGenericDAO = ServiceRegistry.getInstance().getEmployeeDAO();
        this.teamIGenericDAO = ServiceRegistry.getInstance().getTeamDAO();
    }

    public CompanyData(IGenericDAO<Skill> skillIGenericDAO, IGenericDAO<Employee> employeeIGenericDAO, IGenericDAO<Team> teamIGenericDAO) {
        this.skillIGenericDAO = skillIGenericDAO;
        this.employeeIGenericDAO = employeeIGenericDAO;
        this.teamIGenericDAO = teamIGenericDAO;
    }

    public void createSkill(String name) {
        skillIGenericDAO.add(new Skill(name));
    }

    public void deleteSkill(Skill skill) {
        skillIGenericDAO.remove(skill);
    }

    public List<Skill> getSkills() {
        return skillIGenericDAO.read();
    }

    @Override
    public void createTeam(String name) {
        teamIGenericDAO.add(new Team(name));
    }

    @Override
    public List<Team> getTeams() {
        return teamIGenericDAO.read();
    }

    @Override
    public void createEmployee(String lastname, String firstname) {
        employeeIGenericDAO.add(new Employee(lastname, firstname));
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeIGenericDAO.read();
    }

    @Override
    public Map<String, Integer> getSkillDistribution() {
        Map<String, Integer> result = new HashMap<>();

        List<Skill> skillList = getSkills();
        for (Skill skill : skillList) {
            List<SkillEmployeeRating> skillEmployeeRatingList = skill.getSkillEmployeeRatings();
            result.put(skill.getName(), skillEmployeeRatingList.size());
        }

        return result;
    }


}
