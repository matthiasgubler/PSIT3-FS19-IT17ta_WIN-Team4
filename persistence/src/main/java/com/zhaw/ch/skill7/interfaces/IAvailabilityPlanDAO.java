package com.zhaw.ch.skill7.interfaces;

import com.zhaw.ch.skill7.model.AvailabilityPlan;

import java.util.List;

public interface IAvailabilityPlanDAO {

    List<AvailabilityPlan> readAvailabilityPlans();

    void addAvailabilityPlan(AvailabilityPlan availabilityPlan);

    void removeAvailabilityPlan(AvailabilityPlan availabilityPlan);

    void updateAvailabilityPlan(AvailabilityPlan availabilityPlan);

}
