package demo;

import constraints.Constraint;
import constraints.Inequality;
import goalFunctions.Function1;
import goalFunctions.Function2;
import methods.Box;
import vector.Interval;
import vector.Vector;

import java.util.ArrayList;
import java.util.List;

public class Zadatak3 {

    private static final double e = 10e-6;

    public static void execute() {
        Function1 f1 = new Function1();
        Function2 f2 = new Function2();

        Constraint c1 = new Inequality() {
            @Override
            public double calculateLeftSide(Vector v) {
                double x = v.getValueAt(0);
                double y = v.getValueAt(1);
                return y -x;
            }
        };

        Constraint c2 = new Inequality() {
            @Override
            public double calculateLeftSide(Vector v) {
                double x = v.getValueAt(0);
                return 2 - x;
            }
        };
        List<Constraint> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        Interval interval = new Interval(-100, 100);

        Vector v1 = Box.perform(f1, f1.getxStart(), interval, list, e);
        Vector v2 = Box.perform(f2, f2.getxStart(), interval, list, e);

        System.out.println(v1);
        System.out.println(v2);

    }

    public static void main(String[] args) {
        Zadatak3.execute();
    }
}
