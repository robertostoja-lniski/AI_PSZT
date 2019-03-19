package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

public class Main extends Application {

    public static final double A = -10;
    public static final double B = 10;
    public static final double C = -10;
    public static final double D = 10;

    public static final double X_TICKS = 2;
    public static final double Y_TICKS = 2;

    public static final double RANGE_X = B - A; // RANDOM COORDINATES FROM -100 TO 100;
    public static final double RANGE_Y = D - C;  // CHANGABLE IF NEEDED.
    public static final double POPULATION_SIZE = RANGE_X*RANGE_Y;  // po 1 na kazdy kwadracik.

    public static final double DEFAULT_SIGMA_X = RANGE_X * 0.3;
    public static final double DEFAULT_SIGMA_Y = RANGE_Y * 0.3;
    public static final int DIMENSION = 2;

    @Override
    public void start(Stage primaryStage) throws Exception{

        // kod zakomentowany jest przed zmiana

        Parent root = FXMLLoader.load(getClass().getResource("../FXML_Files/sample.fxml"));
        primaryStage.setTitle("Project PSZT");
        primaryStage.setResizable(false);
        //populationChart.setValues(population.getPopulation());
       /* startAnimating();
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show(); */

        Scene scene  = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


        // tworze dwie osie, oraz instancje klasy populationChart -
        // odpowiednik widoku - klase ktora rysuje przepiekne wykresy :)

       // populationToFindMax.showAllPointsWithValues();

    }

    public static void main(String[] args) {
        launch(args);
    }
}