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
import sample.PopulationChart;
import sample.PopulationHandler;

import java.io.IOException;

public class Controller{


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


    public void initStage(Button button){
        button.getScene().getWindow().hide();
        Stage chartStage = new Stage();
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("../FXML_Files/chart.fxml"));
        }   catch(IOException e){
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        chartStage.setScene(scene);
        chartStage.show();
    }
    @FXML
    void handlebt1(ActionEvent event) {
        initStage(bt1);
    }

    @FXML
    void handlebt2(ActionEvent event) {
        initStage(bt2);
    }

    @FXML
    void handlebt3(ActionEvent event) {
        initStage(bt3);
    }

    @FXML
    void handlebt4(ActionEvent event) {
        initStage(bt4);
    }

}
