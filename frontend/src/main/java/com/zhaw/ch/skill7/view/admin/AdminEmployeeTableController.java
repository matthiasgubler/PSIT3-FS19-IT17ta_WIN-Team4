package com.zhaw.ch.skill7.view.admin;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.Development;
import com.zhaw.ch.skill7.domain.model.Employee;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.model.EmployeeAdminDevelopmentUI;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.util.*;

public class AdminEmployeeTableController {

    @FXML
    private List<EmployeeAdminDevelopmentUI> adminEmployeeUIObservableList;

    private final ICompany company;

    @FXML
    private TableView<EmployeeAdminDevelopmentUI> tableView;

    public AdminEmployeeTableController() {
        this.company = new CompanyData();
    }

    public AdminEmployeeTableController(ICompany company) {
        this.company = company;
    }

    @FXML
    private void initialize() {
        adminEmployeeUIObservableList.clear();
    }

    public void reloadTable(Skill skill) {
        adminEmployeeUIObservableList.clear();
        loadAndMapEmployee(skill);
    }

    private void loadAndMapEmployee(Skill skill) {
        if (skill != null) {
            for (Development development : skill.getDevelopments()) {
                adminEmployeeUIObservableList.add(new EmployeeAdminDevelopmentUI(development.getEmployee(), development.getDevelopmentRating()));
            }
            adminEmployeeUIObservableList.sort(Comparator.comparing(Employee::getId));
        }
    }
}
