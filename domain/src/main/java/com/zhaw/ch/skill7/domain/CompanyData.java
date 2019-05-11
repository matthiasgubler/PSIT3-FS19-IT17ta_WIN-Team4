package com.zhaw.ch.skill7.domain;

import com.zhaw.ch.skill7.business.ServiceRegistry;
import com.zhaw.ch.skill7.domain.model.*;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Die Klasse CompanyData repräsentiert das konkrete Unternehmen
 */
public class CompanyData implements ICompany {

    private final IGenericDAO<Skill> skillIGenericDAO;
    private final IGenericDAO<Employee> employeeIGenericDAO;
    private final IGenericDAO<Team> teamIGenericDAO;
    private final IGenericDAO<Development> developmentIGenericDAO;

    /**
     * Globale Steuerung, bei welchem Schwellwert von Anzahl der Mitarbeiter (Entwicklungsbedürfnisse) ein Workshop durchgeführt werden soll
     */
    public static int thresholdCountEmployees = 3;

    /**
     * Globale Steuerung, bei welchem Schwellwert von DevelopmentRating ein Workshop durchgeführt werden soll
     */
    public static DevelopmentRating thresholdDevelopmentRating = DevelopmentRating.MEDIUM;

    /**
     * Konstruktor zur Instanzierung einer CompanyData / Unternehmung
     */
    public CompanyData() {
        this.skillIGenericDAO = ServiceRegistry.getInstance().getSkillDAO();
        this.employeeIGenericDAO = ServiceRegistry.getInstance().getEmployeeDAO();
        this.teamIGenericDAO = ServiceRegistry.getInstance().getTeamDAO();
        this.developmentIGenericDAO = ServiceRegistry.getInstance().getDevelopmentDAO();
    }

    /**
     * Konstruktor zur Instanzierung einer CompanyData / Unternehmung mit den entsprechenden DAOs
     *
     * @param skillIGenericDAO       Skill DAO
     * @param employeeIGenericDAO    Employee DAO
     * @param teamIGenericDAO        Team DAO
     * @param developmentIGenericDAO Development DAO
     */
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

    public List<Development> getDevelopments() {
        return developmentIGenericDAO.read();
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
    public Optional<Team> getTeamById(long id) {
        return teamIGenericDAO.byId(id);
    }

    @Override
    public void createEmployee(String lastname, String firstname) {
        employeeIGenericDAO.add(new Employee(lastname, firstname));
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeIGenericDAO.read();
    }

    /**
     * Liefert eine Map&lt;String, Long&gt; mit der Information über die einzelnen Skills im Unternehmen und wieviele Mitarbeiter diesen Skill besitzen.
     *
     * @return Map mit dem Skill-Name als Key und der Anzahl der Mitarbeiter die diesen Skill besitzen als Value
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
     * Liefert eine Map&lt;String, Long&gt; mit der Information über die einzelnen Entwicklungsbedürfnisse im Unternehmen und wieviele Mitarbeiter dieses Entwicklungsbedürfnis besitzen.
     * @return Map mit dem Skill-Name als Key und der Anzahl der Mitarbeiter die dieses Entwicklungsbedürfnis besitzen als Value
     */
    @Override
    public Map<String, Long> getDevelopmentDistribution() {
        List<Development> develompentList = getDevelopments();
        return develompentList.stream().collect(Collectors.groupingBy(developmentDistribution -> developmentDistribution.getSkill().getName(), Collectors.counting()));
    }

    /**
     * Liefert eine List&lt;String&gt; mit allen Skills die in der Auswertung der Entwicklungsbedürfnisse auftreten.
     *
     * @return Liste der Skills, für welche eine Workshop vorgeschlagen wird
     */
    @Override
    public List<Skill> getSkillsForDevelopmentWorkshop() {
        List<Skill> skillList = getSkills()
                .stream()
                .filter(skill -> skill.getSkillDevelopmentCountByRating(thresholdDevelopmentRating) >= thresholdCountEmployees)
                .collect(Collectors.toList());

        skillList.sort(Comparator.comparing(Skill::getId));
        return skillList;
    }

}
