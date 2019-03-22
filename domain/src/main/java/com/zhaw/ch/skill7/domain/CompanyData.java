package com.zhaw.ch.skill7.domain;

import com.zhaw.ch.skill7.business.ServiceRegistry;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import com.zhaw.ch.skill7.model.Employee;
import com.zhaw.ch.skill7.model.Skill;
import com.zhaw.ch.skill7.model.Team;

import java.util.List;

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


}
