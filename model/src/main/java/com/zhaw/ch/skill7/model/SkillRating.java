package com.zhaw.ch.skill7.model;

public abstract class SkillRating extends SkillReference{

    private int rating;

    protected SkillRating(int rating, Skill skill){
        super(skill);
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
