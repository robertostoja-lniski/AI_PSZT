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

        // najpierw tworzy sie dziecko
        // potem pobiera wartosc
        // jestli jest lepsza to staje sie dzieckiem

        Individual child = individual.generateChild();

        if  ( child.getValue() > individual.getValue()) {

            // funkcja ustawia nowe wartosci dla individuala
            individual.becomeAChild( child );
            // chyba lepiej dac increment - wieksza czytelnosc i miej getow
            // to i szybciej bedzie
            individual.incrementGoodSteps();   //increasing good steps if it actually was a good step.
        }

        individual.incrementAllSteps(); //increasing all steps


        if (counter++% M == 0){

            individual.updateFitness();
            // updates fitness after amount of steps was added.

            // prosto i smacznie :)

            double param = individual.getFitness() > MUTATION_FI ? C_2 : C_1;
            individual.assignMutlipliedSigma(param);

        }

    }

    /*
        nazwa increse i decrese moze byc mylaca
        mozna przeprowadzic taka mutacje ze bedziemy dla malych fitness
        bedziemy sigme zwieksza

        metody byly bardzo podobne, mysle ze mozna je skleic w jedna
        Co wiecej, zmiana sigmy to zmiana wlasciwosci Individuala
        Evolver nie powinien jawnie zmieniac innej klasy
        lepiej jak powie
        "Ej individual, powiem Tobie jak masz pomnozyc, a Ty sobie pomnoz sigme"

    public void multiplyIndividualSigma(Individual individual , double C){

        Point individualPoint = individual.getPoint();
        individualPoint.setSigX(individual.getPoint().getSigX()*C);
        individualPoint.setSigY(individual.getPoint().getSigY()*C);

    }

    */



}
