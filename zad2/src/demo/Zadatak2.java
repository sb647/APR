package demo;

import goalFunctions.*;
import interval.Vector;
import methods.CoordinateAxesSearch;
import methods.HookeJeeves;
import methods.Simplex;

public class Zadatak2 {
    private static double e = 10E-6;
    private static double h = 0.01;

    public static void main(String[] args) {

        Function1 f1 = new Function1();
        Function2 f2 = new Function2();
        Function3 f3 = new Function3(5);
        Function4 f4 = new Function4();

        System.out.println("F1");
        print(f1);

        System.out.println("F2");
        print(f2);

        System.out.println("F3");
        print(f3);

        System.out.println("F4");
        print(f4);


    }

    private static void print(GoalFunction f) {

        System.out.println("Coordinate Axes Search:");
        Vector v1 = CoordinateAxesSearch.search(f.getxStart(), f, e);
        System.out.println(v1);
        System.out.println("Number of calls: " + f.getNumberOfCalls());
        f.setNumberOfCalls(0);
        System.out.println();

        System.out.println("Hooke-Jeeves:");
        Vector v2 = HookeJeeves.hookeJeeves(f.getxStart(), f);
        System.out.println(v2);
        System.out.println("Number of calls: " + f.getNumberOfCalls());
        f.setNumberOfCalls(0);
        System.out.println();


        System.out.println("Simplex:");
        Vector v3 = Simplex.simplexMethod(f.getxStart(), f, 1);
        System.out.println(v3);
        System.out.println("Number of calls: " + f.getNumberOfCalls());
        f.setNumberOfCalls(0);
        System.out.println();


    }


}
