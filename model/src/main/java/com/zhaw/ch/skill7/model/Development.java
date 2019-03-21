package com.zhaw.ch.skill7.model;

public class Development extends SkillReference {

    private long id;

    private DevelopmentRating developmentRating;

    private Employee employee;

    public Development(Skill skill, DevelopmentRating developmentRating, Employee employee) {
        super(skill);
        this.developmentRating = developmentRating;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DevelopmentRating getDevelopmentRating() {
        return developmentRating;
    }

    public void setDevelopmentRating(DevelopmentRating developmentRating) {
        this.developmentRating = developmentRating;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
