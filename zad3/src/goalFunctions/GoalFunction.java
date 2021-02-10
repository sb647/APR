package goalFunctions;

import matrix.Matrix;
import vector.Vector;

public abstract class GoalFunction {
    private int numberOfCalls = 0;
    private Vector xMin;
    private Vector xStart;
    int hessianCalls;
    int gradCalls;

    public double calculate(Vector interval) {
        return 0.0;
    }

    public double calculate(double interval) {
        return calculate(new Vector(interval));
    }

    public Vector calculateGradient(Vector interval) {
        gradCalls++;
        double x = gradientX(interval);
        double y = gradientY(interval);

        return new Vector(x,y);
    }

    double gradientX(Vector v) {return 0.0;}

    double gradientY(Vector v) {return 0.0;}

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    public void setNumberOfCalls(int numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }

    public Vector getxMin() {
        return xMin;
    }

    public void setxMin(Vector xMin) {
        this.xMin = xMin;
    }

    public Vector getxStart() {
        return xStart;
    }

    public void setxStart(Vector xStart) {
        this.xStart = xStart;
    }

    public Matrix calculateHessianMatrix (Vector v) {
        return new Matrix(0,0);
    }

    public int getHessianCalls() {
        return hessianCalls;
    }

    public int getGradCalls() {
        return gradCalls;
    }
}
