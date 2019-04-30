package com.zhaw.ch.skill7.domain.model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class SkillEvaluation {

    private SimpleStringProperty name;
    private SimpleLongProperty actualRating;
    private SimpleLongProperty requiredRating;
    private SimpleStringProperty statusMessage;

    public SkillEvaluation() {

    }

    public SkillEvaluation(String name) {
        this.name = new SimpleStringProperty(name);
        this.actualRating = new SimpleLongProperty(0L);
        this.requiredRating = new SimpleLongProperty(0L);
        this.statusMessage = new SimpleStringProperty("");
    }

    public SkillEvaluation(String name, Long actualRating, Long requiredRating, String statusMessage) {
        this.name = new SimpleStringProperty(name);
        this.actualRating = new SimpleLongProperty(actualRating);
        this.requiredRating = new SimpleLongProperty(requiredRating);
        this.statusMessage = new SimpleStringProperty(statusMessage);
    }

    public Long getActualRating() {
        return actualRating.get();
    }

    public void setActualRating(Long actualRating) {
        this.actualRating = new SimpleLongProperty(actualRating);
    }

    public Long getRequiredRating() {
        return requiredRating.get();
    }

    public void setRequiredRating(Long requiredRating) {
        this.requiredRating = new SimpleLongProperty(requiredRating);
    }

    public String getStatusMessage() {
        return statusMessage.get();
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = new SimpleStringProperty(statusMessage);
    }
}