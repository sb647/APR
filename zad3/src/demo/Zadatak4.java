package demo;

import constraints.Constraint;
import constraints.Inequality;
import goalFunctions.Function1;
import goalFunctions.Function2;
import methods.Transformation;
import vector.Vector;

import java.util.ArrayList;
import java.util.List;

public class Zadatak4 {

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

        Vector v1 = Transformation.perform(f1, list, f1.getxStart(), 0.5, 0.001 );
        Vector v2 = Transformation.perform(f2, list, f2.getxStart(), 0.5, 0.001 );

        System.out.println(v1);
        System.out.println(v2);

    }

    public static void main(String[] args) {
        Zadatak4.execute();
    }


}
