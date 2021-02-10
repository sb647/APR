package vector;

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

    public int check(double x) {
        if (x >= start && x <= end) return 0;
        if (x < start) return -1;
        else return 1;
    }

    @Override
    public String toString() {
        return "Interval{" + start +
                ", " + end +
                '}';
    }
}
