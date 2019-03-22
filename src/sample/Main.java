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

    public static double A = -10;
    public static double B = 10;
    public static double C = -10;
    public static double D = 10;

    public static double RANGE_X = B - A; // RANDOM COORDINATES FROM -100 TO 100;
    public static double RANGE_Y = D - C;  // CHANGABLE IF NEEDED.

    public static double DEFAULT_SIGMA_X = RANGE_X * 0.03;
    public static double DEFAULT_SIGMA_Y = RANGE_Y * 0.03;

    public static double GENERATION_NUMBER = 40;
    public static double ACCURACY_X = RANGE_X / GENERATION_NUMBER;
    public static double ACCURACY_Y = RANGE_Y / GENERATION_NUMBER;


    public enum extremeType{ MIN, MAX};

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../FXML_Files/sample.fxml"));
        primaryStage.setTitle("Project PSZT");
        primaryStage.setResizable(false);


        Scene scene  = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    public void setPublicParams() {
        // TODO
    }
    public static void main(String[] args) {
        launch(args);
    }
}