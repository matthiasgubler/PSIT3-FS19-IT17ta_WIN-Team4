package com.zhaw.ch.skill7.view.barchart;

import com.zhaw.ch.skill7.helper.MapSupport;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;

import java.util.Map;

public abstract class AbstractBarChartController {

    private Map<String, Long> sortedBarChartData;

    @FXML
    private BarChartDistributionView barChartDistributionView;

    @FXML
    private void initialize() {
        barChartDistributionView.getBarChart().setTitle(getTitle());
        reloadBarChartData();
    }

    protected void reloadBarChartData() {
        sortedBarChartData = MapSupport.sortByValue(loadBarChartDataWithCount());
        fillBarChart();
    }

    protected abstract String getTitle();

    protected abstract Map<String, Long> loadBarChartDataWithCount();

    @FXML
    private void refreshButtonClicked() {
        reloadBarChartData();
    }

    private void fillBarChart() {
        barChartDistributionView.getBarChart().getData().clear();

        for (Map.Entry<String, Long> entry : sortedBarChartData.entrySet()) {
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
            barChartDistributionView.getBarChart().getData().add(series);
        }
    }
}
