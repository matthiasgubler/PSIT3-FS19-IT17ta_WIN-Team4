package com.zhaw.ch.skill7.view.skill;

import com.zhaw.ch.skill7.business.SkillService;
import com.zhaw.ch.skill7.interfaces.ISkillService;
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

    private ISkillService skillService;

    @FXML
    private TableView<SkillUI> tableView;

    public SkillsTableController() {
        this.skillService = new SkillService();
    }

    public SkillsTableController(ISkillService skillService) {
        this.skillService = skillService;
    }

    @FXML
    private void initialize() {
        reloadTable();
        tableView.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (observable != null &&
                            observable.getValue() != null) {
                        reloadTable();
                    }
                });
    }

    private void reloadTable() {
        Platform.runLater(() -> {
            skillUIObservableList.clear();
            skillUIObservableList.addAll(loadAndMapSkills());
        });

    }

    private List<SkillUI> loadAndMapSkills() {
        return skillService.readSkills().stream().map(SkillUI::new).collect(Collectors.toList());
    }

    @Override
    public void update(Observable o, Object arg) {
        reloadTable();
    }
}
