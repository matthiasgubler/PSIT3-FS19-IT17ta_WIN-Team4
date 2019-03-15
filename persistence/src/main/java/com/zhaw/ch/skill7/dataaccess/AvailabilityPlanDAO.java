package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.IAvailabilityPlanDAO;
import com.zhaw.ch.skill7.model.AvailabilityPlan;

import java.util.ArrayList;
import java.util.List;

public class AvailabilityPlanDAO implements IAvailabilityPlanDAO {

    private int currentId = 1;

    private List<AvailabilityPlan> availabilityPlanDatabase = new ArrayList<>();

    @Override
    public List<AvailabilityPlan> readAvailabilityPlans() {
        return availabilityPlanDatabase;
    }

    @Override
    public void addAvailabilityPlan(AvailabilityPlan availabilityPlan) {
        availabilityPlan.setId(currentId++);
        availabilityPlanDatabase.add(availabilityPlan);
    }

    @Override
    public void removeAvailabilityPlan(AvailabilityPlan availabilityPlan) {
        availabilityPlanDatabase.remove(availabilityPlan);
    }

    @Override
    public void updateAvailabilityPlan(AvailabilityPlan availabilityPlan) {
        for (AvailabilityPlan currentAvailabilityPlan : availabilityPlanDatabase) {
            if (currentAvailabilityPlan.getId() == availabilityPlan.getId()) {
                currentAvailabilityPlan.setMondayAvailability(availabilityPlan.getMondayAvailability());
                currentAvailabilityPlan.setTuesdayAvailability(availabilityPlan.getTuesdayAvailability());
                currentAvailabilityPlan.setWednesdayAvailability(availabilityPlan.getWednesdayAvailability());
                currentAvailabilityPlan.setThursdayAvailability(availabilityPlan.getThursdayAvailability());
                currentAvailabilityPlan.setFridayAvailability(availabilityPlan.getFridayAvailability());
            }
        }
    }
}
