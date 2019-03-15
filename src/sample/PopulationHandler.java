package sample;

import java.util.ArrayList;
import java.util.Random;

public class PopulationHandler {

    private ArrayList<Individual> population; //point with its value
    private ArrayList<Individual> matingPool; // P suma R
    private Random random; // do losowania z koszyczka
    private double maxValue = -100000;
    private double minValue = 100000;
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
            if (value > maxValue)
                maxValue = value;
            if (value < minValue)
                minValue = value;
            double fitness = calculateFitness(maxValue,minValue,value);

        //jest zle powinno obliczac jakos fitness, dopiero po otrzymaniu wszystkich wartosci.

            population.add(new Individual(argumentPoint,fitness,value));
        }
    }

    private double calculateFitness(double maxValue, double minValue, double value){
        //TODO Mam pewien pomysl typowo do poprawy ALE:
        // (dziala tylko do szukania maximum)
        // fitness inicjuje na wartosc funkcji w punkcie
        // podnosze ta wartosc o modul z minimalnej wartosci tak, by kazdy fitness byl >= 0
        // dziele fitness przez "przedzial" zbioru wartosci od minimalnej do maksymalnej
        // podnosze to do 3 potegi, zeby czesciej losowac lepszy fitness.

        double fit = value;
        double range = maxValue - minValue;
        fit += Math.abs(minValue);

        fit /= range;

        fit = fit*fit*fit;

        return fit;
    }

    private void reproduction(){

        double maxFit = 0;
        double howManyTimesAddToMatingPool;


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
        double childsValue;
        double childsFitness;

        for (int i = 0; i < Main.POPULATION_SIZE; i++){

            indexParentA = random.nextInt(matingPool.size());
            indexParentB = random.nextInt(matingPool.size());

            Point child = evolver.crossOver(matingPool.get(indexParentA).getPoint(),matingPool.get(indexParentB).getPoint());   //krzyzuje wylosowane PUNKTY nie OSOBNIKI.

            evolver.mutation(child);    // mutuje dzieciaka.
            childsValue = Function.calculateValue(child);
            childsFitness = calculateFitness(maxValue,minValue,childsValue);
            //ten sam problem co powyzej
        }


    }



    public void run(){
        reproduction();
        selection();
    }
}
