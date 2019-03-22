package com.zhaw.ch.skill7.interfaces;

import com.zhaw.ch.skill7.model.Employee;
import com.zhaw.ch.skill7.model.Skill;
import com.zhaw.ch.skill7.model.Team;

import java.util.List;

public interface ICompany {

    void createSkill(String name);

    List<Skill> getSkills();

    void createTeam(String name);

    List<Team> getTeams();

    void createEmployee(String firstname, String lastname);

    List<Employee> getEmployees();

}
