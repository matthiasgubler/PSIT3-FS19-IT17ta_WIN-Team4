package com.zhaw.ch.skill7.view.admin;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.DevelopmentRating;
import com.zhaw.ch.skill7.interfaces.ICompany;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.Arrays;
import java.util.List;

public class AdminPropertyController {

    private final ICompany company;

    @FXML
    private ComboBox<Integer> employeeCountComboBox;

    @FXML
    private ComboBox<DevelopmentRating> developmentRatingComboBox;

    private AdminDevelopmentTableController adminDevelopmentTableController;
    private static final List<Integer> employeeCountSelection = Arrays.asList(0, 1, 2, 3, 4, 5);

    public AdminPropertyController() {
        this.company = new CompanyData();
    }

    public AdminPropertyController(ICompany company) {
        this.company = company;
    }

    @FXML
    private void initialize() {
        loadEmployeeCountComboBox();
        employeeCountComboBox.getSelectionModel().selectedItemProperty().addListener(observer -> employeeCountChanged());
        loadDevelopmentRatingComboBox();
        developmentRatingComboBox.getSelectionModel().selectedItemProperty().addListener(observer -> developmentRatingChanged());
    }

    private void reloadDevelopmentTable() {
        adminDevelopmentTableController.reloadTable();
    }

    private void loadEmployeeCountComboBox() {
        ObservableList<Integer> count = FXCollections.observableArrayList();
        count.addAll(employeeCountSelection);
        employeeCountComboBox.setItems(count);
        employeeCountComboBox.getSelectionModel().select(CompanyData.THRESHOLD_COUNT_EMPLOYEES);
    }

    private void loadDevelopmentRatingComboBox() {
        ObservableList<DevelopmentRating> ratings = FXCollections.observableArrayList();
        ratings.addAll(DevelopmentRating.values());
        developmentRatingComboBox.setItems(ratings);
        developmentRatingComboBox.getSelectionModel().select(CompanyData.THRESHOLD_DEVELOPMENT_RATING);
    }

    private int getSelectedEmployeeCount() {
        return employeeCountComboBox.getSelectionModel().getSelectedItem();
    }

    private DevelopmentRating getSelectedDevelopmentRating() {
        return developmentRatingComboBox.getSelectionModel().getSelectedItem();
    }

    private void employeeCountChanged() {
        CompanyData.THRESHOLD_COUNT_EMPLOYEES = getSelectedEmployeeCount();
        reloadDevelopmentTable();
    }

    private void developmentRatingChanged() {
        CompanyData.THRESHOLD_DEVELOPMENT_RATING = getSelectedDevelopmentRating();
        reloadDevelopmentTable();
    }

    public void setAdminDevelopmentTableController(AdminDevelopmentTableController adminDevelopmentTableController) {
        this.adminDevelopmentTableController = adminDevelopmentTableController;
    }
}
