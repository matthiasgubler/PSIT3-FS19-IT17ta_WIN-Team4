package com.zhaw.ch.skill7.view.admin;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.Development;
import com.zhaw.ch.skill7.domain.model.Employee;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.model.EmployeeAdminDevelopmentUI;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.util.*;
import java.util.stream.Collectors;

public class AdminEmployeeTableController {

    @FXML
    private List<EmployeeAdminDevelopmentUI> adminEmployeeUIObservableList;

    private final ICompany company;

    @FXML
    private TableView<EmployeeAdminDevelopmentUI> tableView;

    private AdminDevelopmentTableController adminDevelopmentTableController;

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

    public void reloadTable() {
        Platform.runLater(() -> {
            adminEmployeeUIObservableList.clear();
            loadAndMapEmployee();
        });
    }

    private void loadAndMapEmployee() {
        Skill skill = adminDevelopmentTableController.getSelectedSkill();
        List<Development> developmentList = company.getDevelopments().stream().filter(development -> development.getSkill().equals(skill)).collect(Collectors.toList());
        for (Development development : developmentList) {
            adminEmployeeUIObservableList.add(new EmployeeAdminDevelopmentUI(development.getEmployee(), development.getDevelopmentRating()));
        }
        adminEmployeeUIObservableList.sort(Comparator.comparing(Employee::getId));
    }

    public void setAdminDevelopmentTableController(AdminDevelopmentTableController adminDevelopmentTableController) {
        this.adminDevelopmentTableController = adminDevelopmentTableController;
    }
}
