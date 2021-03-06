package com.zhaw.ch.skill7.view.management;

import com.zhaw.ch.skill7.domain.model.SkillTeamRating;
import com.zhaw.ch.skill7.domain.model.Team;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.interfaces.ISkillTeamRating;
import com.zhaw.ch.skill7.model.DummyTeam;
import com.zhaw.ch.skill7.model.SkillTeamRatingAdapter;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TeamSkillEvaluationController extends TeamSelectorController{

    private Team selectedTeam;

    @FXML
    private TableView<ISkillTeamRating> tableView;
    @FXML
    private TableColumn<ISkillTeamRating, SimpleStringProperty> skillNameColumn;
    @FXML
    private TableColumn<ISkillTeamRating, SimpleIntegerProperty> skillActualRating;
    @FXML
    private TableColumn<ISkillTeamRating, SimpleIntegerProperty> skillRequiredRating;
    @FXML
    private TableColumn<ISkillTeamRating, SimpleStringProperty> skillEvaluationStatus;
    @FXML
    private TextField teamStatus;

    public TeamSkillEvaluationController() {
        super();
        this.selectedTeam = new DummyTeam();
        teamStatus = new TextField();
    }

    public TeamSkillEvaluationController(ICompany company) {
        super();
        this.selectedTeam = new DummyTeam();
    }

    @FXML
    protected void initialize() {
        super.initialize();

        skillNameColumn.setCellValueFactory(new PropertyValueFactory<>("skill"));
        skillActualRating.setCellValueFactory(new PropertyValueFactory<>("actualRating"));
        skillRequiredRating.setCellValueFactory(new PropertyValueFactory<>("requiredRating"));
        skillEvaluationStatus.setCellValueFactory(new PropertyValueFactory<>("semaphore"));
    }

    protected void teamChanged(Team newTeam) {
        if (newTeam != null) {
            selectedTeam = newTeam;
            teamStatus.setText(selectedTeam.evaluateTeam().toString());
            tableView.setItems(evaluateSelectedTeam());
        }
    }

    @FXML
    private void reloadButtonClicked() {
        reloadTeams();
    }

    private void reloadTeams() {
        teamList.clear();
        teamList.addAll(company.getTeams());
    }

    private ObservableList<ISkillTeamRating> evaluateSelectedTeam() {
        List<SkillTeamRating> teamEvaluation = selectedTeam.getSkillRatingList();
        ObservableList<ISkillTeamRating> observableSkillTeamRatings = FXCollections.observableArrayList();
        for(SkillTeamRating rating : teamEvaluation) {
            observableSkillTeamRatings.add(new SkillTeamRatingAdapter(rating));
        }
        return observableSkillTeamRatings;
    }

}
