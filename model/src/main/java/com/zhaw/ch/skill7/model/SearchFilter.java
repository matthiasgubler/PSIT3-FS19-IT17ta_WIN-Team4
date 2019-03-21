package com.zhaw.ch.skill7.model;

import java.util.ArrayList;
import java.util.List;

public class SearchFilter extends Identifyable {

    private String name;

    private List<SkillRating> skillRatingList = new ArrayList<>();

    private List<AvailabilityPlan> availabilityPlanList = new ArrayList<>();

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
