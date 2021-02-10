package methods;

import goalFunctions.GoalFunction;
import vector.Interval;
import vector.Vector;

public class GradientDescent {

    private static final int ITERATIONS = 100;

    public static Vector perform(GoalFunction f, Vector start, double e, boolean goldenRation) {

        Vector point = start.copy();
        double lambda;
        Vector grad;
        double previous = f.calculate(start);
        int iterations = 0;

        do {
            iterations++;
            grad = f.calculateGradient(point);

            if(goldenRation) {

                final Vector v = point.copy();
                final Vector g = grad.copy();
                // f(x, a) = f (x + grad * a)
                GoalFunction f2 = new GoalFunction() {
                    @Override
                    public double calculate(double l) {
                        return f.calculate(v.sub(g.scalarMultiply(l)));
                    }
                };

                Interval i = GoldenRatio.goldenRatio(f2,1, point.getValueAt(0), false, e);
                lambda = i.getStart();
                grad = grad.scalarMultiply(lambda);
            }

            point = point.sub(grad);

            if(f.calculate(point) != previous) {
                previous = f.calculate(point);
                iterations = 0;
            }

            if(iterations >= ITERATIONS) {
                System.out.println("Divergence ");
                return null;
            }

        } while(grad.calculateNorm() > e);

        return point;

    }


}
