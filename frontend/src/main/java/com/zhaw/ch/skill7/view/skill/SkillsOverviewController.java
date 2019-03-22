package com.zhaw.ch.skill7.view.skill;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class SkillsOverviewController {

    @FXML
    private AnchorPane skillsTable;

    @FXML
    private AnchorPane skillEdit;

    @FXML
    private SkillsTableController skillsTableController;

    @FXML
    private SkillEditController skillEditController;

    @FXML
    private void initialize() {
        skillEditController.addObserver(skillsTableController);
        skillEditController.setSkillsTableController(skillsTableController);
    }

}
