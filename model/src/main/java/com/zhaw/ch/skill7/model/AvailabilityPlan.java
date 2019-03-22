package com.zhaw.ch.skill7.model;

public class AvailabilityPlan extends IdUpdateableEntity<AvailabilityPlan> {

    private Availability mondayAvailability;

    private Availability tuesdayAvailability;

    private Availability wednesdayAvailability;

    private Availability thursdayAvailability;

    private Availability fridayAvailability;

    public Availability getMondayAvailability() {
        return mondayAvailability;
    }

    public void setMondayAvailability(Availability mondayAvailability) {
        this.mondayAvailability = mondayAvailability;
    }

    public Availability getTuesdayAvailability() {
        return tuesdayAvailability;
    }

    public void setTuesdayAvailability(Availability tuesdayAvailability) {
        this.tuesdayAvailability = tuesdayAvailability;
    }

    public Availability getWednesdayAvailability() {
        return wednesdayAvailability;
    }

    public void setWednesdayAvailability(Availability wednesdayAvailability) {
        this.wednesdayAvailability = wednesdayAvailability;
    }

    public Availability getThursdayAvailability() {
        return thursdayAvailability;
    }

    public void setThursdayAvailability(Availability thursdayAvailability) {
        this.thursdayAvailability = thursdayAvailability;
    }

    public Availability getFridayAvailability() {
        return fridayAvailability;
    }

    public void setFridayAvailability(Availability fridayAvailability) {
        this.fridayAvailability = fridayAvailability;
    }

    @Override
    public void update(AvailabilityPlan objectWithNewData) {
        this.setMondayAvailability(objectWithNewData.getMondayAvailability());
        this.setTuesdayAvailability(objectWithNewData.getTuesdayAvailability());
        this.setWednesdayAvailability(objectWithNewData.getWednesdayAvailability());
        this.setThursdayAvailability(objectWithNewData.getThursdayAvailability());
        this.setFridayAvailability(objectWithNewData.getFridayAvailability());
    }
}
