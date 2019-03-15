package sample;

import java.util.Random;

public class Evolver {

    private Random random;

    public Evolver(){

        random = new Random();
    }

    public Point crossOver(Point parentA, Point parentB){

        //TODO interpolacja dodalem chwilowo takie cos, mozna to zmienic jkbc.

        /*
            Next gaussian is x ~ N(0,1)
            zmienilem nazwy na takie jak na wykladzie
            moze bedzie sie lepiej czytalo, jesli sie nie zgadzasz - odkomentuj.

            double strenghOfParentA = random.nextGaussian();  // pseudo-interpolacja: losowa waga dla rodzica A od 0-1 * jego wspolrzedne + (1-strengthOfParentA)* wspolrzedne rodzica B.
            double childX = strenghOfParentA*parentA.getX() + (1-strenghOfParentA)*parentB.getX();
            double childY = strenghOfParentA*parentA.getY() + (1-strenghOfParentA)*parentB.getY();
            double childSigX = strenghOfParentA*parentA.getSigX() + (1-strenghOfParentA)*parentB.getSigX();
            double childSigY = strenghOfParentA*parentA.getSigY() + (1-strenghOfParentA)*parentB.getSigY();

           return new Point(childX,childY,childSigX,childSigY);

         */


        double a = random.nextDouble();
        double b = 1 - a;

        double childX = a * parentA.getX() + b * parentB.getX();
        double childY = a * parentA.getY() + b * parentB.getY();

        double childSigX = a * parentA.getSigX() + b * parentB.getSigX();
        double childSigY = a * parentA.getSigY() + b * parentB.getSigY();

        return new Point( childX , childY , childSigX , childSigY );


    }

    public Point mutation(Point mutationPoint){

        //TODO mutation with sigma. tez cos swojego chwilowego (raczej) zeby moc dzialac na reprodukcji i selekcji
        /*

        Wywalilem stad warunek if( random.netDouble() < Main.Mutation_rate) (...)
        warunek powinien byc sprawdzany przed wejsciem do metody
        oszczednosc czasu dzialania programu i zwiekszenie czytelnosci

        jesli warunek bylby tutaj to wynikaloby ze
        "Mutacja wykonuje sie zawsze, czasami dajac zaden efekt"
        zamiast
        "Mutacja wynokuje sie z danych p-stwem"

        Zmienilem na mutacje na taka jaka jest na wykladzie ( interpolacja )
        Nie trzeba dodawac zadnych bibliotek matemacznych
        Rozklad Gaussa i Exp sa w bibliotece standardowej Math
        Zmienna typu static final int DIMENSION okresla obszar przeszukiwan - tutaj dim = 2
         */

        // analogicznie jak we wzorze z 3 prezentacji str11

        double tA = 1 / ( Math.sqrt( 2 * Main.DIMENSION ) );
        double tB = 1 / ( Math.sqrt( 2 * Math.sqrt( Main.DIMENSION) ) );

        // dodalem NiX i NiY, aby zachowac spojnosc z wykladem
        // chodzi o to ze mutacja SigmaX jest zalezna od tego samego
        // rozkladu Ni, co mutacja X - jesli napisalem niejasno
        // to mysle ze na prezentacji jest to w miare czytelne :)

        double NX = random.nextGaussian();
        double NiX = random.nextGaussian();
        double NY = random.nextGaussian();
        double NiY = random.nextGaussian();


        double mutatedSigmaX = mutationPoint.getSigX() * Math.exp( tA * NX + tB * NiX);
        double mutatedSigmaY = mutationPoint.getSigY() * Math.exp( tA * NY + tB * NiY );

        double mutatedX = mutationPoint.getX() + mutatedSigmaX * NiX;
        double mutatedY = mutationPoint.getY() + mutatedSigmaY * NiY;

        return new Point( mutatedX, mutatedY, mutatedSigmaX, mutatedSigmaX );

        /*

        Ponizej znajduje sie stary kod
        ( na wszelki wypadek go zostawilem )

        double randomMovementInSigmeXBound = random.nextDouble()*mutationPoint.getSigX()*2 - mutationPoint.getSigX();  // losowa liczba rzeczywista w przedziale od -sigmaX do sigmaX
        double randomMovementInSigmaYBound = random.nextDouble()*mutationPoint.getSigY()*2 - mutationPoint.getSigY();  // losowa liczba rzeczywista w przedziale od -sigmaY do sigmaY

        mutationPoint.setX(mutationPoint.getX() + randomMovementInSigmeXBound);
        mutationPoint.setY(mutationPoint.getY() + randomMovementInSigmaYBound);
            //przesuwam wspolrzedne x i y o losowy wektor wygenerowany z przedzialu sigm.

        */

    }
}
