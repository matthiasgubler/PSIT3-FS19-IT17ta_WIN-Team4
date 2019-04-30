package com.zhaw.ch.skill7.view.admin;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AdminOverviewController {
    @FXML
    private AnchorPane adminDevelopmentTable;

    @FXML
    private AnchorPane adminEmployeeTable;

    @FXML
    private AnchorPane adminDevelopmentBatch;

    @FXML
    private AdminDevelopmentTableController adminDevelopmentTableController;

    @FXML
    private AdminDevelopmentBatchController adminDevelopmentBatchController;

    @FXML
    private AdminEmployeeTableController adminEmployeeTableController;

    @FXML
    private void initialize() {
//        adminDevelopmentBatchController.addObserver(adminDevelopmentTableController);
//        adminDevelopmentBatchController.setAdminDevelopmentTableController(adminDevelopmentTableController);
        adminDevelopmentTableController.setAdminEmployeeTableController(adminEmployeeTableController);
        adminEmployeeTableController.setAdminDevelopmentTableController(adminDevelopmentTableController);
    }
}
