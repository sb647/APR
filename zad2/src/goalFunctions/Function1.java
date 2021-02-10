package goalFunctions;

import interval.Interval;
import interval.Vector;

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
