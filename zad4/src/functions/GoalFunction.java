package functions;


public abstract class GoalFunction {
    private int numberOfCalls = 0;
    private double[] xMin;
    private double[] xStart;

    public double calculate(double[] interval) {
        return 0.0;
    }

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    public void setNumberOfCalls(int numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }

    public double[] getxMin() {
        return xMin;
    }

    public void setxMin(double[] xMin) {
        this.xMin = xMin;
    }

    public double[] getxStart() {
        return xStart;
    }

    public void setxStart(double[] xStart) {
        this.xStart = xStart;
    }
}
