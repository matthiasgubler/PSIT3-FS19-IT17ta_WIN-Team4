package com.zhaw.ch.skill7.view.admin;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AdminOverviewController {
    @FXML
    private AnchorPane adminDevelopmentTable;

    @FXML
    private AnchorPane adminEmployeeTable;

    @FXML
    private AdminDevelopmentTableController adminDevelopmentTableController;

    @FXML
    private AdminEmployeeTableController adminEmployeeTableController;

    @FXML
    private void initialize() {
        adminDevelopmentTableController.setAdminEmployeeTableController(adminEmployeeTableController);
    }
}
