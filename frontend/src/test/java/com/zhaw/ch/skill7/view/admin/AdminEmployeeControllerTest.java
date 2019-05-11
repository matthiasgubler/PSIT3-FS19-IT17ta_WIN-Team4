package com.zhaw.ch.skill7.view.admin;

import com.zhaw.ch.skill7.domain.model.Development;
import com.zhaw.ch.skill7.domain.model.DevelopmentRating;
import com.zhaw.ch.skill7.domain.model.Employee;
import com.zhaw.ch.skill7.domain.model.Skill;
import com.zhaw.ch.skill7.model.EmployeeAdminDevelopmentUI;
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
public class AdminEmployeeControllerTest extends BaseJavaFXTest {

    private AdminEmployeeTableController testee;
    private DevelopmentRating developmentRating = DevelopmentRating.MEDIUM;

    @Mock
    private Employee employeeMock;

    @Mock
    private Skill skillMock;

    @Mock
    private Development development1Mock;

    @Mock
    private Development development2Mock;

    @Mock
    private List<EmployeeAdminDevelopmentUI> adminEmployeeUIObservableListMock;

    @BeforeEach
    void setUp() {
        testee = new AdminEmployeeTableController(adminEmployeeUIObservableListMock);
    }

    @Test
    void reloadTable_empty() {
        when(skillMock.getDevelopments()).thenReturn(Arrays.asList());

        testee.reloadTable(skillMock);

        verify(skillMock).getDevelopments();
        verify(adminEmployeeUIObservableListMock).clear();
        verify(adminEmployeeUIObservableListMock).sort(any());
    }

    @Test
    void reloadTable() {
        when(skillMock.getDevelopments()).thenReturn(Arrays.asList(development1Mock, development2Mock));
        when(development1Mock.getEmployee()).thenReturn(employeeMock);
        when(development1Mock.getDevelopmentRating()).thenReturn(developmentRating);
        when(development2Mock.getEmployee()).thenReturn(employeeMock);
        when(development2Mock.getDevelopmentRating()).thenReturn(developmentRating);
        when(employeeMock.getId()).thenReturn((long)1);

        testee.reloadTable(skillMock);

        verify(skillMock).getDevelopments();
        verify(development1Mock).getEmployee();
        verify(development1Mock).getDevelopmentRating();
        verify(development2Mock).getEmployee();
        verify(development2Mock).getDevelopmentRating();
        verify(adminEmployeeUIObservableListMock).clear();
        verify(adminEmployeeUIObservableListMock, times(2)).add(any());
        verify(adminEmployeeUIObservableListMock).sort(any());
        verify(employeeMock, times(2)).getId();
    }
}
