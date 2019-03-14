package sample;

import java.util.Random;

public class Point {

    private Random random;
    private double x;
    private double y;
    private double sigX;
    private double sigY;
    private double fitness;

    public Point(){
     random = new Random();
     x = random.nextDouble()*Main.RANGE_X - 100;
     y = random.nextDouble()*Main.RANGE_Y - 100;
     sigX = Main.RANGE_X*0.01;
     sigY = Main.RANGE_Y*0.01;
     fitness = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSigX() {
        return sigX;
    }

    public double getSigY() {
        return sigY;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }
}
