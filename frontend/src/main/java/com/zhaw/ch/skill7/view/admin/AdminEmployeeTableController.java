package com.zhaw.ch.skill7.view.admin;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.DevelopmentRating;
import com.zhaw.ch.skill7.domain.model.Employee;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.model.EmployeeAdminDevelopmentUI;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class AdminEmployeeTableController implements Observer {

    @FXML
    private ObservableList<EmployeeAdminDevelopmentUI> AdminEmployeeUIObservableList;

    private final ICompany company;

    @FXML
    private TableView<EmployeeAdminDevelopmentUI> tableView;

    private AdminDevelopmentTableController AdminDevelopmentTableController;

    public AdminEmployeeTableController() {
        this.company = new CompanyData();
    }

    public AdminEmployeeTableController(ICompany company) {
        this.company = company;
    }

    @FXML
    private void initialize() {
        AdminEmployeeUIObservableList.clear();
    }

    public void reloadTable() {
        Platform.runLater(() -> {
            AdminEmployeeUIObservableList.clear();
            loadAndMapEmployee();
        });
    }

    private void loadAndMapEmployee() {
        Skill skill = AdminDevelopmentTableController.getSelectedSkill();
        Map<Employee, DevelopmentRating> employeeDevelopmentList = skill.getSkillDevelopmentEmployees();
        for (Employee employee : employeeDevelopmentList.keySet()) {
            AdminEmployeeUIObservableList.add(new EmployeeAdminDevelopmentUI(employee, employeeDevelopmentList.get(employee)));
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        reloadTable();
    }

    public void setAdminDevelopmentTableController(AdminDevelopmentTableController AdminDevelopmentTableController) {
        this.AdminDevelopmentTableController = AdminDevelopmentTableController;
    }
}