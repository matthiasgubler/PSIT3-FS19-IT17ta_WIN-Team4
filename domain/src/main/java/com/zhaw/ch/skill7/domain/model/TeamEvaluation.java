package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.model.IdUpdateableEntity;

import java.util.HashMap;
import java.util.Map;

public class TeamEvaluation extends IdUpdateableEntity<TeamEvaluation> {

    private Team team;
    private final Map<String, SkillEvaluation> evaluation = new HashMap<>();

    public TeamEvaluation(Team team) {
        this.team = team;
    }

    @Override
    public void update(TeamEvaluation objectWithNewData) {

    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Map<String, SkillEvaluation> getSkillEvaluations() {
        return evaluation;
    }

    public void addEvaluation(String skill, SkillEvaluation skillEvaluation) {
        evaluation.put(skill, skillEvaluation);
    }
}
