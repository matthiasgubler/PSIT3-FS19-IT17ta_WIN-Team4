package com.zhaw.ch.skill7.view.management;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.Team;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.model.TeamComboBoxConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public abstract class TeamSelectorController {

    protected final ICompany company;

    @FXML
    protected ComboBox<Team> teamComboBox;

    @FXML
    protected final ObservableList<Team> teamList = FXCollections.observableArrayList();

    public TeamSelectorController() {
        this.company = new CompanyData();
    }

    public TeamSelectorController(ICompany company) {
        this.company = company;
    }

    @FXML
    protected void initialize() {
        teamComboBox.valueProperty().addListener((observable, oldValue, newValue) -> teamChanged(newValue));

        reloadTeams();
        teamComboBox.setItems(teamList);
        teamComboBox.setConverter(new TeamComboBoxConverter(company));
    }

    protected abstract void teamChanged(Team newTeam);

    private void reloadTeams() {
        teamList.clear();
        teamList.addAll(company.getTeams());
    }
}
