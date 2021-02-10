package crossing;

import representation.FloatRepresentation;
import representation.Representation;

public class BlendCrossover implements ICrossover {

    private double alpha;

    public BlendCrossover(double alpha) {
        this.alpha = alpha;
    }

    public FloatRepresentation cross(Representation parent1, Representation parent2) {
        FloatRepresentation p1 = (FloatRepresentation) parent1;
        FloatRepresentation p2 = (FloatRepresentation) parent2;

        double[] child = new double[p1.vector.length];

        for(int i = 0; i < p1.vector.length; i++) {
            double min = p1.vector[i];
            double max = p2.vector[i];

            if(min > max) {
                double temp = min;
                min = max;
                max = temp;
            }
            double I = max - min;
            double a = min - I * alpha;
            double b = max + I * alpha;

            double value =  Math.random() * (b - a) + a;

            if(value < min) value = min;
            if (value > max ) value = max;

            child[i] = value;

        }
        return new FloatRepresentation(child);
    }
}
