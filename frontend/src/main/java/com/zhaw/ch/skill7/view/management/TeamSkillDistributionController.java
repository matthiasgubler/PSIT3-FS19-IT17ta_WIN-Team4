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

public class TeamSkillDistributionController {

    private final ICompany company;

    @FXML
    private ComboBox<Team> teamComboBox;

    @FXML
    private BarChartDistributionView teamSkillNeedsBarChart;

    @FXML
    private AnchorPane teamMemberSkillsView;

    @FXML
    private TeamSkillNeedsController teamSkillNeedsBarChartController;

    @FXML
    private TeamMemberSkillsController teamMemberSkillsViewController;

    @FXML
    private ObservableList<Team> teamList = FXCollections.observableArrayList();

    public TeamSkillDistributionController() {
        this.company = new CompanyData();
    }

    public TeamSkillDistributionController(ICompany company) {
        this.company = company;
    }

    @FXML
    private void initialize() {
        teamComboBox.valueProperty().addListener((observable, oldValue, newValue) -> teamChanged(newValue));

        reloadTeams();
        teamComboBox.setItems(teamList);
        teamComboBox.setConverter(new TeamComboBoxConverter(company));
    }

    @FXML
    private void reloadButtonClicked() {
        reloadTeams();
        reloadSubviews();
    }

    private void teamChanged(Team newTeam) {
        teamSkillNeedsBarChartController.teamChanged(newTeam);
        teamMemberSkillsViewController.teamChanged(newTeam);
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