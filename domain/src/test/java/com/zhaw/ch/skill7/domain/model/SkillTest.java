package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SkillTest {

    private Skill testee;
    private DevelopmentRating ratingLow = DevelopmentRating.LOW;
    private DevelopmentRating ratingMedium = DevelopmentRating.MEDIUM;
    private DevelopmentRating ratingHigh = DevelopmentRating.HIGH;

    @Mock
    private IGenericDAO<SkillEmployeeRating> skillEmployeeRatingIGenericDAOMock;

    @Mock
    private IGenericDAO<Development> developmentIGenericDAOMock;

    @Mock
    private Development development1 = mock(Development.class);
    
    @Mock
    private Development development2 = mock(Development.class);
    
    @Mock
    private Development developmentDifferent = mock(Development.class);


    @BeforeEach
    void setUp() {
        testee = new Skill(skillEmployeeRatingIGenericDAOMock, developmentIGenericDAOMock);
    }

    @Test
    void getDevelopments_empty() {
        when(developmentIGenericDAOMock.read()).thenReturn(Arrays.asList());

        List<Development> developmentListResult = testee.getDevelopments();
        
        assertEquals(true, developmentListResult.isEmpty());

        verify(developmentIGenericDAOMock).read();
    }

    @Test
    void getDevelopments() {
        when(development1.getSkill()).thenReturn(testee);
        when(development2.getSkill()).thenReturn(testee);
        when(developmentDifferent.getSkill()).thenReturn(new Skill("Other"));
        when(developmentIGenericDAOMock.read()).thenReturn(Arrays.asList(development1, development2, developmentDifferent));

        List<Development> developmentListResult = testee.getDevelopments();

        assertEquals(2, developmentListResult.size());
        assertEquals(development1, developmentListResult.get(0));
        assertEquals(development2, developmentListResult.get(1));

        verify(developmentIGenericDAOMock).read();
        verify(development1).getSkill();
        verify(development2).getSkill();
        verify(developmentDifferent).getSkill();
    }

    @Test
    void getSkillDevelopmentCount_empty() {
        when(developmentIGenericDAOMock.read()).thenReturn(Arrays.asList());
        
        int developmentCountResult = testee.getSkillDevelopmentCount();

        assertEquals(0, developmentCountResult);
    }

    @Test
    void getSkillDevelopmentCount() {
        when(development1.getSkill()).thenReturn(testee);
        when(development2.getSkill()).thenReturn(testee);
        when(developmentIGenericDAOMock.read()).thenReturn(Arrays.asList(development1, development2));
        
        int developmentCountResult = testee.getSkillDevelopmentCount();

        assertEquals(2, developmentCountResult);

        verify(development1).getSkill();
        verify(development2).getSkill();
        verify(developmentDifferent).getSkill();
        verify(developmentIGenericDAOMock).read();
    }

    @Test
    void getSkillDevelopmentCountByRating_empty() {
        when(developmentIGenericDAOMock.read()).thenReturn(Arrays.asList());
        
        int developmentCountResult = testee.getSkillDevelopmentCountByRating(DevelopmentRating.MEDIUM);

        assertEquals(0, developmentCountResult);

        verify(developmentIGenericDAOMock).read();
    }

    @Test
    void getSkillDevelopmentCountByRating() {
        when(development1.getSkill()).thenReturn(testee);
        when(development2.getSkill()).thenReturn(testee);
        when(developmentDifferent.getSkill()).thenReturn(testee);
        when(development1.getDevelopmentRating()).thenReturn(ratingHigh);
        when(development2.getDevelopmentRating()).thenReturn(ratingMedium);
        when(developmentDifferent.getDevelopmentRating()).thenReturn(ratingLow);
        when(developmentIGenericDAOMock.read()).thenReturn(Arrays.asList(development1, development2, developmentDifferent));
        
        int developmentCountResult = testee.getSkillDevelopmentCountByRating(ratingMedium);

        assertEquals(2, developmentCountResult);

        verify(development1).getSkill();
        verify(development2).getSkill();
        verify(developmentDifferent).getSkill();
        verify(developmentIGenericDAOMock).read();
        verify(development1).getDevelopmentRating();
        verify(development2).getDevelopmentRating();
        verify(developmentDifferent).getDevelopmentRating();
    }
}