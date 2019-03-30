package com.zhaw.ch.skill7.interfaces;

import com.zhaw.ch.skill7.domain.model.Employee;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.domain.model.Team;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICompany {

    void createSkill(String name);

    void deleteSkill(Skill skill);

    List<Skill> getSkills();

    void createTeam(String name);

    List<Team> getTeams();

    Optional<Team> getTeamById(long id);

    void createEmployee(String firstname, String lastname);

    List<Employee> getEmployees();

    Map<String, Long> getSkillDistribution();

    Map<String, Long> getDevelopmentDistribution();
}
