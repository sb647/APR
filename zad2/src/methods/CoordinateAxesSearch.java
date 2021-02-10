package methods;

import goalFunctions.GoalFunction;
import interval.Interval;
import interval.Vector;

public class CoordinateAxesSearch {

    private double e = 1E-6;



    public static Vector search(Vector x0, GoalFunction f, double e) {
        int n = x0.size();
        Vector x = x0.copy();
        Vector xs;
        do {
            xs = x.copy();
            for(int i = 0; i < n; i++) {
                final Vector xs2 = x.copy();
                final int i2 = i;

                GoalFunction f2 = new GoalFunction() {
                    @Override
                    public double calculate(double l) {
                        Vector v = xs2.copy();
                        v.setValue(i2, v.getValueAt(i2) + l);
                       return f.calculate(v);
                    }
                };
                Interval interval = GoldenRatio.goldenRatio(f2,0.01, x.getValueAt(i),false, e);
                double lambda = (interval.getStart() + interval.getEnd() )/ 2;
                x.setValue(i, x.getValueAt(i) + lambda);

            }

        } while(norm(x, xs) > e);
        return x;
    }



    private static double norm(Vector v1, Vector v2) {
        double sum = 0;

        for(int i = 0; i < v1.size(); i++) {
            sum += Math.pow((v1.getValueAt(i) - v2.getValueAt(i)), 2);
        }
        return Math.sqrt(sum);
    }


}
