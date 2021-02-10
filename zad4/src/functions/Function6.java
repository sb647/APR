package functions;


public class Function6 extends GoalFunction{

    private int numberOfCalls = 0;
    private double[] xMin;
    private double[] xStart;

    public Function6(int dimension) {
        double[] zeros = new double[dimension];

        for (int i = 0; i < dimension; i++) {
            zeros[i] = 0;
        }
        this.xMin = zeros;

    }

    @Override
    public double calculate(double[] interval) {
        numberOfCalls++;

        double sum = 0;
        for (int i = 0; i < interval.length; i++) {
            sum += Math.pow(interval[i], 2);
        }

        double numerator = Math.pow(Math.sin(Math.sqrt(sum)), 2) - 0.5;
        double denominator = Math.pow((1 + 0.001 * sum), 2);

        return 0.5 + numerator / denominator;
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
