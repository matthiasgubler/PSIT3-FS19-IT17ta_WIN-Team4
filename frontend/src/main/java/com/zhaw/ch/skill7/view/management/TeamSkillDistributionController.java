package com.zhaw.ch.skill7.view.management;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.Team;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.model.TeamComboBoxConverter;
import com.zhaw.ch.skill7.view.barchart.BarChartDistributionView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

public class TeamSkillDistributionController extends TeamSelectorController{

    @FXML
    private BarChartDistributionView teamSkillNeedsBarChart;

    @FXML
    private AnchorPane teamMemberSkillsView;

    @FXML
    private TeamSkillNeedsController teamSkillNeedsBarChartController;

    @FXML
    private TeamMemberSkillsController teamMemberSkillsViewController;

    public TeamSkillDistributionController() {
        super();
    }

    public TeamSkillDistributionController(ICompany company) {
        super();
    }

    protected void teamChanged(Team newTeam) {
        teamSkillNeedsBarChartController.teamChanged(newTeam);
        teamMemberSkillsViewController.teamChanged(newTeam);
    }

    @FXML
    private void reloadButtonClicked() {
        reloadTeams();
        reloadSubviews();
    }

    private void reloadSubviews() {
        teamSkillNeedsBarChartController.reloadBarChartData();
        teamMemberSkillsViewController.reloadBarChartData();
    }

    private void reloadTeams() {
        teamList.clear();
        teamList.addAll(company.getTeams());
    }


}
