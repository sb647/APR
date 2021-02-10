package mutation;


import representation.FloatRepresentation;
import representation.Representation;

import java.util.Random;

public class Mutation implements IMutation {

    private double p;
    private double sigma;
    private double min;
    private double max;

    public Mutation(double p, double sigma, double min, double max) {
        this.p = p;
        this.sigma = sigma;
        this.min = min;
        this.max = max;
    }

    @Override
    public FloatRepresentation mutate(Representation child) {
       FloatRepresentation mutant = (FloatRepresentation)child.clone();

       for(int i = 0; i < mutant.vector.length; i ++) {
           if(Math.random() < p) {
               double value = mutant.vector[i] + new Random().nextGaussian() * sigma;
               if(value < min) value = min;
               if(value > max) value = max;

               mutant.vector[i] = value;
           }
       }
       return mutant;
    }
}
