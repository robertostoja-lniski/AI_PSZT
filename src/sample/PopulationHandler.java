package sample;

import java.util.ArrayList;
import java.util.Random;

public class PopulationHandler {

    private ArrayList<Individual> population; //point with its value
    private Random random; // do losowania z koszyczka
    private Evolver evolver;


    public PopulationHandler() {

        population = new ArrayList<>();
        random = new Random();
        evolver = new Evolver();
    }

    public ArrayList<Individual> getPopulation() {

        return population;
    }

    public void generateFirstPopulation() {

        for (int i = -Main.RANGE_X/2; i <= Main.RANGE_X/2; i++) {

            for (int j = -Main.RANGE_Y/2; j <= Main.RANGE_Y/2; j++) {

                Point argumentPoint = new Point(i, j);   // new Point for every small square
                double value = Function.calculateValue(argumentPoint);  //set value to this point
                population.add(new Individual(argumentPoint, value)); //add to first generation

            }
        }
    }

    public void showAllPointsWithValues(){
        for (Individual ind: population){
            System.out.println(ind);
        }
    }

    public void run() {
        for (Individual ind: population){
                evolver.stepForwardOrDontMove(ind);
        }
    }

}