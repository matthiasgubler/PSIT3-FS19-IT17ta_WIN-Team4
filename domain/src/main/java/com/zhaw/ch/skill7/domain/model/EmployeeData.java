package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.business.ServiceRegistry;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;

public class EmployeeData extends Employee {

    private final IGenericDAO<Employee> employeeIGenericDAO;

    public EmployeeData(String lastname, String firstname) {
        super(lastname, firstname);
        this.employeeIGenericDAO = ServiceRegistry.getInstance().getEmployeeDAO();
    }

    public EmployeeData(String lastname, String firstname, IGenericDAO<Employee> employeeIGenericDAO) {
        super(lastname, firstname);
        this.employeeIGenericDAO = employeeIGenericDAO;
    }

    public void update() {
        employeeIGenericDAO.update(this);
    }

}
