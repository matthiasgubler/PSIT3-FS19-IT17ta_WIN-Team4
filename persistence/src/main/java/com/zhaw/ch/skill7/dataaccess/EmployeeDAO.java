package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.IEmployeeDAO;
import com.zhaw.ch.skill7.model.Employee;

public class EmployeeDAO extends GenericDAO<Employee> implements IEmployeeDAO {

    @Override
    protected void updateObject(Employee object, Employee newValuesObject) {
        object.setFirstname(newValuesObject.getFirstname());
        object.setSurname(newValuesObject.getSurname());
        object.setTeam(newValuesObject.getTeam());
    }
}
