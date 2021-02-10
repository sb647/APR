package goalFunctions;

import matrix.Matrix;
import vector.Vector;

public class Function2 extends GoalFunction{

    private int numberOfCalls = 0;
    private Vector xMin;
    private Vector xStart;

    public Function2() {
        this.xMin = new Vector(4,2);
        this.xStart = new Vector(0.1, 0.3);

    }

    @Override
    public double calculate(Vector interval) {
        numberOfCalls++;

        double x1 = interval.getValueAt(0);
        double x2 = interval.getValueAt(1);
        double result = Math.pow((x1 - 4), 2) + 4 * Math.pow((x2 - 2),2);

        return result;

    }

    @Override
    double gradientX(Vector v) {
        double x = v.getValueAt(0);
        return 2 * x - 8;
    }

    @Override
    double gradientY(Vector v) {
        double y = v.getValueAt(1);
        return 8 * y - 16;
    }

    @Override
    public Matrix calculateHessianMatrix(Vector v) {
        double x = v.getValueAt(0);
        double y = v.getValueAt(1);

        double[][] values = {
                {2, 0},
                {0, 8}
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
