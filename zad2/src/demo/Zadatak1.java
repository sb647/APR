package demo;

import goalFunctions.Function3;
import interval.Interval;
import interval.Vector;
import methods.CoordinateAxesSearch;
import methods.GoldenRatio;
import methods.HookeJeeves;
import methods.Simplex;


public class Zadatak1 {
    private static double e = 10e-6;
    private static double h = 1;


    public static void main(String[] args) {
        Function3 f3 = new Function3(1);
        f3.setxMin(new Vector(3));
        f3.setxStart(new Vector(10));
        System.out.println("Golden ratio:");
        Interval interval = GoldenRatio.goldenRatio(f3, h, f3.getxStart().getValueAt(0), true, 10e-6);
        System.out.println(interval);
        System.out.println("Number of calls: " + f3.getNumberOfCalls());
        f3.setNumberOfCalls(0);
        System.out.println();

        System.out.println("Coordinate axes search:");
        f3.setxStart(new Vector(10));
        Vector v1 = CoordinateAxesSearch.search(f3.getxStart(), f3, e);
        System.out.println(v1);
        System.out.println("Number of calls: " + f3.getNumberOfCalls());
        f3.setNumberOfCalls(0);
        System.out.println();

        System.out.println("Hooke-Jeeves:");
        f3.setxStart(new Vector(10));
        Vector v2 = HookeJeeves.hookeJeeves(f3.getxStart(), f3);
        System.out.println(v2);
        System.out.println("Number of calls: " + f3.getNumberOfCalls());
        f3.setNumberOfCalls(0);
        System.out.println();

        System.out.println("Simplex:");
        f3.setxMin(new Vector(3));
        f3.setxStart(new Vector(10));
        Vector v3 = Simplex.simplexMethod(f3.getxStart(), f3, 1);
        System.out.println(v3);
        System.out.println("Number of calls: " + f3.getNumberOfCalls());
        f3.setNumberOfCalls(0);
        System.out.println();


    }
}
