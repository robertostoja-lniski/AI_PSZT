package sample;

import javafx.scene.chart.Axis;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.Random;

public class PopulationChart extends BubbleChart {

    private Axis xAxis;
    private Axis yAxis;
    private XYChart.Series seriesMax;
    private XYChart.Series seriesMin;

    public PopulationChart(Axis xAxis, Axis yAxis) {

        super(xAxis, yAxis);

        this.xAxis = xAxis;
        this.yAxis = yAxis;

        seriesMax = new XYChart.Series<>();
        seriesMin = new XYChart.Series<>();

        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        this.setTitle("Populacja");

    }

    public void setDefaultValues() {


        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();

        Random random = new Random();

        for (int i = 0 ; i < 500; ++i) {

            double x = random.nextDouble() * Main.RANGE_X + Main.A;
            double y = random.nextDouble() * Main.RANGE_Y + Main.C;

            // jesli w odleglosci maksymalnie 4 od srodka
            // kolor czerwony
            // jesli od 4 do 8 zolty
            // jesli dalej zielony

            if( x * x + y * y <= 16) {

                series1.getData().add(new XYChart.Data( x , y , 0.2));

            } else if( x * x + y * y <= 64) {

                series2.getData().add(new XYChart.Data( x , y , 0.2));

            } else {

                series3.getData().add(new XYChart.Data( x , y , 0.2));
            }

        }

        this.getData().addAll(series1, series2, series3);
    }
    /*
        Funkcja rysuje to co dostala jako argument wejsciowy

     */
    private void setValues(ArrayList<Individual> populationToPrint, XYChart.Series series) {

        for(Individual i : populationToPrint ){

            double x = i.getX();
            double y = i.getY();

            series.getData().add(new XYChart.Data( x , y , 0.2));
        }

        this.getData().addAll(series);
    }


    public void setValuesToFindMax(ArrayList<Individual> populationToPrint) {

       // seriesMax.getData().removeAll();
        setValues(populationToPrint, seriesMax);

    }
    public void setValuesToFindMin(ArrayList<Individual> populationToPrint) {

       // seriesMax.getData().removeAll();
        setValues(populationToPrint, seriesMin);

    }

}
