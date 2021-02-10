package goalFunctions;

import matrix.Matrix;
import vector.Vector;

public class Function4 extends GoalFunction{

    private int numberOfCalls = 0;
    private Vector xMin;
    private Vector xStart;

    public Function4() {
        this.xMin = new Vector(3, 0);
        this.xStart = new Vector(0, 0);
    }

    @Override
    public double calculate(Vector interval) {
        numberOfCalls++;

        double x1 = interval.getValueAt(0);
        double x2 = interval.getValueAt(1);

        double result = Math.pow((x1 - 3), 2) + Math.pow((x2),2);
        return result;
    }

    @Override
    double gradientX(Vector v) {
        double x = v.getValueAt(0);
        return 2 * x - 6;
    }

    @Override
    double gradientY(Vector v) {
        double y = v.getValueAt(1);
        return 2 * y;
    }

    @Override
    public Matrix calculateHessianMatrix(Vector v) {
        double x = v.getValueAt(0);
        double y = v.getValueAt(1);

        double[][] values = {
                {2, 0},
                {0, 2}
        };

        return new Matrix(values);
    }

    public double calculate(double interval) {
        return calculate(new Vector(interval));
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
