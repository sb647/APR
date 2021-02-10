package functions;

public class Function7 extends GoalFunction{

    private int numberOfCalls = 0;
    private double[] xMin;
    private double[] xStart;

    public Function7(int dimension) {
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

        double t = 1 +  Math.pow(Math.sin(50 *Math.pow(sum, 0.1)), 2);
        return Math.pow(sum, 0.25) * t;


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
