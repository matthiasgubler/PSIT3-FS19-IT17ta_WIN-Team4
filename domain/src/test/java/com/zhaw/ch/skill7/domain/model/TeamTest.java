package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TeamTest {

    private Team testee;

    @Mock
    private IGenericDAO<SkillTeamRating> skillRatingIGenericDAOMock;

    @Mock
    private IGenericDAO<Employee> employeeIGenericDAOMock;


    @BeforeEach
    void setUp() {
        testee = new Team(skillRatingIGenericDAOMock, employeeIGenericDAOMock);
        testee.setName("TestTeam");
    }

    @Test
    void getEmployeeList_empty() {
        testee.getEmployeeList();
        verify(employeeIGenericDAOMock).read();
    }

    @Test
    void getEmployeeList() {
        Employee employee1 = mock(Employee.class);
        when(employee1.getTeam()).thenReturn(testee);
        Employee employeeWrongTeam = mock(Employee.class);
        when(employeeWrongTeam.getTeam()).thenReturn(new Team());

        when(employeeIGenericDAOMock.read()).thenReturn(Arrays.asList(employee1, employeeWrongTeam));
        List<Employee> result = testee.getEmployeeList();
        assertEquals(1, result.size());
        verify(employeeIGenericDAOMock).read();
    }

    @Test
    void getSkillRatingList_empty() {
        testee.getSkillRatingList();
        verify(skillRatingIGenericDAOMock).read();
    }

    @Test
    void getSkillRatingList() {
        SkillTeamRating skillTeamRating1 = mock(SkillTeamRating.class);
        when(skillTeamRating1.getTeam()).thenReturn(testee);

        SkillTeamRating skillTeamRatingWrongTeam = mock(SkillTeamRating.class);
        when(skillTeamRatingWrongTeam.getTeam()).thenReturn(new Team());

        when(skillRatingIGenericDAOMock.read()).thenReturn(Arrays.asList(skillTeamRating1, skillTeamRatingWrongTeam));

        List<SkillTeamRating> result = testee.getSkillRatingList();
        assertEquals(1, result.size());
        verify(skillRatingIGenericDAOMock).read();
    }

    @Test
    void getSkillNeeds_empty() {
        Map<String, Long> result = testee.getSkillNeeds();
        assertEquals(0, result.size());
        verify(skillRatingIGenericDAOMock).read();
    }

    @Test
    void getSkillNeeds() {
        Skill skill1 = mock(Skill.class);
        when(skill1.getName()).thenReturn("1");
        Skill skill2 = mock(Skill.class);
        when(skill2.getName()).thenReturn("2");

        SkillTeamRating skillTeamRating1 = mock(SkillTeamRating.class);
        when(skillTeamRating1.getTeam()).thenReturn(testee);
        SkillTeamRating skillTeamRating2 = mock(SkillTeamRating.class);
        when(skillTeamRating2.getTeam()).thenReturn(testee);
        when(skillRatingIGenericDAOMock.read()).thenReturn(Arrays.asList(skillTeamRating1, skillTeamRating2));

        Map<String, Long> result = testee.getSkillNeeds();
        assertEquals(2, result.size());
        verify(skillRatingIGenericDAOMock).read();
    }

    @Test
    void getMemberSkills_empty() {
        Map<String, Map<String, Long>> result = testee.getMemberSkills();
        assertEquals(0, result.size());
        verify(employeeIGenericDAOMock).read();
    }

    @Test
    void getMemberSkills() {
        Skill skill1 = mock(Skill.class);
        when(skill1.getName()).thenReturn("1");
        Skill skill2 = mock(Skill.class);
        when(skill2.getName()).thenReturn("2");

        Employee employee1 = mock(Employee.class);
        when(employee1.getFirstname()).thenReturn("Fred");
        when(employee1.getTeam()).thenReturn(testee);
        SkillEmployeeRating skillEmployeeRating1 = mock(SkillEmployeeRating.class);
        when(skillEmployeeRating1.getSkill()).thenReturn(skill1);
        when(skillEmployeeRating1.getEmployee()).thenReturn(employee1);

        SkillEmployeeRating skillEmployeeRating2 = mock(SkillEmployeeRating.class);
        when(skillEmployeeRating2.getSkill()).thenReturn(skill2);
        when(skillEmployeeRating2.getEmployee()).thenReturn(employee1);
        when(employee1.getSkillRatingList()).thenReturn(Arrays.asList(skillEmployeeRating1, skillEmployeeRating2));

        Employee employee2 = mock(Employee.class);
        when(employee1.getFirstname()).thenReturn("Fritz");
        when(employee2.getTeam()).thenReturn(testee);
        SkillEmployeeRating skillEmployeeRating3 = mock(SkillEmployeeRating.class);
        when(skillEmployeeRating3.getSkill()).thenReturn(skill1);
        when(skillEmployeeRating3.getEmployee()).thenReturn(employee2);
        when(employee2.getSkillRatingList()).thenReturn(Arrays.asList(skillEmployeeRating3));

        when(employeeIGenericDAOMock.read()).thenReturn(Arrays.asList(employee1, employee2));

        Map<String, Map<String, Long>> result = testee.getMemberSkills();
        Map<String, Long> resultSkill1 = result.get("1");
        Map<String, Long> resultSkill2 = result.get("2");

        assertEquals(2, result.size());
        assertEquals(2, resultSkill1.size());
        assertEquals(1, resultSkill2.size());

        verify(employeeIGenericDAOMock).read();
    }
}