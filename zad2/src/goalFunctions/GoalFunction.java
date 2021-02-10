package goalFunctions;

import interval.Interval;
import interval.Vector;

public abstract class GoalFunction {
    private int numberOfCalls = 0;
    private Vector xMin;
    private Vector xStart;

    public double calculate(Vector interval) {
        return 0.0;
    }

    public double calculate(double interval) {
        return calculate(new Vector(interval));
    }

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
}
