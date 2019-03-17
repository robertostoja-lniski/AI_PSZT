package sample;

import java.util.Random;

public class Evolver {

    //TODO OBECNIE NAJGORSZY CHYBA PROBLEM: WYJEZDZAMY POZA WYBRANY PRZEDZIAL NP: [0;10]x[0;10] WYNIKI WYCHODZA SPOKO, ALE W OKOLICACH NP. X = -150, Y=48
    private static final int M = 10;// m z wykladu : co ile iteracji nalezy zmienic sigme.

    // sparametryzowane dane jak na wykladzie
    private static final double C_1 = 0.82;
    private static final double C_2 = 1.2;
    private static final double MUTATION_FI = 0.2;

    private int counter;

    public Evolver(){

        counter = 0;
    }

    public void stepForwardOrDontMove(Individual individual){

        Individual child = individual.generateChild();

        if  ( child.getValue() > individual.getValue()) {

            individual.becomeAChild( child );
            individual.incrementGoodSteps();
        }

        individual.incrementAllSteps();

        if (counter++% M == 0){

            individual.updateFitness();

            double param = individual.getFitness() > MUTATION_FI ? C_2 : C_1;
            individual.assignMutlipliedSigma(param);

        }

    }

}
