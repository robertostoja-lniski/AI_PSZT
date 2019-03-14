package sample;

import java.util.Random;

public class Evolver {

    private Random random;

    public Evolver(){

        random = new Random();
    }

    public Point crossOver(Point parentA, Point parentB){

        //TODO interpolacja dodalem chwilowo takie cos, mozna to zmienic jkbc.

        double strenghOfParentA = random.nextDouble();  // pseudo-interpolacja: losowa waga dla rodzica A od 0-1 * jego wspolrzedne + (1-strengthOfParentA)* wspolrzedne rodzica B.
        double childX = strenghOfParentA*parentA.getX() + (1-strenghOfParentA)*parentB.getX();
        double childY = strenghOfParentA*parentA.getY() + (1-strenghOfParentA)*parentB.getY();
        double childSigX = strenghOfParentA*parentA.getSigX() + (1-strenghOfParentA)*parentB.getSigX();
        double childSigY = strenghOfParentA*parentA.getSigY() + (1-strenghOfParentA)*parentB.getSigY();

        return new Point(childX,childY,childSigX,childSigY);
    }

    public Point mutation(Point mutationPoint){

        //TODO mutation with sigma. tez cos swojego chwilowego (raczej) zeby moc dzialac na reprodukcji i selekcji
        if (random.nextDouble() < Main.MUTATION_RATE){  // mutacja z szansa zawarta w mutation_rate

            double randomMovementInSigmeXBound = random.nextDouble()*mutationPoint.getSigX()*2 - mutationPoint.getSigX();  // losowa liczba rzeczywista w przedziale od -sigmaX do sigmaX
            double randomMovementInSigmaYBound = random.nextDouble()*mutationPoint.getSigY()*2 - mutationPoint.getSigY();  // losowa liczba rzeczywista w przedziale od -sigmaY do sigmaY

            mutationPoint.setX(mutationPoint.getX() + randomMovementInSigmeXBound);
            mutationPoint.setY(mutationPoint.getY() + randomMovementInSigmaYBound);
            //przesuwam wspolrzedne x i y o losowy wektor wygenerowany z przedzialu sigm.

        }
        return mutationPoint;
    }
}
