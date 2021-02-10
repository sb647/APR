package demo;

import goalFunctions.Function1;
import interval.Vector;
import methods.Simplex;

public class Zadatak4 {
    private static double e = 10E-6;
    private static double h = 0.01;

    public static void main(String[] args) {
        Function1 f = new Function1();
        f.setxStart(new Vector(0.5, 0.5));

        for ( int i = 1; i < 21; i++) {
            System.out.println("Step = "+i);
            Vector v3 = Simplex.simplexMethod(f.getxStart(), f, i);
            System.out.println(v3);
            System.out.println("Number of calls: " + f.getNumberOfCalls());
            f.setNumberOfCalls(0);
            System.out.println();
        }

        f.setxStart(new Vector(20, 20));
        for ( int i = 1; i < 21; i++) {
            System.out.println("Step = "+i);
            Vector v3 = Simplex.simplexMethod(f.getxStart(), f, i);
            System.out.println(v3);
            System.out.println("Number of calls: " + f.getNumberOfCalls());
            f.setNumberOfCalls(0);
            System.out.println();
        }
    }
}
