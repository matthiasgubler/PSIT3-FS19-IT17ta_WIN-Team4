package com.zhaw.ch.skill7.view;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class RootLayoutController {

    public static final String SKILLS_TAB_ID = "skillsTab";
    public static final String SKILLSETS_TAB_ID = "skillSetsTab";
    public static final String TEAMS_TAB_ID = "teamsTab";
    public static final String MITARBEITER_TAB_ID = "mitarbeiterTab";
    public static final String SUCHE_TAB_ID = "sucheTab";
    public static final String MANAGEMENT_TAB_ID = "managementTab";
    public static final String ADMIN_TAB_ID = "adminTab";

    @FXML
    private TabPane rootTabPane;

    @FXML
    void initialize() {
        rootTabPane.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, lastTab, nextTab) -> {
                    if (SKILLS_TAB_ID.equals(nextTab.getId())) {
                        openSkillsTab();
                    } else if (SKILLSETS_TAB_ID.equals(nextTab.getId())) {
                        openSkillSetsTab();
                    } else if (TEAMS_TAB_ID.equals(nextTab.getId())) {
                        openTeamsTab();
                    } else if (MITARBEITER_TAB_ID.equals(nextTab.getId())) {
                        openMitarbeiterTab();
                    } else if (SUCHE_TAB_ID.equals(nextTab.getId())) {
                        openSucheTab();
                    } else if (MANAGEMENT_TAB_ID.equals(nextTab.getId())) {
                        openManagementTab();
                    } else if (ADMIN_TAB_ID.equals(nextTab.getId())) {
                        openAdminTab();
                    } else {
                        System.out.println("Undefined Tab selected with ID: " + nextTab.getId());
                    }
                }
        );
    }

    private void openAdminTab() {
        System.out.println("openAdminTab");
    }

    private void openManagementTab() {
        System.out.println("openManagementTab");
    }

    private void openSucheTab() {
        System.out.println("openSucheTab");
    }

    private void openMitarbeiterTab() {
        System.out.println("openMitarbeiterTab");
    }

    private void openTeamsTab() {
        System.out.println("openTeamsTab");
    }

    private void openSkillSetsTab() {
        System.out.println("openSkillSetsTab");
    }

    private void openSkillsTab() {
        System.out.println("openSkillsTab");
    }


}
