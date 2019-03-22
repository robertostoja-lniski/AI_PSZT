package sample;

public class Function {

    //TODO think up how to store a function.

    private static int type;

    public Function(int type) {

        this.type = type;
    }

    public static double calculateValue( Point point ){

        double x = point.getX();
        double y = point.getY();

        if (type == 1)
            return Math.sin(x) + Math.sin(y);
        else if (type == 2)
            return Math.cos(20*x)/(x*x + 1) + Math.sin(10*y) + y/3;
        else if (type == 3)
            return Math.cos(x) + Math.sin(y);
        else if (type == 4)
            return Math.tan(x) + Math.cos(y);
        return 0;

    }


}
