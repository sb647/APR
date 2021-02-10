package demo;

import constraints.Constraint;
import constraints.Equality;
import constraints.Inequality;
import goalFunctions.Function4;
import methods.Transformation;
import vector.Vector;
import java.util.ArrayList;
import java.util.List;

public class Zadatak5 {
    private static final double e = 10e-6;

    public static void execute() {
        Function4 f4 = new Function4();

        Constraint c1 = new Inequality() {
            @Override
            public double calculateLeftSide(Vector v) {
                double x = v.getValueAt(0);
                double y = v.getValueAt(1);
                return (3 - x - y);
            }
        };

        Constraint c2 = new Inequality() {
            @Override
            public double calculateLeftSide(Vector v) {
                double x = v.getValueAt(0);
                double y = v.getValueAt(1);
                return ((double) 3 + 1.5 * x - y);
            }
        };

        Constraint c3 = new Equality() {
            @Override
            public double calculateLeftSide(Vector v) {
                double y = v.getValueAt(1);
                return y - 1;
            }
        };

        List<Constraint> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        //1.5, 1
        Vector v1 = Transformation.perform(f4, list, new Vector(5,5), 0.5, e );
        System.out.println(v1);

    }

    public static void main(String[] args) {
        Zadatak5.execute();
    }
}
