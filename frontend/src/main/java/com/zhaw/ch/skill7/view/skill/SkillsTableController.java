package com.zhaw.ch.skill7.view.skill;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.model.SkillUI;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

public class SkillsTableController implements Observer {

    @FXML
    private ObservableList<SkillUI> skillUIObservableList;

    private final ICompany company;

    @FXML
    private TableView<SkillUI> tableView;

    public SkillsTableController() {
        this.company = new CompanyData();
    }

    public SkillsTableController(ICompany company) {
        this.company = company;
    }

    @FXML
    private void initialize() {
        reloadTable();
    }

    private void reloadTable() {
        Platform.runLater(() -> {
            skillUIObservableList.clear();
            skillUIObservableList.addAll(loadAndMapSkills());
        });
    }

    private List<SkillUI> loadAndMapSkills() {
        return company.getSkills().stream().map(SkillUI::new).collect(Collectors.toList());
    }

    public Skill getSelectedValue() {
        return tableView.getSelectionModel().getSelectedItem();
    }

    @Override
    public void update(Observable o, Object arg) {
        reloadTable();
    }
}
