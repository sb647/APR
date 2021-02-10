package goalFunctions;

import interval.Interval;
import interval.Vector;

import java.util.List;

public class Function6 extends GoalFunction{

    private int numberOfCalls = 0;
    private Vector xMin;
    private Vector xStart;

    public Function6(int dimension) {
        double[] zeros = new double[dimension];

        for (int i = 0; i < dimension; i++) {
            zeros[i] = 0;
        }
        this.xMin = new Vector(zeros);

    }

    @Override
    public double calculate(Vector interval) {
        numberOfCalls++;

        List<Double> list = interval.getListOfValues();
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += Math.pow(list.get(i), 2);
        }

        double numerator = Math.pow(Math.sin(Math.sqrt(sum)), 2) - 0.5;
        double denominator = Math.pow((1 + 0.001 * sum), 2);

        return 0.5 + numerator / denominator;
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
