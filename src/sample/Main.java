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

    public static final int RANGE_X = 20; // RANDOM COORDINATES FROM -100 TO 100;
    public static final int RANGE_Y = RANGE_X;  // CHANGABLE IF NEEDED.
    public static final int POPULATION_SIZE = 10000;
    public static final int DIMENSION = 2;
    public static final double MUTATION_RATE = 0.0001;

    @Override
    public void start(Stage primaryStage) throws Exception{

        // kod zakomentowany jest przed zmiana

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Project PSZT");
        primaryStage.setResizable(false);

        primaryStage.setTitle("Chart");

        final Axis<Number> xAxis = new NumberAxis(-10, 10, 2);
        final Axis<Number> yAxis = new NumberAxis(-10, 10, 2);

        PopulationChart populationChart  = new PopulationChart(xAxis,yAxis);

        PopulationHandler population = new PopulationHandler();
        population.generateFirstPopulation();

        for (int i = 0; i < 100; i ++) {

            population.run();
            Thread.sleep(100);

        }


       /* startAnimating();
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show(); */



        // tworze dwie osie, oraz instancje klasy populationChart -
        // odpowiednik widoku - klase ktora rysuje przepiekne wykresy :)


        populationChart.setValues(population.getPopulation());
        Scene scene  = new Scene(populationChart);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    private void startAnimating(){
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                System.out.println();
            }
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}