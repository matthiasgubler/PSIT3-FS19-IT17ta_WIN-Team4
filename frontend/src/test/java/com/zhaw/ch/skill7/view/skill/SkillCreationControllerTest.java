package com.zhaw.ch.skill7.view.skill;

import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.view.BaseJavaFXTest;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SkillCreationControllerTest extends BaseJavaFXTest {

    private SkillCreationController testee;

    @Mock
    private ICompany companyMock;

    private final TextField newSkillTextFieldStub = new TextField();

    @BeforeEach
    void setUp() {
        testee = new SkillCreationController(companyMock);
        testee.setNewSkillTextField(newSkillTextFieldStub);
    }

    @Test
    void creationButtonClicked_empty_textfield_test() {
        newSkillTextFieldStub.setText("");
        testee.creationButtonClicked();
        verify(companyMock, never()).createSkill(any());
    }

    @Test
    void creationButtonClicked_nonempty_test() {
        newSkillTextFieldStub.setText("Skill");
        testee.creationButtonClicked();
        verify(companyMock).createSkill(any());
        assertEquals("", newSkillTextFieldStub.getText());
    }

}