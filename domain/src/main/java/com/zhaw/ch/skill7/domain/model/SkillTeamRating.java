package com.zhaw.ch.skill7.domain.model;

import java.util.ArrayList;
import java.util.List;

public class SkillTeamRating extends SkillRating {

    private Team team;
    private List<Integer> intermediateRatings;
    private Semaphore semaphore;
    private static final int SEMAPHORE_THRESHOLD = 2;
    private int requiredRating;
    private int actualRating;
    private boolean upToDate;

    public SkillTeamRating(int requiredRating, Skill skill, Team team) {
        super(requiredRating, skill);
        this.team = team;
        this.intermediateRatings = new ArrayList<>();
        this.semaphore = Semaphore.RED;
        this.requiredRating = requiredRating;
        this.actualRating = 0;
        this.upToDate = true;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }



    public String getSemaphoreString() {
        if(this.upToDate) {
            return this.semaphore.toString();
        } else {
            evaluateTeamRating();
            return this.semaphore.toString();
        }
    }

    public int getRequiredRating() {
        return this.requiredRating;
    }

    public int getActualRating() {
        if(this.upToDate) {
            return this.actualRating;
        } else {
            //calculate current rating
            evaluateTeamRating();
            return this.actualRating;
        }
    }

    public void addIntermediateRating(int requiredRating) {
        this.intermediateRatings.add(requiredRating);
        this.upToDate = false;
    }

    private void evaluateTeamRating() {
        this.calculateActualRating();
        this.setSemaphore();
        this.upToDate = true;
    }

    private void calculateActualRating() {
        if(intermediateRatings.isEmpty()) {
            this.actualRating = 0;
        } else if(intermediateRatings.size() == 1) {
            this.actualRating = this.intermediateRatings.get(0);
        } else {
            this.actualRating = this.calculateMedian(this.intermediateRatings);
        }
    }

    private int calculateMedian(List<Integer> m) {
        int middle = m.size()/2;
        if (m.size()%2 == 1) {
            return m.get(middle);
        } else {
            return (m.get(middle-1) + m.get(middle)) / 2;
        }
    }

    private void setSemaphore() {
        if(this.actualRating >= this.requiredRating) {
            this.semaphore = Semaphore.GREEN;
        } else if(this.requiredRating - this.actualRating <= SEMAPHORE_THRESHOLD) {
            this.semaphore = Semaphore.YELLOW;
        } else {
            this.semaphore = Semaphore.RED;
        }
    }


}
