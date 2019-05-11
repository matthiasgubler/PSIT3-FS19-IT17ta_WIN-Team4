package com.zhaw.ch.skill7.domain.model;

/**
 * Referenzklasse zwischen einem Employee und einem Skill inkl. Bewertung des Können/Skill/Rating
 */
public class SkillEmployeeRating extends SkillRating{

    private Employee employee;

    public SkillEmployeeRating(int rating, Skill skill, Employee employee){
        super(rating, skill);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
