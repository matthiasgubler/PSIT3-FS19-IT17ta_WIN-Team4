package com.zhaw.ch.skill7.view.admin;

import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.interfaces.ICompany;
import com.zhaw.ch.skill7.model.SkillAdminDevelopmentUI;
import com.zhaw.ch.skill7.view.BaseJavaFXTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdminDevelopmentTableControllerTest extends BaseJavaFXTest {

    private AdminDevelopmentTableController testee;

    @Mock
    private ICompany companyMock;

    @Mock
    private Skill skill1Mock;

    @Mock
    private Skill skill2Mock;

    @Mock
    private List<SkillAdminDevelopmentUI> adminDevelopmentUIListMock;

    @BeforeEach
    void setUp() {
        testee = new AdminDevelopmentTableController(companyMock, adminDevelopmentUIListMock);
    }

    @Test
    void reloadTable_empty() {
        when(companyMock.getSkillsForDevelopmentWorkshop()).thenReturn(Arrays.asList());

        testee.reloadTable();

        verify(companyMock).getSkillsForDevelopmentWorkshop();
        verify(adminDevelopmentUIListMock).clear();
    }

    @Test
    void reloadTable() {
        when(skill1Mock.getSkillDevelopmentCount()).thenReturn(3);
        when(skill2Mock.getSkillDevelopmentCount()).thenReturn(5);
        when(companyMock.getSkillsForDevelopmentWorkshop()).thenReturn(Arrays.asList(skill1Mock, skill2Mock));

        testee.reloadTable();

        verify(companyMock).getSkillsForDevelopmentWorkshop();
        verify(skill1Mock).getSkillDevelopmentCount();
        verify(skill2Mock).getSkillDevelopmentCount();
        verify(adminDevelopmentUIListMock).clear();
        verify(adminDevelopmentUIListMock, times(2)).add(any());
    }
}
