package com.zhaw.ch.skill7.view.admin;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.model.SkillAdminDevelopmentUI;
import javafx.application.Platform;
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

    public AdminDevelopmentTableController(ICompany company) {
        this.company = company;
    }

    @FXML
    private void initialize() {
        tableView.getSelectionModel().selectedItemProperty().addListener(observer -> skillChanged());
        reloadTable();
    }

    private void reloadTable() {
        Platform.runLater(() -> {
            developmentSkillUIObservableList.clear();
            loadAndMapSkills();
        });
    }

    private void loadAndMapSkills() {
        List<Skill> skillList = company.getSkillsForDevelopmentWorkshop();
        for (Skill skill : skillList) {
            developmentSkillUIObservableList.add(new SkillAdminDevelopmentUI(skill, skill.getSkillDevelopmentCount()));
        }
    }

    public Skill getSelectedSkill() {
        return tableView.getSelectionModel().getSelectedItem();
    }

    private void skillChanged() {
        adminEmployeeTableController.reloadTable();
    }

    public void setAdminEmployeeTableController(AdminEmployeeTableController adminEmployeeTableController) {
        this.adminEmployeeTableController = adminEmployeeTableController;
    }
}
