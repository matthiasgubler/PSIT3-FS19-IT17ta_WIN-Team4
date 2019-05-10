package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.business.ServiceRegistry;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import com.zhaw.ch.skill7.model.IdUpdateableEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Repräsentation eines Skills innerhalb einer Company
 */
public class Skill extends IdUpdateableEntity<Skill> {

    private transient final IGenericDAO<SkillEmployeeRating> skillEmployeeRatingIGenericDAO;
    private transient final IGenericDAO<Development> developmentIGenericDAO;
    private String name;

    /**
     * Konstuktor eines Skills mit DAO's als Parameter
     *
     * @param skillEmployeeRatingIGenericDAO SkillEmployeeRating DAO für das Handling der Mitarbeiter-Ratings des Skills
     * @param developmentIGenericDAO Development DAO für das Handling der Weiterbildungen des Skills
     */
    public Skill(IGenericDAO<SkillEmployeeRating> skillEmployeeRatingIGenericDAO, IGenericDAO<Development> developmentIGenericDAO) {
        super();
        this.skillEmployeeRatingIGenericDAO = skillEmployeeRatingIGenericDAO;
        this.developmentIGenericDAO = developmentIGenericDAO;
    }

    /**
     * Instanziert ein Skill ohne Parameter
     */
    public Skill() {
        super();
        this.skillEmployeeRatingIGenericDAO = ServiceRegistry.getInstance().getSkillEmployeeRatingDAO();
        this.developmentIGenericDAO = ServiceRegistry.getInstance().getDevelopmentDAO();
    }

    /**
     * Instanziert ein Skill mit einer bestimmten ID
     *
     * @param id ID des Skills
     */
    private Skill(long id) {
        super(id);
        this.skillEmployeeRatingIGenericDAO = ServiceRegistry.getInstance().getSkillEmployeeRatingDAO();
        this.developmentIGenericDAO = ServiceRegistry.getInstance().getDevelopmentDAO();
    }

    /**
     * Instanziert ein Skill mit einem Namen
     *
     * @param name Name des Skills
     */
    public Skill(String name) {
        this();
        this.name = name;
    }

    /**
     * Instanziert ein Skill mit einer ID und einem Namen
     *
     * @param id ID des Skills
     * @param name Name des Skills
     */
    public Skill(long id, String name) {
        this(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Skill objectWithNewData) {
        this.setName(objectWithNewData.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        if (!super.equals(o)) return false;
        Skill skill = (Skill) o;
        return Objects.equals(getName(), skill.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName());
    }

    /**
     * Gibt eine Liste der SkillEmployeeRating zurück zu diesem Skill
     *
     * @return Die Liste der SkillEmployeeRatings
     */
    public List<SkillEmployeeRating> getSkillEmployeeRatings() {
        return skillEmployeeRatingIGenericDAO
                .read()
                .stream()
                .filter(skillEmployeeRating -> skillEmployeeRating.getSkill().equals(this))
                .collect(Collectors.toList());
    }

    /**
     * Gibt die Anzahl der Mitarbeiter zurück die diesen Skill als Weiterbildungswunsch eingetragen haben.
     *
     * @return Anzahl Weiterbildungswünsche
     */
    public int getSkillDevelopmentCount() {
        return getDevelopments().size();
    }

    /**
     * Gibt die Anzahl der Mitarbeiter zurück die diesen Skill als Weiterbildungswunsch eingetragen haben und mindestens
     * den mitgegebenen Rating Parameter entsprechen.
     *
     * @param developmentRating mindest Rating welches für die Rückgabe der Mitarbeiter berücksichtigt wird.
     *
     * @return Anzahl Weiterbildungswünsche
     */
    public int getSkillDevelopmentCountByRating(DevelopmentRating developmentRating) {
        return getDevelopments()
                .stream()
                .filter(development -> development.getDevelopmentRating().getIntValue() >= developmentRating.getIntValue())
                .collect(Collectors.toList())
                .size();
    }

    /**
     * Gibt eine Liste von Weiterbildungswünschen zurück welche diesen Skill beinhalten
     *
     * @return Liste Weiterbildungswünsche
     */
    public List<Development> getDevelopments() {
        return developmentIGenericDAO
                .read()
                .stream()
                .filter(development -> development.getSkill().equals(this))
                .collect(Collectors.toList());
    }

}
