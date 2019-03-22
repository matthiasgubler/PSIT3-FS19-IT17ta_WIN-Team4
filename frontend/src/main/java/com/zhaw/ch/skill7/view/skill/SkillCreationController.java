package com.zhaw.ch.skill7.view.skill;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.interfaces.ICompany;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;

import java.util.Observable;


public class SkillCreationController extends Observable {

    private final ICompany company;

    @FXML
    private TextField newSkillTextField;

    public SkillCreationController() {
        this.company = new CompanyData();
    }

    public SkillCreationController(ICompany company) {
        this.company = company;
    }

    @FXML
    public void creationButtonClicked() {
        String skillNameValue = newSkillTextField.getText();
        System.out.println("Creation Button Clicked with value of TextField: " + skillNameValue);
        if (!StringUtils.isEmpty(skillNameValue)) {
            company.createSkill(skillNameValue);
            newSkillTextField.setText("");
            setChanged();
            notifyObservers();
        }
    }

    TextField getNewSkillTextField() {
        return newSkillTextField;
    }

    void setNewSkillTextField(TextField newSkillTextField) {
        this.newSkillTextField = newSkillTextField;
    }
}
