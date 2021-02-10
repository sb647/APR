package methods;

import constraints.Constraint;
import constraints.Equality;
import constraints.Inequality;
import goalFunctions.GoalFunction;
import goalFunctions.TransformedFunction;
import vector.Vector;

import java.util.ArrayList;
import java.util.List;

public class Transformation {

    public static Vector perform(GoalFunction f, List<Constraint> constraints, Vector start, double t, double e) {
        TransformedFunction G = new TransformedFunction(f, constraints, t);
        Vector point = start.copy();
        if(! checkImplicitConstraints(constraints, start) ) {
            point = findNewPoint(f,constraints, start, e);
        }

        Vector previous = Simplex.simplexMethod(point, G, 1);

        while(true) {

            G.setT(10 * G.getT());
            point = Simplex.simplexMethod(point, G, 1);
            if (Math.abs(point.calculateNorm() - previous.calculateNorm()) <= e ) break;
            else previous = point.copy();

        }
        return point;

    }

    private static Vector findNewPoint(GoalFunction f, List<Constraint> list, Vector start,  double e) {
        List<Constraint> cons = new ArrayList<>();
        for(Constraint l : list) {
            if(! l.check(start) && l instanceof Inequality) cons.add(l);
        }

        GoalFunction tf = new GoalFunction() {
            @Override
            public double calculate(Vector v) {
                double result = f.calculate(v);

                for(Constraint i : cons) {
                    if(! i.check(v)) {
                        result -=  i.calculateLeftSide(v);
                    }
                }
                return result;
            }
        };
        Vector point = start.copy();
        double previous = 0;

        while(true) {

            point = Simplex.simplexMethod(point, tf, 1);
            if (Math.abs(point.calculateNorm() - previous) <= e ) break;
            else previous = point.copy().calculateNorm();

        }
        return point;

    }

    private static boolean checkImplicitConstraints(List<Constraint> list, Vector v) {
        for(Constraint l : list) {
            if(! l.check(v)) return false;
        }
        return true;
    }


}
