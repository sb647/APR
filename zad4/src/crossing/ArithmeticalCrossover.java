package crossing;

import representation.FloatRepresentation;
import representation.Representation;

public class ArithmeticalCrossover implements ICrossover {
    private double lambda;

    public ArithmeticalCrossover(double lambda) {
        this.lambda = lambda;
    }

    public FloatRepresentation cross(Representation parent1, Representation parent2){
        FloatRepresentation p1 = (FloatRepresentation)parent1;
        FloatRepresentation p2 = (FloatRepresentation)parent2;
        double[] result = new double[p1.vector.length];

        for(int i = 0; i < result.length; i++) {
            result[i] = lambda * p1.vector[i] + (1 - lambda)*p2.vector[i];
        }
        return new FloatRepresentation(result);
    }



}
