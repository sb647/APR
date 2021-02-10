package alghoritm;

import crossing.ICrossover;
import functions.GoalFunction;
import mutation.IMutation;
import representation.FloatRepresentation;
import representation.Representation;
import selection.ISelectMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EliminationAlghoritm extends Alghoritm {

    public EliminationAlghoritm(int vectorSize, int lowerBound, int upperBound, int populationSize, int numberOfIterations, GoalFunction function, ISelectMethod selector, ICrossover crossover, IMutation mutation) {
        this.vectorSize = vectorSize;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.populationSize = populationSize;
        this.numberOfIterations = numberOfIterations;
        this.function = function;
        this.selector = selector;
        this.crossover = crossover;
        this.mutation = mutation;
    }

    public List<Representation> generateStartingPopulation() {
        List<Representation> list = new ArrayList<>();
        Random r = new Random();

        for(int i = 0; i < populationSize; i++) {
            double[] vector = new double[vectorSize];
            double random;
            for(int j = 0; j < vectorSize; j++) {
                random = lowerBound + (upperBound - lowerBound) * r.nextDouble();
                vector[j] = random;
            }
            list.add(new FloatRepresentation(vector));
        }
        return list;
    }


}
