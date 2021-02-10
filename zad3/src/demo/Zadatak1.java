package demo;

import goalFunctions.Function3;
import methods.GradientDescent;
import vector.Vector;

public class Zadatak1 {

    private static final double e = 10e-6;

    public static void execute() {
        Function3 f3 = new Function3();
        Vector v1 = GradientDescent.perform(f3, f3.getxStart(), e, true);
        System.out.println(v1);
        System.out.println();

        f3= new Function3();
        Vector v2 = GradientDescent.perform(f3, f3.getxStart(), e, false);
        System.out.println(v2);


    }

    public static void main(String[] args) {
        Zadatak1.execute();
    }
}
