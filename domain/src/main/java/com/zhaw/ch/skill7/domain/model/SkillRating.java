package com.zhaw.ch.skill7.domain.model;

/**
 * Referenz-Klasse um einen beliebigen Skill zu referenzieren und diesen zusätzlich mit einem Rating versehen zu können
 *
 * @param <T> Gibt die Klasse an, welche den Skill referenziert
 */
public abstract class SkillRating<T> extends SkillReference<SkillRating> {

    private int rating;

    SkillRating(int rating, Skill skill) {
        super(skill);
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Speichtert die Daten des objectWithNewData in das aktuelle SkillRating
     * @param objectWithNewData Objekt mit den neuen Daten, die auf das Updateable Objekt übernommen werden
     */
    @Override
    public void update(SkillRating objectWithNewData) {
        this.setRating(objectWithNewData.getRating());
    }
}
