package alghoritm;

import crossing.ICrossover;
import functions.GoalFunction;
import mutation.IMutation;
import representation.BinaryRepresentation;
import representation.Representation;
import selection.ISelectMethod;

import java.util.ArrayList;
import java.util.List;


public class BinAlghoritm extends Alghoritm {

    public BinAlghoritm(int vectorSize, int lowerBound, int upperBound, int populationSize, int numberOfIterations, double delta, GoalFunction function, ISelectMethod selector, ICrossover crossover, IMutation mutation) {
        this.vectorSize = vectorSize;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.populationSize = populationSize;
        this.numberOfIterations = numberOfIterations;
        this.delta = delta;
        this.function = function;
        this.selector = selector;
        this.crossover = crossover;
        this.mutation = mutation;
    }


    public List<Representation> generateStartingPopulation() {
        List<Representation> list = new ArrayList<>();

        for(int i = 0; i < populationSize; i++) {
            list.add(new BinaryRepresentation(lowerBound, upperBound, vectorSize, delta));
        }
        return list;
    }



}
