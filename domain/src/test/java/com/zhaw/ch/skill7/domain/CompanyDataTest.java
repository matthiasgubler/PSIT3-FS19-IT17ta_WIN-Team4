package com.zhaw.ch.skill7.domain;

import com.zhaw.ch.skill7.domain.model.*;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyDataTest {

    private CompanyData testee;

    @Mock
    private IGenericDAO<Skill> skillIGenericDAOMock;

    @Mock
    private IGenericDAO<Employee> employeeIGenericDAOMock;

    @Mock
    private IGenericDAO<Team> teamIGenericDAOMock;

    @Mock
    private IGenericDAO<Development> developmentIGenericDAOMock;

    @BeforeEach
    void setUp() {
        testee = new CompanyData(skillIGenericDAOMock, employeeIGenericDAOMock, teamIGenericDAOMock, developmentIGenericDAOMock);
    }

    @Test
    void createSkill() {
        testee.createSkill("NewSkill");
        verify(skillIGenericDAOMock).add(any());
    }

    @Test
    void getSkills_empty() {
        List<Skill> skillResultList = testee.getSkills();
        assertEquals(0, skillResultList.size());
        verify(skillIGenericDAOMock).read();
    }

    @Test
    void getSkills() {
        when(skillIGenericDAOMock.read()).thenReturn(Arrays.asList(new Skill("1"), new Skill("2")));
        List<Skill> skillResultList = testee.getSkills();
        assertEquals(2, skillResultList.size());
        verify(skillIGenericDAOMock).read();
    }

    @Test
    void getTeams_emtpy() {
        List<Team> teamResultList = testee.getTeams();
        assertEquals(0, teamResultList.size());
        verify(teamIGenericDAOMock).read();
    }

    @Test
    void getTeams() {
        when(teamIGenericDAOMock.read()).thenReturn(Arrays.asList(new Team("1"), new Team("2")));
        List<Team> teamResultList = testee.getTeams();
        assertEquals(2, teamResultList.size());
        verify(teamIGenericDAOMock).read();
    }

    @Test
    void getTeamById() {
        Team team2 = new Team("2");
        team2.setId(2L);

        when(teamIGenericDAOMock.byId(2L)).thenReturn(Optional.of(team2));
        Optional<Team> optTeamResult = testee.getTeamById(2L);
        assertTrue(optTeamResult.isPresent());
        assertEquals(2L, optTeamResult.get().getId());
        assertEquals("2", optTeamResult.get().getName());
        verify(teamIGenericDAOMock).byId(2L);
    }

    @Test
    void getTeamById_notfound() {
        Optional<Team> optTeamResult = testee.getTeamById(2L);
        assertFalse(optTeamResult.isPresent());
        verify(teamIGenericDAOMock).byId(2L);
    }

    @Test
    void getSkillDistribution() {
        Skill skill1 = mock(Skill.class);
        when(skill1.getName()).thenReturn("1");
        when(skill1.getSkillEmployeeRatings()).thenReturn(Collections.singletonList(new SkillEmployeeRating(1, null, null)));
        Skill skill2 = mock(Skill.class);
        when(skill2.getName()).thenReturn("2");
        when(skill2.getSkillEmployeeRatings()).thenReturn(Arrays.asList(new SkillEmployeeRating(1, null, null), new SkillEmployeeRating(1, null, null)));

        when(skillIGenericDAOMock.read()).thenReturn(Arrays.asList(skill1, skill2));
        Map<String, Long> result = testee.getSkillDistribution();
        verify(skillIGenericDAOMock).read();
        assertEquals(2, result.size());
        assertEquals(1, result.get("1"));
        assertEquals(2, result.get("2"));

        verify(skill1).getName();
        verify(skill1).getSkillEmployeeRatings();
        verify(skill2).getName();
        verify(skill2).getSkillEmployeeRatings();

    }

    @Test
    void getSkillDistribution_emtpy() {
        Map<String, Long> result = testee.getSkillDistribution();
        verify(skillIGenericDAOMock).read();
        assertEquals(0, result.size());
    }

    @Test
    void getDevelopmentDistribution_empty() {
        Map result = testee.getDevelopmentDistribution();
        assertEquals(0, result.size());
        verify(developmentIGenericDAOMock).read();
    }

    @Test
    void getDevelopmentDistribution() {
        Skill skill1 = mock(Skill.class);
        when(skill1.getName()).thenReturn("1");
        Development development1 = mock(Development.class);
        when(development1.getSkill()).thenReturn(skill1);

        Skill skill2 = mock(Skill.class);
        when(skill2.getName()).thenReturn("2");
        Development development2 = mock(Development.class);
        when(development2.getSkill()).thenReturn(skill2);

        Development development3 = mock(Development.class);
        when(development3.getSkill()).thenReturn(skill2);

        when(developmentIGenericDAOMock.read()).thenReturn(Arrays.asList(development1, development2, development3));
        Map<String, Long> result = testee.getDevelopmentDistribution();
        assertEquals(2, result.size());
        assertEquals(1, result.get("1"));
        assertEquals(2, result.get("2"));

        verify(developmentIGenericDAOMock).read();
    }

    @Test
    void getSkillsForDevelopmentWorkshop_noSkill() {
        when(skillIGenericDAOMock.read()).thenReturn(Arrays.asList());

        List<Skill> skillListResult = testee.getSkillsForDevelopmentWorkshop();

        assertEquals(true, skillListResult.isEmpty());

        verify(skillIGenericDAOMock).read();
    }

    @Test
    void getSkillsForDevelopmentWorkshop_noMatch() {
        testee.THRESHOLD_COUNT_EMPLOYEES = 3;
        Skill skill1 = mock(Skill.class);
        when(skill1.getSkillDevelopmentCountByRating(any())).thenReturn(1);
        Skill skill2 = mock(Skill.class);
        when(skill2.getSkillDevelopmentCountByRating(any())).thenReturn(2);

        when(skillIGenericDAOMock.read()).thenReturn(Arrays.asList(skill1, skill2));

        List<Skill> skillListResult = testee.getSkillsForDevelopmentWorkshop();

        assertEquals(true, skillListResult.isEmpty());

        verify(skillIGenericDAOMock).read();
        verify(skill1).getSkillDevelopmentCountByRating(any());
        verify(skill2).getSkillDevelopmentCountByRating(any());
    }

    @Test
    void getSkillsForDevelopmentWorkshop() {
        testee.THRESHOLD_COUNT_EMPLOYEES = 3;
        Skill skill1 = mock(Skill.class);
        when(skill1.getSkillDevelopmentCountByRating(any())).thenReturn(4);
        when(skill1.getId()).thenReturn((long)6);
        Skill skillWithoutDevelopment = mock(Skill.class);
        when(skillWithoutDevelopment.getSkillDevelopmentCountByRating(any())).thenReturn(2);
        Skill skill2 = mock(Skill.class);
        when(skill2.getSkillDevelopmentCountByRating(any())).thenReturn(3);
        when(skill2.getId()).thenReturn((long)3);
        when(skillIGenericDAOMock.read()).thenReturn(Arrays.asList(skill1, skillWithoutDevelopment, skill2));

        List<Skill> skillListResult = testee.getSkillsForDevelopmentWorkshop();

        assertEquals(2, skillListResult.size());
        assertEquals(skill2, skillListResult.get(0));
        assertEquals(skill1, skillListResult.get(1));

        verify(skillIGenericDAOMock).read();
        verify(skill1).getSkillDevelopmentCountByRating(any());
        verify(skill1).getId();
        verify(skill2).getSkillDevelopmentCountByRating(any());
        verify(skill2).getId();
        verify(skillWithoutDevelopment).getSkillDevelopmentCountByRating(any());
    }
}