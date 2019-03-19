package sample;

import java.util.Random;

import static sample.Function.*;

public class Individual extends Point{

    private double fitness;
    // podpowiedzial inteliJ
    // wartosc funkcji jest liczona od razu
    private double value;
    private int goodSteps;
    private int allSteps;
    //enum zastepuje minOrMax
    //private boolean minOrMax;
    private Main.extremeType extremeType;
    private Function function;

    /*
        konstruktory wywoluja konstruktor klasy bazowej i tyle
     */
    // nie powinno tu byc chyba tego min or max
    // wyglada dziwnie, ale postaram sie zmienic za jakis czas

    public Individual(double x, double y, double sigX , double sigY, Main.extremeType extremeType, Function function) {

        super( x,  y,  sigX,  sigY);
        this.extremeType = extremeType;
        // szukanie minimum upraszcza sie do
        // szukania maksimum funkcji pomnozonej przez -1

        this.function = function;
        value = function.calculateValue(this) * ( extremeType == Main.extremeType.MAX ? 1 : -1 );


    }

    /*
    dziwna i brzydka metoda :/
    ale nie dziala individual = child
    jak ogarne czemu tak jest to zmienie
     */

    public void becomeAChild(Individual child) {

        // copies base class properties
        this.x = child.getX();
        this.y = child.getY();
        this.sigX = child.getSigX();
        this.sigY = child.getSigY();
        // copies algorithm properties
        this.goodSteps = child.getGoodSteps();
        this.allSteps = child.getAllSteps();
        // copies value and fitness
        this.value = child.getValue();
        this.fitness = child.getFitness();

    }

    public double getFitness() {
        return fitness;
    }

    public double getValue() {
        return value;
    }

    public int getGoodSteps() {
        return goodSteps;
    }

    public int getAllSteps() {
        return allSteps;
    }

    public void assignMutlipliedSigma(double multiplier) {

        sigX = sigX * multiplier;
        sigY = sigY * multiplier;

    }

    public void updateFitness(){

        // pamietaj cholero, nie dziel przez zero
        try {

            fitness = (double)goodSteps/(double)allSteps;

        } catch(ArithmeticException e) {

            System.err.println("Error in updating Fitness");
        }

    }

    public Individual generateChild() {

        /*
            rodzic rodzi dziecko
            zmienia wlasne cechy zgodnie z wykladem
            i zwraca nowego potomka
         */
        Random random = new Random();

        double childX =  x + sigX * random.nextGaussian();
        double childY = y + sigY * random.nextGaussian();

        return new Individual( childX , childY , sigX, sigY, this.extremeType, function);

    }

    public void incrementGoodSteps() {
        ++goodSteps;
    }

    public void incrementAllSteps() {
        ++allSteps;
    }

    @Override
    public String toString(){
        return "x: " + x+ " |  y: " + y + " | value: " + value + " | fi: "+ fitness;
    }
}