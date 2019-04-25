package com.zhaw.ch.skill7.domain;

import com.zhaw.ch.skill7.business.ServiceRegistry;
import com.zhaw.ch.skill7.domain.model.*;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CompanyData implements ICompany {

    private final IGenericDAO<Skill> skillIGenericDAO;
    private final IGenericDAO<Employee> employeeIGenericDAO;
    private final IGenericDAO<Team> teamIGenericDAO;
    private final IGenericDAO<Development> developmentIGenericDAO;

    public CompanyData() {
        this.skillIGenericDAO = ServiceRegistry.getInstance().getSkillDAO();
        this.employeeIGenericDAO = ServiceRegistry.getInstance().getEmployeeDAO();
        this.teamIGenericDAO = ServiceRegistry.getInstance().getTeamDAO();
        this.developmentIGenericDAO = ServiceRegistry.getInstance().getDevelopmentDAO();
    }

    public CompanyData(IGenericDAO<Skill> skillIGenericDAO, IGenericDAO<Employee> employeeIGenericDAO, IGenericDAO<Team> teamIGenericDAO, IGenericDAO<Development> developmentIGenericDAO) {
        this.skillIGenericDAO = skillIGenericDAO;
        this.employeeIGenericDAO = employeeIGenericDAO;
        this.teamIGenericDAO = teamIGenericDAO;
        this.developmentIGenericDAO = developmentIGenericDAO;
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

    private List<Development> getDevelompents() {
        return developmentIGenericDAO.read();
    }

    /**
     * Erstellt ein neues Team anhand des Teamnames
     *
     * @param name Name des Teams
     */
    @Override
    public void createTeam(String name) {
        teamIGenericDAO.add(new Team(name));
    }

    /**
     * Gibt eine Liste von allen Teams innerhalb des Unternehmens statt.
     * @return Liste der Teams
     */
    @Override
    public List<Team> getTeams() {
        return teamIGenericDAO.read();
    }

    /**
     * Gibt einen Optional eines Teams innerhalb des Unternehmens zurück anhand dessen ID.
     * @param id ID des gesuchten Teams
     * @return Optional des Teams, welches abgefüllt ist, wenn das Team gefunden ist und sonst wird Optinal.empty() zurückgegeben.
     */
    @Override
    public Optional<Team> getTeamById(long id) {
        return teamIGenericDAO.byId(id);
    }

    /**
     * Erstellt einen neuen Mitarbeiter anhand des Vor- und des Nachnamens.
     * @param lastname Nachname des Mitarbeiters
     * @param firstname Vorname des Mitarbeiters
     */
    @Override
    public void createEmployee(String lastname, String firstname) {
        employeeIGenericDAO.add(new Employee(lastname, firstname));
    }

    /**
     * Gibt eine Liste aller Mitarbeiter in der Unternehmung zurück
     * @return Liste aller Mitarbeiter der Unternehmung
     */
    @Override
    public List<Employee> getEmployees() {
        return employeeIGenericDAO.read();
    }

    /**
     * Erstellt eine Map von allen Skills innerhalb der Unternehmung mit der Anzahl der Personen, welche diese besitzen.
     * @return Map&lt;String, Long&gt; der Skills, wobei der Key der Name des Skills als String ist und die Value die Anzahl der Mitarbeiter ist, welche den Skill innehaben.
     */
    @Override
    public Map<String, Long> getSkillDistribution() {
        Map<String, Long> result = new HashMap<>();

        List<Skill> skillList = getSkills();
        for (Skill skill : skillList) {
            List<SkillEmployeeRating> skillEmployeeRatingList = skill.getSkillEmployeeRatings();
            result.put(skill.getName(), Integer.valueOf(skillEmployeeRatingList.size()).longValue());
        }

        return result;
    }

    /**
     * Erstellt eine Map von allen Entwicklungsbedürfnisse innerhalb der Unternehmung
     * @return Map&lt;String, Long&gt; der Entwicklungsbedürfnisse, wobei der Key der Name des Bedarfs ist und die Value die Anzahl der Interessenten
     */
    @Override
    public Map<String, Long> getDevelopmentDistribution() {
        List<Development> develompentList = getDevelompents();
        return develompentList.stream().collect(Collectors.groupingBy(developmentDistribution -> developmentDistribution.getSkill().getName(), Collectors.counting()));
    }

}
