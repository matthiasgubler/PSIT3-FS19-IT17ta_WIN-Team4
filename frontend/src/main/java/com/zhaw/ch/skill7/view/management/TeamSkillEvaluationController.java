package com.zhaw.ch.skill7.view.management;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.SkillEvaluation;
import com.zhaw.ch.skill7.domain.model.Team;
import com.zhaw.ch.skill7.domain.model.TeamEvaluation;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.model.DummyTeam;
import com.zhaw.ch.skill7.model.TeamComboBoxConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Map;

public class TeamSkillEvaluationController {

    private final ICompany company;
    private Team selectedTeam;

    @FXML
    private ComboBox<Team> teamComboBox;

    @FXML
    private TableView<SkillEvaluation> tableView;
    @FXML
    private TableColumn<SkillEvaluation, String> skillNameColumn;
    @FXML
    private TableColumn<SkillEvaluation, Long> skillActualRating;
    @FXML
    private TableColumn<SkillEvaluation, Long> skillRequiredRating;
    @FXML
    private TableColumn<SkillEvaluation, String> skillEvaluationStatus;
    @FXML
    private ObservableList<Team> teamList = FXCollections.observableArrayList();

    public TeamSkillEvaluationController() {
        this.company = new CompanyData();
        this.selectedTeam = new DummyTeam();
    }

    public TeamSkillEvaluationController(ICompany company) {
        this.company = company;
        this.selectedTeam = new DummyTeam();
    }

    @FXML
    private void initialize() {
        teamComboBox.valueProperty().addListener((observable, oldValue, newValue) -> teamChanged(newValue));

        reloadTeams();
        teamComboBox.setItems(teamList);
        teamComboBox.setConverter(new TeamComboBoxConverter(company));

        skillNameColumn.setCellValueFactory(new PropertyValueFactory<SkillEvaluation, String>("name"));
        skillActualRating.setCellValueFactory(new PropertyValueFactory<SkillEvaluation, Long>("actualRating"));
        skillRequiredRating.setCellValueFactory(new PropertyValueFactory<SkillEvaluation, Long>("requiredRating"));
        skillEvaluationStatus.setCellValueFactory(new PropertyValueFactory<SkillEvaluation, String>("statusMessage"));
    }

    @FXML
    private void reloadButtonClicked() {
        reloadTeams();
    }

    private void reloadTeams() {
        teamList.clear();
        teamList.addAll(company.getTeams());
    }

    private void teamChanged(Team newTeam) {
        if (newTeam != null) {
            selectedTeam = newTeam;
            tableView.setItems(evaluateSelectedTeam());
        }
    }

    private ObservableList<SkillEvaluation> evaluateSelectedTeam() {
        // call team
        TeamEvaluation teamEvaluation = selectedTeam.evaluateTeam();
        Map<String, SkillEvaluation> evaluations = teamEvaluation.getSkillEvaluations();
        ObservableList<SkillEvaluation> observableSkillEvaluations = FXCollections.observableArrayList();
        for(Map.Entry<String, SkillEvaluation> eval : evaluations.entrySet()) {
            observableSkillEvaluations.add(eval.getValue());
        }
        return observableSkillEvaluations;
    }

}
