package com.zhaw.ch.skill7.model;

public class SkillRating {

    private long id;

    private int rating;

    private Skill skill;

    private Employee employee;

    private Team team;

    private SearchFilter searchFilter;

    private SkillRating(long id, int rating, Skill skill){
        this.id = id;
        this.rating = rating;
        this.skill = skill;

    }

    public SkillRating(long id, int rating, Skill skill, Employee employee){
        this(id, rating, skill);
        this.employee = employee;
    }

    public SkillRating(long id, int rating, Skill skill, Team team){
        this(id, rating, skill);
        this.team = team;
    }

    public SkillRating(long id, int rating, Skill skill, SearchFilter searchFilter){
        this(id, rating, skill);
        this.searchFilter = searchFilter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public SearchFilter getSearchFilter() {
        return searchFilter;
    }

    public void setSearchFilter(SearchFilter searchFilter) {
        this.searchFilter = searchFilter;
    }
}
