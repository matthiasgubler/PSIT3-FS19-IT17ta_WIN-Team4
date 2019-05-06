package com.zhaw.ch.skill7.model;

import com.zhaw.ch.skill7.domain.model.Employee;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeUI extends Employee {
    private final SimpleStringProperty id = new SimpleStringProperty("");
    private final SimpleStringProperty lastname = new SimpleStringProperty("");
    private final SimpleStringProperty firstname = new SimpleStringProperty("");

    public EmployeeUI(Employee employee) {
        super(employee.getLastname(), employee.getFirstname());
        setId(String.valueOf(employee.getId()));
        setLastname(employee.getLastname());
        setFirstname(employee.getFirstname());
    }

    public long getId() {
        return Long.valueOf(id.get());
    }

    private void setId(String id) {
        this.id.set(id);
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public String getLastnameProperty() {
        return lastname.get();
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public String getFirstnameProperty() {
        return firstname.get();
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }
}
