package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Function;
import sample.Main;
import sample.PopulationChart;
import sample.PopulationHandler;

import java.io.IOException;

public class Controller{


    public static final double A = -10;
    public static final double B = 10;
    public static final double C = -10;
    public static final double D = 10;

    public static final double X_TICKS = 2;
    public static final double Y_TICKS = 2;

    @FXML
    private AnchorPane anPane;

    @FXML
    private Label title;

    @FXML
    private Button bt1;

    @FXML
    private Button bt4;

    @FXML
    private Button bt3;

    @FXML
    private Button bt2;

    @FXML
    private Label desc;


    public void init(int functionOption){

        Function chosenFunction = new Function( functionOption );

        PopulationHandler populationToFindMax = new PopulationHandler( chosenFunction, Main.extremeType.MAX);
        populationToFindMax.generateFirstPopulation();

        PopulationHandler populationToFindMin = new PopulationHandler( chosenFunction, Main.extremeType.MIN);
        populationToFindMin.generateFirstPopulation();

        final Axis<Number> xAxis = new NumberAxis( A, B , X_TICKS );
        final Axis<Number> yAxis = new NumberAxis( C, D , Y_TICKS );

        PopulationChart populationChart  = new PopulationChart(xAxis,yAxis);

        Stage chartStage = new Stage();
        Scene scene  = new Scene(populationChart);
        chartStage.setScene(scene);
        chartStage.show();

        for (int i = 0; i < Main.GENERATION_NUMBER; i ++) {

            populationToFindMax.run();
            populationToFindMin.run();
        }

        populationChart.setValuesToFindMax(populationToFindMax.getPopulation());
        populationChart.setValuesToFindMin(populationToFindMin.getPopulation());
       // populationToFindMin.showAllPointsWithValues();
    }
    @FXML
    void handlebt1(ActionEvent event) {
        init(1);
    }

    @FXML
    void handlebt2(ActionEvent event) {
        init(2);
    }

    @FXML
    void handlebt3(ActionEvent event) {
        init(3);
    }

    @FXML
    void handlebt4(ActionEvent event) {
        init(4);
    }

}
