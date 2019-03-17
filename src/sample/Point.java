package sample;

import java.util.Random;

public class Point {

    private Random random;
    private double x;
    private double y;
    private double sigX;
    private double sigY;

    public Point(){
        random = new Random();
        x = random.nextDouble()*Main.RANGE_X - 10;
        y = random.nextDouble()*Main.RANGE_Y - 10;
        sigX = Main.RANGE_X*0.1;
        sigY = Main.RANGE_Y*0.1;
    }

    public Point(double x, double y, double sigX, double sigY) { //dodalem to dla metody crossOver.
        random = new Random();
        this.x = x;
        this.y = y;
        this.sigX = sigX;
        this.sigY = sigY;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        sigX = Main.RANGE_X*0.3;
        sigY = Main.RANGE_Y*0.3;
        random = new Random();
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSigX(double sigX) {
        this.sigX = sigX;
    }

    public void setSigY(double sigY) {
        this.sigY = sigY;
    }
}
