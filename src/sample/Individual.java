package sample;

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

    public void updateFitness(){
        fitness = goodSteps/allSteps;
    }

    public int getGoodSteps() {
        return goodSteps;
    }

    public int getAllSteps() {
        return allSteps;
    }

    public void setGoodSteps(int goodSteps) {
        this.goodSteps = goodSteps;
    }

    public void setAllSteps(int allSteps) {
        this.allSteps = allSteps;
    }
}