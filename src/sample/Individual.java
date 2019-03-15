package sample;

public class Individual {

    private Point point;
    private double fitness;
    private double value;

    public Individual(Point point, double fitness, double value){
        this.point = point;
        this.fitness = fitness;
        this.value = value;
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

    public void setFitness(double fitness){
        this.fitness = fitness;
    }
}