package com.zhaw.ch.skill7.view.admin;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.model.SkillAdminDevelopmentUI;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.util.List;

public class AdminDevelopmentTableController {

    @FXML
    private List<SkillAdminDevelopmentUI> developmentSkillUIObservableList;

    private final ICompany company;

    @FXML
    private TableView<SkillAdminDevelopmentUI> tableView;

    private AdminEmployeeTableController adminEmployeeTableController;

    public AdminDevelopmentTableController() {
        this.company = new CompanyData();
    }

    public AdminDevelopmentTableController(ICompany company, List<SkillAdminDevelopmentUI> developmentSkillUIObservableList) {
        this.company = company;
        this.developmentSkillUIObservableList = developmentSkillUIObservableList;
    }

    @FXML
    private void initialize() {
        tableView.getSelectionModel().selectedItemProperty().addListener(observer -> reloadEmployeeTable());
        reloadTable();
    }

    public void reloadTable() {
        developmentSkillUIObservableList.clear();
        loadAndMapSkills();
    }

    private void loadAndMapSkills() {
        for (Skill skill : company.getSkillsForDevelopmentWorkshop()) {
            developmentSkillUIObservableList.add(new SkillAdminDevelopmentUI(skill, skill.getSkillDevelopmentCount()));
        }
    }

    private Skill getSelectedSkill() {
        return tableView.getSelectionModel().getSelectedItem();
    }

    private void reloadEmployeeTable() {
        adminEmployeeTableController.reloadTable(getSelectedSkill());
    }

    public void setAdminEmployeeTableController(AdminEmployeeTableController adminEmployeeTableController) {
        this.adminEmployeeTableController = adminEmployeeTableController;
    }
}
