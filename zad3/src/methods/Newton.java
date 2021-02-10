package methods;

import goalFunctions.GoalFunction;
import matrix.Matrix;
import matrix.Operations;
import vector.Interval;
import vector.Vector;

public class Newton {

    private static final int ITERATIONS = 100;

    public static Vector perform(GoalFunction f, Vector start, double e, boolean goldenRatio) {

        // Hx = -G
        Vector dX;
        double previousValue = f.calculate(start);
        Vector point = start.copy();
        Matrix hessian;
        Matrix G;
        int iterations = 0;

        do {
            iterations++;
            hessian = f.calculateHessianMatrix(point);
            Vector v = f.calculateGradient(point);
            double[][] g = {
                    {-v.getValueAt(0)},
                    {-v.getValueAt(1)}};

            G = new Matrix(g);

            Matrix P = hessian.LUPDecomposition();
            Matrix b = Operations.multiply(P, G);
            Matrix mx = solve(hessian.getLMatrix(), b, hessian.getUMatrix());
            dX = new Vector(mx.getElement(0,0), mx.getElement(1,0));

            if(goldenRatio) {
                final Vector vector = point.copy();
                final Vector d = dX.copy();
                GoalFunction f2 = new GoalFunction() {
                    @Override
                    public double calculate(double l) {
                        return f.calculate(vector.add(d.scalarMultiply(l)));
                    }
                };
                Interval i = GoldenRatio.goldenRatio(f2,1,point.getValueAt(0), false, e);
                double lambda = (i.getStart() + i.getEnd())/2;
                dX = dX.scalarMultiply(lambda);
            }

            point = point.add(dX);

            if(f.calculate(point) != previousValue) {
                previousValue = f.calculate(point);
                iterations = 0;
            }

            if(iterations >= ITERATIONS) {
                System.out.println("Divergence ");
                return null;
            }

        }while(dX.calculateNorm() > e);
        return point;
    }

    private static Matrix solve(Matrix L, Matrix b, Matrix U) {
        Matrix y = L.forwardSubstitution(b);
        Matrix x = U.backwardSubstitution(y);
        return x;
    }
}
