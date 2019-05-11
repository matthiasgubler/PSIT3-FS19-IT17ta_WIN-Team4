package com.zhaw.ch.skill7.view.management;

import com.zhaw.ch.skill7.domain.model.Team;
import com.zhaw.ch.skill7.model.DummyTeam;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.util.Map;

public class TeamMemberSkillsController {

    private static final String TITLE = "Team-Mitglieder Skills";

    private Map<String, Map<String, Long>> barChartData;

    @FXML
    private BarChart barChartMemberSkills;

    private Team selectedTeam;

    public TeamMemberSkillsController() {
        this.selectedTeam = new DummyTeam();
    }

    public TeamMemberSkillsController(Team selectedTeam) {
        this.selectedTeam = selectedTeam;
    }

    @FXML
    private void initialize() {
        barChartMemberSkills.setTitle(TITLE);
        reloadBarChartData();
    }

    public void reloadBarChartData() {
        barChartData = loadBarChartDataWithCount();
        fillBarChart();
    }

    private void fillBarChart() {
        barChartMemberSkills.getData().clear();

        for (Map.Entry<String, Map<String, Long>> stringMapEntry : barChartData.entrySet()) {
            XYChart.Series series = new XYChart.Series();
            series.setName(stringMapEntry.getKey());
            for (Map.Entry<String, Long> entry : stringMapEntry.getValue().entrySet()) {
                series.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
            }
            barChartMemberSkills.getData().add(series);
        }

    }

    protected Map<String, Map<String, Long>> loadBarChartDataWithCount() {
        return selectedTeam.getMemberSkillsAsMap();
    }

    void teamChanged(Team newTeam) {
        if (newTeam != null) {
            selectedTeam = newTeam;
            reloadBarChartData();
        }
    }
}
