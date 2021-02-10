package demo;

import goalFunctions.Function1;
import goalFunctions.Function2;
import methods.GradientDescent;
import methods.Newton;
import vector.Vector;

public class Zadatak2 {

    private static final double e = 10e-6;

    public static void execute() {
        Function1 f1 = new Function1();
        Function2 f2 = new Function2();

        System.out.println("Gradient descent::");
        Vector v1 = GradientDescent.perform(f1, f1.getxStart(), e, true);
        System.out.println(v1);

        Vector v2 = GradientDescent.perform(f2, f2.getxStart(), e, true);
        System.out.println(v2);

        System.out.println("Newton:");
        Vector v1_n = Newton.perform(f1, f1.getxStart(), e, true);
        System.out.println(v1_n);
        System.out.println();
        Vector v2_n = Newton.perform(f2, f2.getxStart(), e, true);
        System.out.println(v2_n);

    }

    public static void main(String[] args) {
        Zadatak2.execute();
    }
}
