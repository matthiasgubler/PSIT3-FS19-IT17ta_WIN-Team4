package com.zhaw.ch.skill7.interfaces;

import com.zhaw.ch.skill7.domain.model.Employee;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.domain.model.Team;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Interface für eine Company / Unternehmung
 */
public interface ICompany {

    /**
     * Erstellt einen neuen Skill innerhalb der Unternehmung
     *
     * @param name Name des Skills
     */
    void createSkill(String name);

    /**
     * Löscht einen Skill innerhalb einer Unternehmung
     *
     * @param skill der zu löschende Skill
     */
    void deleteSkill(Skill skill);

    /**
     * Gibt eine Liste aller Skills der Unternehmnung zurück
     *
     * @return Liste der Skills
     */
    List<Skill> getSkills();

    /**
     * Erstellt ein neues Team anhand des Teamnames
     *
     * @param name Name des Teams
     */
    void createTeam(String name);

    /**
     * Gibt eine Liste von allen Teams innerhalb des Unternehmens statt.
     * @return Liste der Teams
     */
    List<Team> getTeams();

    /**
     * Gibt einen Optional eines Teams innerhalb des Unternehmens zurück anhand dessen ID.
     * @param id ID des gesuchten Teams
     * @return Optional des Teams, welches abgefüllt ist, wenn das Team gefunden ist und sonst wird Optinal.empty() zurückgegeben.
     */
    Optional<Team> getTeamById(long id);

    /**
     * Erstellt einen neuen Mitarbeiter anhand des Vor- und des Nachnamens.
     * @param lastname Nachname des Mitarbeiters
     * @param firstname Vorname des Mitarbeiters
     */
    void createEmployee(String firstname, String lastname);

    /**
     * Gibt eine Liste aller Mitarbeiter in der Unternehmung zurück
     * @return Liste aller Mitarbeiter der Unternehmung
     */
    List<Employee> getEmployees();

    /**
     * Erstellt eine Map von allen Skills innerhalb der Unternehmung mit der Anzahl der Personen, welche diese besitzen.
     * @return Map&lt;String, Long&gt; der Skills, wobei der Key der Name des Skills als String ist und die Value die Anzahl der Mitarbeiter ist, welche den Skill innehaben.
     */
    Map<String, Long> getSkillDistribution();

    /**
     * Erstellt eine Map von allen Entwicklungsbedürfnisse innerhalb der Unternehmung
     * @return Map&lt;String, Long&gt; der Entwicklungsbedürfnisse, wobei der Key der Name des Bedarfs ist und die Value die Anzahl der Interessenten
     */
    Map<String, Long> getDevelopmentDistribution();

    /**
     * Erstellt eine Liste von Skills welche Entwicklungsbedürfnisse haben.
     * @return Liste mit Skills.
     */
    List<Skill> getSkillsForDevelopmentWorkshop();
}
