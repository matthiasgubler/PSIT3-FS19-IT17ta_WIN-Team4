package com.zhaw.ch.skill7.model;

public class AvailabilityPlan {

    private long id;

    private Availability mondayAvailability;

    private Availability tuesdayAvailability;

    private Availability wednesdayAvailability;

    private Availability thursdayAvailability;

    private Availability fridayAvailability;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

}
