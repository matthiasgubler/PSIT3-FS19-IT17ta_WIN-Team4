package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.IEmployeeDAO;
import com.zhaw.ch.skill7.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    private int currentId = 1;

    private List<Employee> employeeDatabase = new ArrayList<>();

    @Override
    public List<Employee> readEmployees() {
        return employeeDatabase;
    }

    @Override
    public void addEmployee(Employee employee) {
        employee.setId(currentId++);
        employeeDatabase.add(employee);

    }

    @Override
    public void removeEmployee(Employee employee) {
        employeeDatabase.remove(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        for (Employee currentEmployee : employeeDatabase) {
            if (currentEmployee.getId() == employee.getId()) {
                currentEmployee.setFirstname(employee.getFirstname());
                currentEmployee.setSurname(employee.getSurname());
                currentEmployee.setTeam(employee.getTeam());
            }
        }
    }
}
