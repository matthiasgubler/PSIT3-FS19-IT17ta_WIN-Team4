package com.zhaw.ch.skill7.view.management;

import com.zhaw.ch.skill7.domain.model.Team;
import com.zhaw.ch.skill7.view.BaseJavaFXTest;
import com.zhaw.ch.skill7.view.barchart.BarChartDistributionView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TeamSkillNeedsControllerTest extends BaseJavaFXTest {

    private TeamSkillNeedsController testee;

    @Mock
    private Team teamMock;

    @Mock
    private BarChartDistributionView barChartDistributionViewMock;

    @BeforeEach
    void setUp() {
        testee = spy(new TeamSkillNeedsController(teamMock));
        testee.setBarChartDistributionView(barChartDistributionViewMock);
    }

    @Test
    void loadBarChartDataWithCount() {
        testee.loadBarChartDataWithCount();
        verify(teamMock).getSkillNeeds();
    }

}