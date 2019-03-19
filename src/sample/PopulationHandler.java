package sample;

import java.util.ArrayList;
import java.util.Random;

public class PopulationHandler {

    private ArrayList<Individual> population; //point with its value
    private Random random; // do losowania z koszyczka
    private Evolver evolver;
    // parametr do wyboru rodzaju ekstremum
    // wieksza czytelnosc w wypadku enum
    private Main.extremeType extremeType;
    private Function chosenFunction;

    public PopulationHandler(Function chosenFunction, Main.extremeType extremeType ) {

        this.extremeType = extremeType;
        population = new ArrayList<>();
        random = new Random();
        evolver = new Evolver();
        this.chosenFunction = chosenFunction;

    }



    public ArrayList<Individual> getPopulation() {

        return population;
    }

    public void generateFirstPopulation() {

        for (int x = (int)Main.A; x <= (int)Main.B; ++x) {

            for (int y = (int)Main.C; y <= (int)Main.D; ++y) {

                population.add(new Individual(x, y, Main.DEFAULT_SIGMA_X, Main.DEFAULT_SIGMA_Y, extremeType , chosenFunction) );

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
                evolver.stepForwardOrDontMove( ind );
        }
    }



}