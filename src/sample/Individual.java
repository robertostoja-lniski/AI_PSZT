package sample;

import java.util.Random;

public class Individual {

    private Point point;
    private double fitness;
    private double value;
    private int goodSteps;
    private int allSteps;

    public Individual(Point point, double fitness, double value){
        this.point = point;
        this.fitness = fitness;
        this.value = value;
        goodSteps = 0;
        allSteps = 0;
    }

    // nowy konstruktor rozwiazuje problemy z funkcji generate population
    // klasy population handler

    public Individual(Point point, double value) {

        this.point = point;
        this.fitness = 0;
        this.value = value;
    }

    public Point getPoint() {
        return point;
    }

    public double getFitness() {
        return fitness;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    // do uproszczenia evolvera
    public void becomeAChild(Individual child) {

        this.point = child.getPoint();
        this.value = child.getValue();
    }

    public void assignMutlipliedSigma(double multiplier) {

        point.setSigX(point.getSigX() * multiplier);
        point.setSigY(point.getSigY() * multiplier);
    }
    public void updateFitness(){ fitness = (double)goodSteps/(double)allSteps; }

    // tak w zasadzie to individual jest w stanie wygenerowac potomka
    // i to jest chyba bardziej logiczne
    // on sam rodzi, a nie ktos bierze jego czesci i klei z nich bachora.

    public Individual generateChild() {

        Random random = new Random();

        double xCord = getPoint().getX() + getPoint().getSigX() * random.nextGaussian(); //random x movement.
        double yCord = getPoint().getY() + getPoint().getSigY() * random.nextGaussian();// random y movement.

        Point childPoint = new Point( xCord , yCord );
        double functionValue = Function.calculateValue(childPoint);

        return new Individual( childPoint , functionValue );


    }

    public int getGoodSteps() {
        return goodSteps;
    }

    public int getAllSteps() {
        return allSteps;
    }

    public void incrementGoodSteps() {
        ++goodSteps;
    }

    public void incrementAllSteps() {
        ++allSteps;
    }

    @Override
    public String toString(){
        return "x: " + point.getX() + " |  y: " + point.getY() + " | value: " + value + " | fi: "+ fitness;
    }
}