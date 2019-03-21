package com.zhaw.ch.skill7.view.skill;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class SkillsOverviewController {

    @FXML
    private AnchorPane skillsTable;

    @FXML
    private AnchorPane skillCreation;

    @FXML
    private SkillsTableController skillsTableController;

    @FXML
    private SkillCreationController skillCreationController;

    @FXML
    private void initialize() {
        skillCreationController.addObserver(skillsTableController);
    }

}
