package functions;


public class Function3 extends GoalFunction {

    private int numberOfCalls = 0;
    private double[] xMin;
    private double[] xStart;

    public Function3(int dimension) {

        double[] zeros = new double[dimension];
        double[] min = new double[dimension];
        double n = 1;
        for (int i = 0; i < dimension; i++) {
            zeros[i] = 0;
            min[i] = n++;
        }
        xMin = min;
        xStart = zeros;
    }

    @Override
    public double calculate(double[] interval) {
        numberOfCalls++;

        double sum = 0;
        for (int i = 0; i < interval.length; i++) {
            sum += Math.pow((interval[i] - i), 2);
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
    public double[] getxMin() {
        return xMin;
    }

    @Override
    public void setxMin(double[] xMin) {
        this.xMin = xMin;
    }

    @Override
    public double[] getxStart() {
        return xStart;
    }

    @Override
    public void setxStart(double[] xStart) {
        this.xStart = xStart;
    }
}
