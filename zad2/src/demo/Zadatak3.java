package demo;

import goalFunctions.Function4;
import interval.Vector;
import methods.HookeJeeves;
import methods.Simplex;

public class Zadatak3 {
    private static double e = 10E-6;
    private static double h = 0.01;

    public static void main(String[] args) {
        Function4 f = new Function4();
        f.setxStart(new Vector(5,5));

        Vector v2 = HookeJeeves.hookeJeeves(f.getxStart(), f);
        System.out.println(v2);
        System.out.println("Number of calls: " + f.getNumberOfCalls());
        f.setNumberOfCalls(0);
        System.out.println();

        Vector v3 = Simplex.simplexMethod(f.getxStart(), f, 1);
        System.out.println(v3);
        System.out.println("Number of calls: " + f.getNumberOfCalls());
        f.setNumberOfCalls(0);
        System.out.println();


    }
}
