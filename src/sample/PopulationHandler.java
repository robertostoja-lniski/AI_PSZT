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
    /*
        Poniewaz funcja najpierw generuje populacje, a potem oblicza fitness
        Rozsadniej byloby napisac dwie funkcje
        jedna tylko generuje, druga tylko oblicza fitness
        a jednej strony kosmetyka, ale z drugiej podobno funkcja powinna
        robic tylko jedna rzecz - lepsza struktura logiczna
     */
    public void generateFirstPopulation(){

        for (int i = 0; i < Main.POPULATION_SIZE; i++){

            Point argumentPoint = new Point();
            double value = Function.calculateValue(argumentPoint);
            population.add(new Individual(argumentPoint,value));

            setExtremes( value );
        }
        // naprawiony blad z komentarza - fitness liczony w nowej petli
    }

    private void setFitnessToEveryIndividual() {

        for (int i = 0 ; i < Main.POPULATION_SIZE; i++) {

            double value = population.get( i ).getValue();
            double fitness = calculateFitness( maxValue, minValue , value);
            population.get( i ).setFitness( fitness );

        }
    }
    private double calculateFitness(double maxValue, double minValue, double value){

        /*
        Fitness jak dla mnie spoko, dodam tylko
        obsluge wyjatku ( jakby max = min )
        proponuje zmiane na fit * fit jakby cos nie dzialalo,
        x ^ 3 rosnie baaardzo szybko

         */
        //TODO Mam pewien pomysl typowo do poprawy ALE:
        // (dziala tylko do szukania maximum)
        // fitness inicjuje na wartosc funkcji w punkcie
        // ### jesli i maksimum jest ujemne to zdanie ponizej lezy ###
        // podnosze ta wartosc o modul z minimalnej wartosci tak, by kazdy fitness byl >= 0
        // dziele fitness przez "przedzial" zbioru wartosci od minimalnej do maksymalnej
        // podnosze to do 3 potegi, zeby czesciej losowac lepszy fitness.

        // pomysl z range jest bardzo na TAK
        // ale mozemy na to spojrzec tak
        // mamy odcinek o dlugosc | range |
        // i im blizej wartosc jest punktu max, tym wiekszy fitness


        double totalRange = Math.abs(maxValue - minValue);
        double rangeFromMinToValue = Math.abs(value - minValue);

        // wiem ze dluga zmienna, ale chyba tylko taka nazwa
        // dokladnie mowi co ta zmienna robi :/

        /*
            chyba lepsza bylaby obsluga wyjatkow
            ale sam juz nie wiem

         */
        if( rangeFromMinToValue == 0 ) {

            return 0;
        }

        double rangeFromMinToValueToTotalRange = rangeFromMinToValue / totalRange;
        double fit = Math.cbrt(rangeFromMinToValueToTotalRange); // cbrt = cube root

        return fit;


        /*
        double fit = value;
        double range = maxValue - minValue;

        fit += Math.abs(minValue);

        fit /= range;

        fit = fit*fit*fit;

        return fit;
        */
    }

    private void reproduction(){

        double maxFit = 0;
        // super nazwa zmiennej :)
        double howManyTimesAddToMatingPool;


        //NARAZIE TYLKO OBLICZAM MAXFIT DLA WYSWIETLENIA.
        for (int i = 0; i < Main.POPULATION_SIZE; i++){

            maxFit = Math.max(population.get( i ).getFitness(), maxFit);

        }

        // 10 to za malo, dajmy 100 XD
        //WRZUCAM DANEGO OSOBNIKA 10 * FITNESS RAZY DO KOSZYCZKA. - 10 moze byc zmienione na cos innego zobaczymy jak wyjdzie fitness.

        for (int i = 0; i < Main.POPULATION_SIZE; i++){

            howManyTimesAddToMatingPool = population.get(i).getFitness()*10;

            for (int j = 0; j < howManyTimesAddToMatingPool; j++){

                matingPool.add(population.get(i));
            }

        }

    }

    public ArrayList<Individual> getPopulation() {

        return population;
    }
    public void printPopulation() {

        for (Individual i : population ) {

            System.out.println(i.getPoint().getX()
                               + " " + i.getPoint().getY()
                               + " " + i.getValue()
                               + " " + i.getFitness());
        }
    }
    private void selection(){

        //TODO select new population from mating pool

        int indexParentA; // wylosowany z koszyczka w przedziale 0 do matingPool.size() index rodzica A.
        int indexParentB; // wylosowany z koszyczka w przedziale 0 do matingPool.size() index rodzica B;

        for (int i = 0; i < Main.POPULATION_SIZE; i++){

            //TODO trzeba dodac warunek zeby nie losowalo 2 razy tego samego rodzica !
            indexParentA = random.nextInt(matingPool.size());
            indexParentB = random.nextInt(matingPool.size());

            Point child = evolver.crossOver(matingPool.get(indexParentA).getPoint(),matingPool.get(indexParentB).getPoint());   //krzyzuje wylosowane PUNKTY nie OSOBNIKI.

            if( random.nextDouble() <= Main.MUTATION_RATE ) child = evolver.mutation(child);    // mutuje dzieciaka.

            // dodaje dzieciaka do nowej populacji
            // obliczam wartosc i aktualizuje min, max
            // analogicznie jak w generate population

            double value = Function.calculateValue(child);
            population.set(i, new Individual(child, value));

            setExtremes( value );

            /* Poniewaz powstala metoda do liczenia fintessu kod ponizej jest niewazny
                Ponadto, maxValue i minValue sa juz nieaktualne !

                childsValue = Function.calculateValue(child);
                childsFitness = calculateFitness( maxValue , minValue , childsValue );
             */

            //ten sam problem co powyzej
        }


    }
    /*
    Przepisuje populacje
    mozliwe ze to bez sensu metoda, ale debuguje

     */

    /*
        inteliJ kazal, wykorzystywana dwukrotnie
     */
    private void setExtremes(double value) {

        maxValue = Math.max( value, maxValue );
        minValue = Math.min( value, minValue );
    }

    public void run(){

        setFitnessToEveryIndividual();
        printPopulation();
        reproduction();
        selection();
        clearMatingPool();
    }

    /*
        trzeba czyscic mating poola
     */
    private void clearMatingPool() {

        matingPool.clear();
    }
}
