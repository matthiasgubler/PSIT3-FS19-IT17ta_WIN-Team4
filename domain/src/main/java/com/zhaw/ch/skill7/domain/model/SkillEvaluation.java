package com.zhaw.ch.skill7.domain.model;

public class SkillEvaluation {

    private String name;
    private Long actualRating;
    private Long requiredRating;
    private String statusMessage;

    public SkillEvaluation() {

    }

    public SkillEvaluation(String name) {
        this.name = name;
    }

    public Long getActualRating() {
        return actualRating;
    }

    public void setActualRating(Long actualRating) {
        this.actualRating = actualRating;
    }

    public Long getRequiredRating() {
        return requiredRating;
    }

    public void setRequiredRating(Long requiredRating) {
        this.requiredRating = requiredRating;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}