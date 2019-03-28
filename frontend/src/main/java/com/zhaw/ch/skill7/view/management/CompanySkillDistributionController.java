package com.zhaw.ch.skill7.view.management;

import com.zhaw.ch.skill7.domain.CompanyData;
import com.zhaw.ch.skill7.helper.MapSupport;
import com.zhaw.ch.skill7.interfaces.ICompany;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.util.Map;

public class CompanySkillDistributionController {

    private final ICompany company;

    private Map<String, Integer> sortedSkillsCountMap;

    @FXML
    private BarChart barChart;

    public CompanySkillDistributionController() {
        this.company = new CompanyData();
    }

    public CompanySkillDistributionController(ICompany company) {
        this.company = company;
    }

    @FXML
    private void initialize() {
        reloadBarChartData();
    }

    private void reloadBarChartData() {
        sortedSkillsCountMap = MapSupport.sortByValue(company.getSkillDistribution());
        fillBarChart();
    }

    @FXML
    private void reloadSkillDistribution() {
        reloadBarChartData();
    }

    private void fillBarChart() {
        barChart.getData().clear();

        for (Map.Entry<String, Integer> entry : sortedSkillsCountMap.entrySet()) {
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
            barChart.getData().add(series);
        }
    }

}
