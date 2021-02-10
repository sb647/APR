package vector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Vector {

    private double[] values;
    private static final double EPSILON = 1E-9;

    public Vector(int size) {
        this.values = new double[size];
    }

    public Vector(double... values) {
        this.values = values;
    }

    public double getValueAt(int index) {
        return values[index];
    }

    public int size() {
        return values.length;
    }


    public double[] getValues() {
        return values;
    }

    public void setValue(int index, double value) {
        this.values[index] = value;
    }

    public List<Double> getListOfValues() {
        List<Double> list = DoubleStream.of(values).boxed().collect(Collectors.toList());
       return list;
    }

    public Vector copy () {
        double[] newValues = new double[this.size()];

        for(int i = 0; i < newValues.length; i++) {
            newValues[i] = this.getValueAt(i);
        }
        return new Vector(newValues);
    }

    public Vector scalarMultiply(double s) {
        double[] result = new double[this.size()];

        for(int i = 0; i < this.size(); i++) {
            result[i] = this.getValueAt(i) * s;
        }

        return new Vector(result);
    }

    public Vector sub(Vector v) {
        double[] result = new double[this.size()];

        for(int i = 0; i < this.size(); i++) {
            result[i] = this.getValueAt(i) - v.getValueAt(i);
        }
        return new Vector(result);
    }

    public Vector add(Vector v) {
        double[] result = new double[this.size()];

        for(int i = 0; i < this.size(); i++) {
            result[i] = this.getValueAt(i) + v.getValueAt(i);
        }
        return new Vector(result);
    }

    public double calculateNorm() {
        double x = this.getValueAt(0);
        double y = this.getValueAt(1);

        return Math.sqrt(x*x + y*y);
    }

    @Override
    public String toString() {
        return  Arrays.toString(values) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;
        Vector vector = (Vector) o;

        for(int i = 0; i < this.size(); i++) {
            if ( Math.abs(this.getValueAt(i) - vector.getValueAt(i)) > EPSILON) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}
