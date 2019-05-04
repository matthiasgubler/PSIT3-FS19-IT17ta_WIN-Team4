package com.zhaw.ch.skill7.view.admin;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.DevelopmentRating;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.model.SkillAdminDevelopmentUI;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class AdminDevelopmentTableController {

    @FXML
    private List<SkillAdminDevelopmentUI> developmentSkillUIObservableList;

    private final ICompany company;

    @FXML
    private TableView<SkillAdminDevelopmentUI> tableView;

    @FXML
    private ComboBox<Integer> employeeCountComboBox;

    @FXML
    private ComboBox<DevelopmentRating> developmentRatingComboBox;

    private AdminEmployeeTableController adminEmployeeTableController;

    private static final List<Integer> employeeCountSelection = Arrays.asList(0, 1, 2, 3, 4, 5);

    public AdminDevelopmentTableController() {
        this.company = new CompanyData();
    }

    public AdminDevelopmentTableController(ICompany company) {
        this.company = company;
    }

    @FXML
    private void initialize() {
        loadEmployeeCountComboBox();
        employeeCountComboBox.getSelectionModel().select(CompanyData.THRESHOLD_COUNT_EMPLOYEES);
        loadDevelopmentRatingComboBox();
        developmentRatingComboBox.getSelectionModel().select(CompanyData.THRESHOLD_DEVELOPMENT_RATING);
        tableView.getSelectionModel().selectedItemProperty().addListener(observer -> skillChanged());
        reloadTable();
    }

    private void reloadTable() {
        Platform.runLater(() -> {
            developmentSkillUIObservableList.clear();
            loadAndMapSkills();
        });
    }

    private void loadEmployeeCountComboBox() {
        ObservableList<Integer> count = FXCollections.observableArrayList();
        count.addAll(employeeCountSelection);
        employeeCountComboBox.setItems(count);
    }

    private void loadDevelopmentRatingComboBox() {
        ObservableList<DevelopmentRating> ratings = FXCollections.observableArrayList();
        ratings.addAll(DevelopmentRating.values());
        developmentRatingComboBox.setItems(ratings);
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
        adminEmployeeTableController.reloadTable(getSelectedSkill());
    }

    public void setAdminEmployeeTableController(AdminEmployeeTableController adminEmployeeTableController) {
        this.adminEmployeeTableController = adminEmployeeTableController;
    }
}
