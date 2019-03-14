package sample;

import java.util.ArrayList;

public class PopulationHandler {

    private ArrayList<Individual> population; //point with its value
    private ArrayList<Individual> matingPool; // P suma R


    public PopulationHandler(){
        population = new ArrayList<>();
        matingPool = new ArrayList<>();
    }

    public void generateFirstPopulation(){

        for (int i = 0; i < Main.POPULATION_SIZE; i++){

            Point argumentPoint = new Point();
            double value = Function.calculateValue(argumentPoint);
            double fitness = calculateFitness();

            population.add(new Individual(argumentPoint,fitness,value));
        }
    }

    private double calculateFitness(){
        //TODO
        return 0;
    }

    private void reproduction(){
        //TODO filling the mating pool using fitness (crossover and mutation)
    }

    private void selection(){
        //TODO select new population from mating pool
    }


    public void run(){
        reproduction();;
        selection();
    }
}
