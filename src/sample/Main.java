package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int RANGE_X = 20; // RANDOM COORDINATES FROM -100 TO 100;
    public static final int RANGE_Y = RANGE_X;  // CHANGABLE IF NEEDED.
    public static final int POPULATION_SIZE = 1000;
    public static final double MUTATION_RATE = 0.01;

    @Override
    public void start(Stage primaryStage) throws Exception{

        // kod zakomentowany jest przed zmiana

       /* Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Project PSZT");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show(); */



       // tworze dwie osie, oraz instancje klasy populationChart -
       // odpowiednik widoku - klase ktora rysuje przepiekne wykresy :)


        primaryStage.setTitle("Chart");

        final Axis<Number> xAxis = new NumberAxis(-10, 10, 2);
        final Axis<Number> yAxis = new NumberAxis(-10, 10, 2);

        PopulationChart populationChart  = new PopulationChart(xAxis,yAxis);
        populationChart.setDefaultValues();

        Scene scene  = new Scene(populationChart);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}