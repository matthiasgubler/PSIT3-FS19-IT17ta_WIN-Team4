package com.zhaw.ch.skill7.view.skill;

import com.zhaw.ch.skill7.business.SkillService;
import com.zhaw.ch.skill7.interfaces.ISkillService;
import com.zhaw.ch.skill7.model.Skill;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;


public class SkillCreationController {

    private ISkillService skillService;

    @FXML
    private TextField newSkillTextField;

    public SkillCreationController() {
        this.skillService = new SkillService();
    }

    public SkillCreationController(ISkillService skillService) {
        this.skillService = skillService;
    }

    @FXML
    public void creationButtonClicked() {
        String skillNameValue = newSkillTextField.getText();
        System.out.println("Creation Button Clicked with value of TextField: " + skillNameValue);
        if (!StringUtils.isEmpty(skillNameValue)) {
            skillService.createSkill(new Skill(skillNameValue));
            newSkillTextField.setText("");
        }
    }

    TextField getNewSkillTextField() {
        return newSkillTextField;
    }

    void setNewSkillTextField(TextField newSkillTextField) {
        this.newSkillTextField = newSkillTextField;
    }
}
