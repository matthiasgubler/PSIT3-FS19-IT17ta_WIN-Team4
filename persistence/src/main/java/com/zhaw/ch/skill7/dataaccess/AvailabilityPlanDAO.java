package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.IAvailabilityPlanDAO;
import com.zhaw.ch.skill7.model.AvailabilityPlan;

public class AvailabilityPlanDAO extends GenericDAO<AvailabilityPlan> implements IAvailabilityPlanDAO {

    @Override
    protected void updateObject(AvailabilityPlan availabilityPlan, AvailabilityPlan newValuesObject) {
        availabilityPlan.setMondayAvailability(newValuesObject.getMondayAvailability());
        availabilityPlan.setTuesdayAvailability(newValuesObject.getTuesdayAvailability());
        availabilityPlan.setWednesdayAvailability(newValuesObject.getWednesdayAvailability());
        availabilityPlan.setThursdayAvailability(newValuesObject.getThursdayAvailability());
        availabilityPlan.setFridayAvailability(newValuesObject.getFridayAvailability());
    }

}
