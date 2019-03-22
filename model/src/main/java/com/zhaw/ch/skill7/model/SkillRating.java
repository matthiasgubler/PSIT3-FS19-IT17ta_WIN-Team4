package com.zhaw.ch.skill7.model;

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

    @Override
    public void update(SkillRating objectWithNewData) {
        this.setRating(objectWithNewData.getRating());
    }
}
