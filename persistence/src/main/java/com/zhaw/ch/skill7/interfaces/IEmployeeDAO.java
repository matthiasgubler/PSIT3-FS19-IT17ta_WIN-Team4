package com.zhaw.ch.skill7.interfaces;

import com.zhaw.ch.skill7.model.Employee;

import java.util.List;

public interface IEmployeeDAO {

    List<Employee> readEmployees();

    void addEmployee(Employee employee);

    void removeEmployee(Employee employee);

    void updateEmployee(Employee employee);

}
