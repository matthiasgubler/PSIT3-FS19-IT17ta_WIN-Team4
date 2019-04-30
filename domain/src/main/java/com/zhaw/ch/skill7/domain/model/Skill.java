package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.business.ServiceRegistry;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import com.zhaw.ch.skill7.model.IdUpdateableEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Skill extends IdUpdateableEntity<Skill> {

    private transient final IGenericDAO<Skill> skillIGenericDAO;

    private transient final IGenericDAO<SkillEmployeeRating> skillEmployeeRatingIGenericDAO;

    private transient final IGenericDAO<Development> developmentIGenericDAO;


    private String name;

    public Skill() {
        super();
        this.skillIGenericDAO = ServiceRegistry.getInstance().getSkillDAO();
        this.skillEmployeeRatingIGenericDAO = ServiceRegistry.getInstance().getSkillEmployeeRatingDAO();
        this.developmentIGenericDAO = ServiceRegistry.getInstance().getDevelopmentDAO();
    }

    private Skill(long id) {
        super(id);
        this.skillIGenericDAO = ServiceRegistry.getInstance().getSkillDAO();
        this.skillEmployeeRatingIGenericDAO = ServiceRegistry.getInstance().getSkillEmployeeRatingDAO();
        this.developmentIGenericDAO = ServiceRegistry.getInstance().getDevelopmentDAO();
    }

    public Skill(String name) {
        this();
        this.name = name;
    }

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
        return skillEmployeeRatingIGenericDAO.read().stream().filter(skillEmployeeRating -> skillEmployeeRating.getSkill().equals(this)).collect(Collectors.toList());
    }

    /**
     * Gibt die Anzahl der Personen zurück die diesen Skill als Weiterbildungswunsch eingetragen haben.
     *
     * @return Anzahl Weiterbildungswünsche
     */
    public int getSkillDevelopmentCount() {
        List<Development> developmentList = developmentIGenericDAO.read().stream().filter(development -> development.getSkill().equals(this)).collect(Collectors.toList());
        return developmentList.size();
    }

    public void update() {
        skillIGenericDAO.update(this);
    }
}
