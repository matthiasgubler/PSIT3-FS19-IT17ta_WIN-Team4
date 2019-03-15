package com.zhaw.ch.skill7.model;

import java.util.ArrayList;
import java.util.List;

public class SearchFilter {

    private long id;

    private String name;

    private List<SkillRating> skillRatingList = new ArrayList<>();

    private List<AvailabilityPlan> availabilityPlanList = new ArrayList<>();



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SkillRating> getSkillRatingList() {
        return skillRatingList;
    }

    public void setSkillRatingList(List<SkillRating> skillRatingList) {
        this.skillRatingList = skillRatingList;
    }

    public List<AvailabilityPlan> getAvailabilityPlanList() {
        return availabilityPlanList;
    }

    public void setAvailabilityPlanList(List<AvailabilityPlan> availabilityPlanList) {
        this.availabilityPlanList = availabilityPlanList;
    }
}
