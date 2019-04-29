package com.zhaw.ch.skill7.view.admin;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AdminOverviewController {
    @FXML
    private AnchorPane AdminDevelopmentTable;

    @FXML
    private AnchorPane AdminDevelopmentBatch;

    @FXML
    private AdminDevelopmentTableController AdminDevelopmentTableController;

    @FXML
    private AdminDevelopmentBatchController AdminDevelopmentBatchController;

    @FXML
    private void initialize() {
        AdminDevelopmentBatchController.addObserver(AdminDevelopmentTableController);
        AdminDevelopmentBatchController.setAdminDevelopmentTableController(AdminDevelopmentTableController);
    }
}
