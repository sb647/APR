package methods;

import constraints.Constraint;
import goalFunctions.GoalFunction;
import vector.Interval;
import vector.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Box {
    private static double alpha = 1.3;

    public static Vector perform(GoalFunction f, Vector start, Interval explicitConstraint, List<Constraint> implicitConstraints, double e){
        Vector point = start.copy();
        //explicit constraint
        for(int i = 0; i < point.size(); i++) {
            point.setValue(i, correction(point.getValueAt(i), explicitConstraint));
        }

        //implicit
       if(! checkImplicitConstraints(implicitConstraints, point)) return null;

        Vector Xc, Xr;
        int h, h2;
        List<Vector> simplex = generateSimplex(point, explicitConstraint, implicitConstraints);

        do {
            h = findMax(simplex, f);
            h2 = findMax2(simplex, f, h);
            Xc = calculateCentroid(simplex, simplex.get(h));
            Xr = reflection(Xc, simplex.get(h));

            for(int i = 0; i < Xr.size(); i++) {
                Xr.setValue(i, correction(Xr.getValueAt(i), explicitConstraint));
            }

            while(! checkImplicitConstraints(implicitConstraints, Xr)) {
                Xr = Xr.add(Xc).scalarMultiply(0.5);
            }

            if(f.calculate(Xr) > f.calculate(simplex.get(h2))) {
                Xr = Xr.add(Xc).scalarMultiply(0.5);
            }

            simplex.set(h, Xr);

        } while(Math.abs(Xc.calculateNorm() - simplex.get(h).calculateNorm()) > e);

        return Xc;

    }

    public static List<Vector> generateSimplex(Vector x0,  Interval interval, List<Constraint> constraints) {
        Vector xC = x0.copy();
        List<Vector> points = new ArrayList<>();
        for(int i = 0; i < x0.size() * 2; i++) {
           Vector v = new Vector(x0.size());
           for(int j = 0; j < v.size(); j++) {
               double R = new Random().nextDouble();
               v.setValue(j, interval.getStart() + R * (interval.getEnd() - interval.getStart()));
           }
            while(! checkImplicitConstraints(constraints, v)) {
                v = v.add(xC).scalarMultiply(0.5);
            }
            points.add(v);
            xC = getCentroid(points);
        }

        return points;

    }

    private static double correction (double x, Interval i) {
        if (i.check(x) == -1) return i.getStart();
        if(i.check(x) == 1) return i.getEnd();
        else return x;
    }

    private static boolean checkImplicitConstraints(List<Constraint> list, Vector v) {
        for(Constraint l : list) {
            if(! l.check(v)) return false;
        }
        return true;
    }

    public static Vector getCentroid (List<Vector> X) {
        double [] values = new double[X.get(0).size()];

        for(Vector x : X) {

            for (int i = 0; i < x.size(); i++) {
                values[i] += x.getValueAt(i);
            }
        }

        for (int i = 0; i < values.length; i++) {
            values[i] /= X.size();
        }

        return new Vector(values);
    }

    public static int findMax(List<Vector> X, GoalFunction f) {
        int index = 0;
        double max = 0;
        for( int i = 0; i < X.size(); i++) {
            Vector v = X.get(i);
            double value = f.calculate(v);
            if(value > max) {
                max = value;
                index = i;
            }

        }
        return index;
    }

    public static int findMax2(List<Vector> X, GoalFunction f, int h) {
        int h2 = 0;
        double max = 0;
        for( int i = 0; i < X.size(); i++) {
            Vector v = X.get(i);
            double value = f.calculate(v);
            if(value > max && i != h) {
                max = value;
                h2 = i;
            }

        }
        return h2;
    }

    public static Vector calculateCentroid (List<Vector> X, Vector h) {
        double [] values = new double[h.size()];

        for(Vector x : X) { //najlosija tocka
            if(x.equals(h)) continue;
            for (int i = 0; i < x.size(); i++) {
                values[i] += x.getValueAt(i);
            }
        }

        for (int i = 0; i < values.length; i++) {
            values[i] /= (X.size()-1) ;
        }

        return new Vector(values);
    }

    public static Vector reflection (Vector c, Vector h ) {
        Vector x1 = c.scalarMultiply(alpha + 1);
        Vector x2 = h.scalarMultiply(alpha);

        return x1.sub(x2);
    }


}
