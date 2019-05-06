package com.zhaw.ch.skill7.model;

import com.zhaw.ch.skill7.domain.model.DevelopmentRating;
import com.zhaw.ch.skill7.domain.model.Employee;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeAdminDevelopmentUI extends EmployeeUI {
    private final SimpleStringProperty rating = new SimpleStringProperty("");

    public EmployeeAdminDevelopmentUI(Employee employee, DevelopmentRating rating) {
        super(employee);
        setRating(String.valueOf(rating));
    }

    public String getRating() {
        return rating.get();
    }

    public void setRating(String rating) {
        this.rating.set(rating);
    }

    public SimpleStringProperty DevelopmentRatingProperty() {
        return rating;
    }

}
