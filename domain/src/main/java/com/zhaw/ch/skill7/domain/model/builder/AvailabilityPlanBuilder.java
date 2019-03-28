package com.zhaw.ch.skill7.domain.model.builder;

import com.zhaw.ch.skill7.domain.model.Availability;
import com.zhaw.ch.skill7.domain.model.AvailabilityPlan;

public final class AvailabilityPlanBuilder {
    private Availability mondayAvailability = Availability.FULL_DAY;
    private Availability tuesdayAvailability = Availability.FULL_DAY;
    private Availability wednesdayAvailability = Availability.FULL_DAY;
    private Availability thursdayAvailability = Availability.FULL_DAY;
    private Availability fridayAvailability = Availability.FULL_DAY;

    private AvailabilityPlanBuilder() {
    }

    public static AvailabilityPlanBuilder anAvailabilityPlan() {
        return new AvailabilityPlanBuilder();
    }

    public AvailabilityPlanBuilder withMondayAvailability(Availability mondayAvailability) {
        this.mondayAvailability = mondayAvailability;
        return this;
    }

    public AvailabilityPlanBuilder withTuesdayAvailability(Availability tuesdayAvailability) {
        this.tuesdayAvailability = tuesdayAvailability;
        return this;
    }

    public AvailabilityPlanBuilder withWednesdayAvailability(Availability wednesdayAvailability) {
        this.wednesdayAvailability = wednesdayAvailability;
        return this;
    }

    public AvailabilityPlanBuilder withThursdayAvailability(Availability thursdayAvailability) {
        this.thursdayAvailability = thursdayAvailability;
        return this;
    }

    public AvailabilityPlanBuilder withFridayAvailability(Availability fridayAvailability) {
        this.fridayAvailability = fridayAvailability;
        return this;
    }

    public AvailabilityPlan build() {
        AvailabilityPlan availabilityPlan = new AvailabilityPlan();
        availabilityPlan.setMondayAvailability(mondayAvailability);
        availabilityPlan.setTuesdayAvailability(tuesdayAvailability);
        availabilityPlan.setWednesdayAvailability(wednesdayAvailability);
        availabilityPlan.setThursdayAvailability(thursdayAvailability);
        availabilityPlan.setFridayAvailability(fridayAvailability);
        return availabilityPlan;
    }
}
