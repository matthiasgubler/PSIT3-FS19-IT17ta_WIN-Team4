package com.zhaw.ch.skill7.model;

public class SkillTeamRating extends SkillRating{

    private Team team;

    public SkillTeamRating(int rating, Skill skill, Team team){
        super(rating, skill);
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
