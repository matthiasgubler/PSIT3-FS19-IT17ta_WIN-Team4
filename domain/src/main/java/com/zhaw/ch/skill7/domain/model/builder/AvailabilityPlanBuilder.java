package com.zhaw.ch.skill7.domain.model.builder;

import com.zhaw.ch.skill7.domain.model.Availability;
import com.zhaw.ch.skill7.domain.model.AvailabilityPlan;

/**
 * Builder Class for AvailabilityPlan
 */
public final class AvailabilityPlanBuilder {
    private Availability mondayAvailability = Availability.FULL_DAY;
    private Availability tuesdayAvailability = Availability.FULL_DAY;
    private Availability wednesdayAvailability = Availability.FULL_DAY;
    private Availability thursdayAvailability = Availability.FULL_DAY;
    private Availability fridayAvailability = Availability.FULL_DAY;

    private AvailabilityPlanBuilder() {
    }

    /**
     * Returns instance of an AvailabilityPlanBuilder
     *
     * @return new instance of AvailabilityPlanBuilder
     */
    public static AvailabilityPlanBuilder anAvailabilityPlan() {
        return new AvailabilityPlanBuilder();
    }

    /**
     * Setzt die Verfügbarkeit am Montag mondayAvailability im Builder
     * @param mondayAvailability Verfügbarkeit am Montag
     * @return Die bestehende Instanz des Builders
     */
    public AvailabilityPlanBuilder withMondayAvailability(Availability mondayAvailability) {
        this.mondayAvailability = mondayAvailability;
        return this;
    }

    /**
     * Setzt die Verfügbarkeit am Dienstag mondayAvailability im Builder
     * @param tuesdayAvailability Verfügbarkeit am Dienstag
     * @return Die bestehende Instanz des Builders
     */
    public AvailabilityPlanBuilder withTuesdayAvailability(Availability tuesdayAvailability) {
        this.tuesdayAvailability = tuesdayAvailability;
        return this;
    }

    /**
     * Setzt die Verfügbarkeit am Mittwoch mondayAvailability im Builder
     * @param wednesdayAvailability Verfügbarkeit am Mittwoch
     * @return Die bestehende Instanz des Builders
     */
    public AvailabilityPlanBuilder withWednesdayAvailability(Availability wednesdayAvailability) {
        this.wednesdayAvailability = wednesdayAvailability;
        return this;
    }

    /**
     * Setzt die Verfügbarkeit am Donnerstag thursdayAvailability im Builder
     * @param thursdayAvailability Verfügbarkeit am Donnerstag
     * @return Die bestehende Instanz des Builders
     */
    public AvailabilityPlanBuilder withThursdayAvailability(Availability thursdayAvailability) {
        this.thursdayAvailability = thursdayAvailability;
        return this;
    }

    /**
     * Setzt die Verfügbarkeit am Freitag thursdayAvailability im Builder
     * @param fridayAvailability Verfügbarkeit am Freitag
     * @return Die bestehende Instanz des Builders
     */
    public AvailabilityPlanBuilder withFridayAvailability(Availability fridayAvailability) {
        this.fridayAvailability = fridayAvailability;
        return this;
    }

    /**
     * Fürt den Build aus und gibt eine neue Instanz der Klasse AvailabilityPlan zurück
     * @return neu erstelltes Objekt der Klasse AvailabilityPlan
     */
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
