package sample;

import java.util.Random;

public class Point {

    protected double x;
    protected double y;
    protected double sigX;
    protected double sigY;


    public Point(double x, double y, double sigX, double sigY) { //dodalem to dla metody crossOver.

        this.x = x;
        this.y = y;
        this.sigX = sigX;
        this.sigY = sigY;
    }

    public double getX() { return x; }

    public double getY() { return y; }

    public double getSigX() { return sigX; }

    public double getSigY() { return sigY; }
}
