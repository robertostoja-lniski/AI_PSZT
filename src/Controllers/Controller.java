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
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Function;
import sample.Main;
import sample.PopulationChart;
import sample.PopulationHandler;

import java.io.IOException;

public class Controller{

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

    @FXML
    private Slider generations;

    @FXML
    private TextField cfield;

    @FXML
    private TextField afield;

    @FXML
    private TextField bfield;

    @FXML
    private TextField dfield;


    public void init(int functionOption){

        Function chosenFunction = new Function( functionOption );
        Main.A = getAValue();
        Main.B = getBValue();
        Main.C = getCValue();
        Main.D = getDValue();
        Main.GENERATION_NUMBER = getSliderValue();

        Main.RANGE_X = Main.B - Main.A; // RANDOM COORDINATES FROM -100 TO 100;
        Main.RANGE_Y = Main.D - Main.C;  // CHANGABLE IF NEEDED.

        Main.DEFAULT_SIGMA_X = Main.RANGE_X * Main.DEFAULT_SIGMA_PARAM;
        Main.DEFAULT_SIGMA_Y = Main.RANGE_Y * Main.DEFAULT_SIGMA_PARAM;

        Main.ACCURACY_X = Main.RANGE_X / Main.INDIVIDUALS_IN_POPULATION;
        Main.ACCURACY_Y = Main.RANGE_Y / Main.INDIVIDUALS_IN_POPULATION;



        PopulationHandler populationToFindMax = new PopulationHandler( chosenFunction, Main.extremeType.MAX);
        populationToFindMax.generateFirstPopulation();

        PopulationHandler populationToFindMin = new PopulationHandler( chosenFunction, Main.extremeType.MIN);
        populationToFindMin.generateFirstPopulation();

        final Axis<Number> xAxis = new NumberAxis( Main.A, Main.B , X_TICKS );
        final Axis<Number> yAxis = new NumberAxis( Main.C, Main.D , Y_TICKS );

        PopulationChart populationChart  = new PopulationChart(xAxis,yAxis);

        Stage chartStage = new Stage();
        Scene scene  = new Scene(populationChart);
        chartStage.setScene(scene);
        chartStage.show();


        for (int i = 0; i < Main.GENERATION_NUMBER; i ++) {

            populationToFindMax.run();
            populationToFindMin.run();

        }

       // populationToFindMax.showAllPointsWithValues();
        populationChart.setValuesToFindMax(populationToFindMax.getPopulation());
        populationChart.setValuesToFindMin(populationToFindMin.getPopulation());
       // populationToFindMin.showAllPointsWithValues();
    }
    public double getSliderValue(){
        return generations.getValue();
    }

    public int getAValue(){
        return Integer.valueOf(afield.getText());
    }

    public int getBValue(){
        return Integer.valueOf(bfield.getText());
    }

    public int getCValue(){
        return Integer.valueOf(cfield.getText());
    }

    public int getDValue(){
        return Integer.valueOf(dfield.getText());
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
