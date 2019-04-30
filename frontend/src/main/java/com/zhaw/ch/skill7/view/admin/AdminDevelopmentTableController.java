package com.zhaw.ch.skill7.view.admin;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.model.AdminDevelopmentSkillUI;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

public class AdminDevelopmentTableController implements Observer {

    @FXML
    private ObservableList<AdminDevelopmentSkillUI> developmentSkillUIObservableList;

    private final ICompany company;

    @FXML
    private TableView<AdminDevelopmentSkillUI> tableView;

    public AdminDevelopmentTableController() {
        this.company = new CompanyData();
    }

    public AdminDevelopmentTableController(ICompany company) {
        this.company = company;
    }

    @FXML
    private void initialize() {
        reloadTable();
    }

    private void reloadTable() {
        Platform.runLater(() -> {
            developmentSkillUIObservableList.clear();
            loadAndMapSkills();
        });
    }

    private void loadAndMapSkills() {
        List<Skill> skillList = company.getSkillsForDevelopmentWorkshop();
        for (Skill skill : skillList) {
            developmentSkillUIObservableList.add(new AdminDevelopmentSkillUI(skill, skill.getSkillDevelopmentCount()));
        }
    }

    public Skill getSelectedValue() {
        return tableView.getSelectionModel().getSelectedItem();
    }

    @Override
    public void update(Observable o, Object arg) {
        reloadTable();
    }
}
