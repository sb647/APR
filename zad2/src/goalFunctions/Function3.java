package goalFunctions;

import interval.Vector;

import java.util.List;

public class Function3 extends GoalFunction {

    private int numberOfCalls = 0;
    private Vector xMin;
    private Vector xStart;

    public Function3(int dimension) {

        double[] zeros = new double[dimension];
        double[] min = new double[dimension];
        double n = 1;
        for (int i = 0; i < dimension; i++) {
            zeros[i] = 0;
            min[i] = n++;
        }
        xMin = new Vector(min);
        xStart = new Vector(zeros);
    }

    @Override
    public double calculate(Vector interval) {
        numberOfCalls++;

        List<Double> list = interval.getListOfValues();

        double sum = 0;
        for (int i = 0; i < interval.size(); i++) {
            sum += Math.pow((list.get(i) - i), 2);
        }

        return sum;
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
