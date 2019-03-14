package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int RANGE_X = 20; // RANDOM COORDINATES FROM -100 TO 100;
    public static final int RANGE_Y = RANGE_X;  // CHANGABLE IF NEEDED.
    public static final int POPULATION_SIZE = 1000;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Project PSZT");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
