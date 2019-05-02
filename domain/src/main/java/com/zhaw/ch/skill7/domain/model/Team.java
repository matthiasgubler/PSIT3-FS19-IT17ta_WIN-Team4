package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.business.ServiceRegistry;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import com.zhaw.ch.skill7.model.IdUpdateableEntity;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Repräsentation eines Teams innerhalb einer Company
 */
public class Team extends IdUpdateableEntity<Team> {

    private final IGenericDAO<SkillTeamRating> skillRatingIGenericDAO;

    private final IGenericDAO<Employee> employeeIGenericDAO;

    private static final int EVALUATION_THRESHOLD = 2;

    public Team() {
        skillRatingIGenericDAO = ServiceRegistry.getInstance().getSkillTeamRatingDAO();
        employeeIGenericDAO = ServiceRegistry.getInstance().getEmployeeDAO();
    }

    /**
     * Konstuktor eines Teams mit DAO's als Parameter
     *
     * @param skillRatingIGenericDAO SkillRating DAO für das Handling der Skill Ratings des Teams
     * @param employeeIGenericDAO    Employee DAO für das Handling der Mitarbeiter des Teams
     */
    public Team(IGenericDAO<SkillTeamRating> skillRatingIGenericDAO, IGenericDAO<Employee> employeeIGenericDAO) {
        this.skillRatingIGenericDAO = skillRatingIGenericDAO;
        this.employeeIGenericDAO = employeeIGenericDAO;
    }

    private String name;

    /**
     * Instanziert ein Team mit einem Teamnamen
     *
     * @param name Name des Teams
     */
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

    /**
     * Gibt die Liste aller Mitarbeiter des Teams zurück
     *
     * @return Liste der Mitarbeiter
     */
    public List<Employee> getEmployeeList() {
        return employeeIGenericDAO.read().stream().filter(employee -> employee.getTeam().equals(this)).collect(Collectors.toList());
    }

    /**
     * Gibt die Liste aller Skills die das Team benötigt zurück
     * @return Liste der SkillTeamRatings
     */
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

    /**
     * Lädt die Liste aller Skills die ein Team benötigt als Map&lt;String, Long&gt;
     *
     * @return Map der Skills die ein Team benötigt. Der Key ist der Name des Skills als String und der Long ist die Bewertung der Wichtigkeit des Skills
     */
    public Map<String, Long> getSkillNeeds() {
        return getSkillRatingList().stream().collect(Collectors.toMap(skillRating -> skillRating.getSkill().getName(), skillRating -> Integer.valueOf(skillRating.getRating()).longValue()));
    }

    /**
     * Lädt die Skills der Mitarbeiter im Team und bereitet diese als Map&lt;String, Map&lt;String, Long&gt;&gt; aufbereitet
     *
     * @return Verschachtelte Map der Mitarbeiter und deren Skills
     * Der Key ist jeweils der Skill-Name als String um Value befindet sich eine weitere Map, dessen Key der Name des Mitarbeiters als String ist und der Value das SkillRating des Mitarbeiter ist.
     */
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

    /**
     * Evaluiert das Team-Objekt in Bezug auf dessen Skill-Needs und Skills der Mitglieder.
     *
     * @return TeamEvaluation Objekt, welches eine Map<String, SkillEvaluation> enthält.
     * Diese Map enthält die Evaluation jedes Skill-Needs des Teams.
     */
    public TeamEvaluation evaluateTeam() {
        TeamEvaluation teamEvaluation = new TeamEvaluation(this);

        Map<String, Long> skillNeeds = getSkillNeeds();
        Map<String, Map<String, Long>> memberSkills = getMemberSkills();
        Map<String, Long> specificMemberSkills;

        for(Map.Entry<String, Long> need : skillNeeds.entrySet()) {
            SkillEvaluation skillEvaluation = new SkillEvaluation(need.getKey());
            skillEvaluation.setRequiredRating(need.getValue());
            skillEvaluation.setActualRating(0L);

            specificMemberSkills = memberSkills.get(need.getKey());

            if(specificMemberSkills != null) {
                for(Map.Entry<String, Long> specificSkill : specificMemberSkills.entrySet()) {
                    Long rating = specificSkill.getValue();
                    if(rating > skillEvaluation.getActualRating()) {
                        skillEvaluation.setActualRating(specificSkill.getValue());
                    }
                }
            }

            if(skillRequirementMet(skillEvaluation)) {
                skillEvaluation.setStatusMessage(Semaphore.GREEN.toString());
            } else if((skillEvaluation.getRequiredRating() - skillEvaluation.getActualRating() <= EVALUATION_THRESHOLD)) {
                skillEvaluation.setStatusMessage(Semaphore.YELLOW.toString());
            } else {
                skillEvaluation.setStatusMessage(Semaphore.RED.toString());
            }

            teamEvaluation.addEvaluation(need.getKey(), skillEvaluation);
        }


        return teamEvaluation;
    }

    private boolean skillRequirementMet(SkillEvaluation skillEvaluation) {
        return skillEvaluation.getActualRating() >= skillEvaluation.getRequiredRating();
    }
}
