package sample;

import java.util.Random;

public class Evolver {

    //TODO OBECNIE NAJGORSZY CHYBA PROBLEM: WYJEZDZAMY POZA WYBRANY PRZEDZIAL NP: [0;10]x[0;10] WYNIKI WYCHODZA SPOKO, ALE W OKOLICACH NP. X = -150, Y=48
    //TODO POTRZEBA ZMIENIC METODE LOSUJACA PUNKTY TAK, BY ZAWSZE LOSOWALO PUNKTY TYLKO Z PRZEDZIALU.
    private Random random;

    public Evolver(){

        random = new Random();
    }

    public void StepForwardOrDontMove(Individual individual){

        double xCoor = random.nextDouble()*individual.getPoint().getSigX()*2 - individual.getPoint().getSigX(); //random x movement.
        double yCoor = random.nextDouble()*individual.getPoint().getSigX()*2 - individual.getPoint().getSigY(); // random y movement.
        Point pointToCheckValue = new Point(xCoor,yCoor); // sigmas doesn't matter

        if  (Function.calculateValue(pointToCheckValue) > individual.getValue())
        {
            individual.getPoint().setX(xCoor);
            individual.getPoint().setY(yCoor);
            individual.setValue(Function.calculateValue(pointToCheckValue)); // move "forward" if new value is bigger and change value.
            individual.setGoodSteps(individual.getGoodSteps()+1);   //increasing good steps if it actually was a good step.
        }
        individual.setAllSteps(individual.getAllSteps()+1); //increasing all steps

        individual.updateFitness();    // updates fitness after amount of steps was added.

        if (individual.getFitness() > 0.2)
            increaseSigmas(individual);
        else if (individual.getFitness() < 0.2)
            decreaseSigmas(individual);


    }

    public void increaseSigmas(Individual individual){

        individual.getPoint().setSigX(individual.getPoint().getSigX()+0.3);
        individual.getPoint().setSigY(individual.getPoint().getSigY()+0.3);

    }

    public void decreaseSigmas(Individual individual){
        individual.getPoint().setSigX(individual.getPoint().getSigX()-0.3);
        individual.getPoint().setSigX(individual.getPoint().getSigX()-0.3);
    }

}
