package sample;

public class Function {
    //TODO think up how to store a function.

    public static double calculateValue(Individual individual,int option){

        if (option == 1)
            return Math.sin(individual.getX()) + Math.sin(individual.getY());
        else if (option == 2)
            return individual.getX()*individual.getX()*individual.getX() - individual.getY()*individual.getY();
        else if (option == 3)
            return Math.cos(individual.getX()) + Math.sin(individual.getY());
        else if (option == 4)
            return Math.tan(individual.getX()) + Math.cos(individual.getY());
        return 0;

    }


}
