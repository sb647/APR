package crossing;

import representation.FloatRepresentation;
import representation.Representation;

public class MeanCrossover implements ICrossover {

    private double min;
    private double max;

    public MeanCrossover( double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public FloatRepresentation cross(Representation parent1, Representation parent2) {
      FloatRepresentation p1 = (FloatRepresentation) parent1;
      FloatRepresentation p2 = (FloatRepresentation) parent2;

        double[] child = new double[p1.vector.length];

        for(int i = 0; i < p1.vector.length; i++) {
            double gene1 = p1.vector[i];
            double gene2 = p2.vector[i];

            double mean = (gene1 + gene2 )/ 2;
            if(mean < min) mean = min;
            if(mean > max) mean = max;

            child[i] = mean;
        }
        return new FloatRepresentation(child);
    }
}
