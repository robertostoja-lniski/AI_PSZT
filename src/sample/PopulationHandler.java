package sample;

import java.util.ArrayList;
import java.util.Random;

public class PopulationHandler {

    private ArrayList<Individual> population; //point with its value
    private ArrayList<Individual> matingPool; // P suma R
    private Random random; // do losowania z koszyczka
    Evolver evolver;


    public PopulationHandler(){

        population = new ArrayList<>();
        matingPool = new ArrayList<>();
        random = new Random();
        evolver = new Evolver();
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
        return 0.5;
    }

    private void reproduction(){

        double maxFit = 0;
        double howManyTimesAddToMatingPool = 0;


        //NARAZIE TYLKO OBLICZAM MAXFIT DLA WYSWIETLENIA.
        for (int i = 0; i < Main.POPULATION_SIZE; i++){

            if (maxFit < population.get(i).getFitness())
                maxFit = population.get(i).getFitness();
        }

        //WRZUCAM DANEGO OSOBNIKA 10*FITNESS RAZY DO KOSZYCZKA. - 10 moze byc zmienione na cos innego zobaczymy jak wyjdzie fitness.
        for (int i = 0; i < Main.POPULATION_SIZE; i++){

            howManyTimesAddToMatingPool = population.get(i).getFitness()*10;

            for (int j = 0; j < howManyTimesAddToMatingPool; j++){
                matingPool.add(population.get(i));
            }

        }

    }

    private void selection(){

        //TODO select new population from mating pool
        int indexParentA; // wylosowany z koszyczka w przedziale 0 do matingPool.size() index rodzica A.
        int indexParentB; // wylosowany z koszyczka w przedziale 0 do matingPool.size() index rodzica B;

        for (int i = 0; i < Main.POPULATION_SIZE; i++){

            indexParentA = random.nextInt(matingPool.size());
            indexParentB = random.nextInt(matingPool.size());

            Point child = evolver.crossOver(matingPool.get(indexParentA).getPoint(),matingPool.get(indexParentB).getPoint());   //krzyzuje wylosowane PUNKTY nie OSOBNIKI.

            evolver.mutation(child);    // mutuje dzieciaka.
        }


    }


    public void run(){
        reproduction();
        selection();
    }
}
