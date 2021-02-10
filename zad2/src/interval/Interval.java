package interval;

import java.util.Arrays;
import java.util.List;

public class Interval {
    private double start;
    private double end;

    public Interval(double start, double end) {
        this.start = start;
        this.end = end;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Interval{" + start +
                ", " + end +
                '}';
    }
}
