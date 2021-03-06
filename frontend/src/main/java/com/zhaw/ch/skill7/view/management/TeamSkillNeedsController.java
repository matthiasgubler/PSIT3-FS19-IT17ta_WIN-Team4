package com.zhaw.ch.skill7.view.management;

import com.zhaw.ch.skill7.domain.model.Team;
import com.zhaw.ch.skill7.model.DummyTeam;
import com.zhaw.ch.skill7.view.barchart.AbstractBarChartController;

import java.util.Map;

public class TeamSkillNeedsController extends AbstractBarChartController {

    private static final String TITLE = "Team-Bedürfnisse in der Unternehmung";

    private Team selectedTeam;

    public TeamSkillNeedsController() {
        this.selectedTeam = new DummyTeam();
    }

    public TeamSkillNeedsController(Team selectedTeam) {
        this.selectedTeam = selectedTeam;
    }

    @Override
    protected String getTitle() {
        return TITLE;
    }

    @Override
    protected Map<String, Long> loadBarChartDataWithCount() {
        return selectedTeam.getSkillNeeds();
    }

    void teamChanged(Team newTeam) {
        if (newTeam != null) {
            selectedTeam = newTeam;
            reloadBarChartData();
        }
    }
}
