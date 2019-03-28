package com.zhaw.ch.skill7.view.skill;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.interfaces.ICompany;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;

import java.util.Observable;


public class SkillEditController extends Observable {

    private final ICompany company;

    private SkillsTableController skillsTableController;

    @FXML
    private TextField newSkillTextField;

    public SkillEditController() {
        this.company = new CompanyData();
    }

    public SkillEditController(ICompany company) {
        this.company = company;
    }

    @FXML
    public void creationButtonClicked() {
        String skillNameValue = newSkillTextField.getText();
        System.out.println("Creation Button Clicked with value of TextField: " + skillNameValue);
        if (!StringUtils.isEmpty(skillNameValue)) {
            company.createSkill(skillNameValue);
            newSkillTextField.setText("");
            setChangedAndNotify();
        }
    }

    @FXML
    public void deleteButtonClicked() {
        Skill selectedSkill = skillsTableController.getSelectedValue();
        if (selectedSkill != null) {
            company.deleteSkill(selectedSkill);
            setChangedAndNotify();
        }
    }

    TextField getNewSkillTextField() {
        return newSkillTextField;
    }

    void setNewSkillTextField(TextField newSkillTextField) {
        this.newSkillTextField = newSkillTextField;
    }

    private void setChangedAndNotify() {
        setChanged();
        notifyObservers();
    }

    public SkillsTableController getSkillsTableController() {
        return skillsTableController;
    }

    public void setSkillsTableController(SkillsTableController skillsTableController) {
        this.skillsTableController = skillsTableController;
    }
}
