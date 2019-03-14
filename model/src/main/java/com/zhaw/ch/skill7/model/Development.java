package com.zhaw.ch.skill7.model;

public class Development {

    private String name;

    private DevelopmentRating developmentRating;

    private Employee employee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
