package goalFunctions;

import matrix.Matrix;
import vector.Vector;

public class Function1 extends GoalFunction {
    private int numberOfCalls = 0;
    private Vector xMin;
    private Vector xStart;

    public Function1() {
        this.xMin = new Vector(1,1);
        this.xStart = new Vector(-1.9, 2);
    }

    @Override
    public double calculate(Vector interval) {
        numberOfCalls++;

        double x1 = interval.getValueAt(0);
        double x2 = interval.getValueAt(1);
        double result = 100 * Math.pow((x2 - x1*x1),2) + Math.pow((1-x1), 2);

        return result;
    }
    public double calculate(double interval) {
        return calculate(new Vector(interval));
    }

    @Override
    double gradientX(Vector v) {
        double x = v.getValueAt(0);
        double y = v.getValueAt(1);

        return (-400 * x * (-Math.pow(x, 2) + y) + 2 * x - 2);
    }

    @Override
    double gradientY(Vector v) {
        double x = v.getValueAt(0);
        double y = v.getValueAt(1);

        return -200 * Math.pow(x, 2) + 200 * y;
    }

    @Override
    public Matrix calculateHessianMatrix(Vector v) {
        hessianCalls++;
        double x = v.getValueAt(0);
        double y = v.getValueAt(1);

        double[][] values = {
                { 1200*x*x - 400*y + 2, -400* x + 2 },
                { -400 * x, 200 }
        };

        return new Matrix(values);
    }

    @Override
    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    @Override
    public void setNumberOfCalls(int numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }

    @Override
    public Vector getxMin() {
        return xMin;
    }

    @Override
    public void setxMin(Vector xMin) {
        this.xMin = xMin;
    }

    @Override
    public Vector getxStart() {
        return xStart;
    }

    @Override
    public void setxStart(Vector xStart) {
        this.xStart = xStart;
    }
}
