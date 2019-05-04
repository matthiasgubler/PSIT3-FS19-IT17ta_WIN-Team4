package com.zhaw.ch.skill7.view.admin;

import javafx.fxml.FXML;

public class AdminOverviewController {

    @FXML
    private AdminDevelopmentTableController adminDevelopmentTableController;

    @FXML
    private AdminEmployeeTableController adminEmployeeTableController;

    @FXML
    private void initialize() {
        adminDevelopmentTableController.setAdminEmployeeTableController(adminEmployeeTableController);
    }
}
