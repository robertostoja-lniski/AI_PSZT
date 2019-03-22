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

        seriesMax.setName("Maxima");
        seriesMin.setName("Minima");

        this.setTitle("Populacja");

    }

    private boolean isBetween( double number, double lowerNumber, double higherNumber) {

        return ( number >= lowerNumber ) && ( number <= higherNumber );
    }
    /*
        Funkcja rysuje to co dostala jako argument wejsciowy

     */
    private void setValues(ArrayList<Individual> populationToPrint, XYChart.Series series) {

        for(Individual i : populationToPrint ){

            // sprawdzanie czy osobnik nalezy do zakresu
            // algorytm akceptuje osobników spoza zakresu, poniewaz
            // moze sie zdarzyc, ze w wyniku mutacji jego dziecko
            // bedzie lezalo do odpowiedniej plaszczyzny

          /*  double x = i.getX();
            if ( isBetween( x , Main.A, Main.B ) ) {

                double y = i.getY();
                if( isBetween( y , Main.C, Main.D ) ) {

                    series.getData().add(new XYChart.Data( x , y , 0.2));
                }
            } */

          double x = i.getX();
          double y = i.getY();

          series.getData().add(new XYChart.Data( x , y , 0.08));

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

    public Series getSeriesMax() {
        return seriesMax;
    }
}
