package functions;


public class Function1 extends GoalFunction {
    private int numberOfCalls = 0;
    private double[] xMin;
    private double[] xStart;

    public Function1() {
        this.xMin = new double[]{1,1};
        this.xStart = new double[]{-1.9, 2};

    }

    @Override
    public double calculate(double[] interval) {
        numberOfCalls++;

        double x1 = interval[0];
        double x2 = interval[1];
        double result = 100 * Math.pow((x2 - x1*x1),2) + Math.pow((1-x1), 2);

        return result;
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
