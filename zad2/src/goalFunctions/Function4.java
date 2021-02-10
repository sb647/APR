package goalFunctions;

import interval.Interval;
import interval.Vector;

public class Function4 extends GoalFunction{

    private int numberOfCalls = 0;
    private Vector xMin;
    private Vector xStart;

    public Function4() {
        this.xMin = new Vector(0,0);
        this.xStart = new Vector(5.1, 1.1);
    }

    @Override
    public double calculate(Vector interval) {
        numberOfCalls++;

        double x1 = interval.getValueAt(0);
        double x2 = interval.getValueAt(1);

        double result = Math.abs((x1 - x2) * (x1 + x2)) +
                Math.sqrt(x1 * x1 + x2 * x2);
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
