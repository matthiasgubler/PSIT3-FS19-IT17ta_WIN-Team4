package com.zhaw.ch.skill7.view.barchart;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BarChartDistributionView extends AnchorPane {

    @FXML
    private BarChart barChart;

    @FXML
    private Button reloadButton;
    @FXML
    private final ObjectProperty<EventHandler<ActionEvent>> onReloadButtonAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {

        @Override
        protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "onReloadButtonAction";
        }
    };

    public BarChartDistributionView() {
        FXMLLoader fxmlLoader = new FXMLLoader(BarChartDistributionView.class.getResource(
                "BarChartDistributionView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {
        reloadButton.setOnAction(onReloadButtonAction.get());
    }

    public BarChart getBarChart() {
        return barChart;
    }

    public void setBarChart(BarChart barChart) {
        this.barChart = barChart;
    }

    public final ObjectProperty<EventHandler<ActionEvent>> onReloadButtonActionProperty() {
        return onReloadButtonAction;
    }

    public final EventHandler<ActionEvent> getOnReloadButtonAction() {
        return onReloadButtonActionProperty().get();
    }

    public final void setOnReloadButtonAction(EventHandler<ActionEvent> value) {
        onReloadButtonActionProperty().set(value);
    }

}