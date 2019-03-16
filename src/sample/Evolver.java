package sample;

import java.util.Random;

public class Evolver {

    private Random random;

    public Evolver(){

        random = new Random();
    }

    public void StepForwardOrDontMove(Individual individual){

        double xCoor = random.nextDouble()*individual.getPoint().getSigX()*2 - individual.getPoint().getSigX(); //random x movement.
        double yCoor = random.nextDouble()*individual.getPoint().getSigX()*2 - individual.getPoint().getSigY(); // random y movement.
        Point pointToCheckValue = new Point(xCoor,yCoor,0.5,0.5); // sigmas doesn't matter

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
            increaseSigmas();
        else if (individual.getFitness() < 0.2)
            decreaseSigmas();


    }

    public void increaseSigmas(){
     //TODO
    }

    public void decreaseSigmas(){
        //TODO
    }

}
