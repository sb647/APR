package alghoritm;

import crossing.ICrossover;
import functions.GoalFunction;
import mutation.IMutation;
import representation.Representation;
import selection.ISelectMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Alghoritm {
    static final double TOLERANCE = 1e-6;

    int vectorSize;
    int lowerBound;
    int upperBound;
    int populationSize;
    int numberOfIterations;
    double delta;
    List<Representation> population;
    GoalFunction function;
    ISelectMethod selector;
    ICrossover crossover;
    IMutation mutation;


    public void execute() {
        int t = 0;
        this.population = generateStartingPopulation();
        double[] mins = evaluate(population);

        double min = Arrays.stream(mins).min().orElseThrow();
        int indexOfMin = Arrays.stream(mins).boxed().collect(Collectors.toList()).indexOf(min);
        double minimum = function.calculate(population.get(indexOfMin).decode());


        while (t < numberOfIterations ) {
            min = Arrays.stream(mins).min().orElseThrow();
            indexOfMin = Arrays.stream(mins).boxed().collect(Collectors.toList()).indexOf(min);
            double fValue = function.calculate(population.get(indexOfMin).decode());

            if (t == 0 || fValue < minimum) {
                minimum = fValue;
                System.out.println(t + ". iteration:");
                double[] v = population.get(indexOfMin).decode();
                System.out.println("Vector : " + arrayToString(v));
                System.out.println("f(v) = " + min);
            }
            t++;
            mins = createNextGeneration(mins);
        }

    }

    public double[] createNextGeneration(double[] mins) {
        List<Representation> sortedParents = sort(selector.selectParents(population));
        Representation kid = crossover.cross(sortedParents.get(0), sortedParents.get(1));
        kid = mutation.mutate(kid);



        for(int i = 0; i < population.size(); i++) {
            if(population.get(i).equals(sortedParents.get(2))) {
                population.remove(i);
                population.add(i, kid);
                mins[i] = function.calculate(kid.decode());
                break;
            }
        }
        return mins;
    }

    private List<Representation> sort(List<Representation> parents) {
        List<Representation> result = new ArrayList<>();
        List<Representation> temp = this.clonePopulation(parents);
        while(! temp.isEmpty()) {
            double[] mins = new double[temp.size()];
            for(int i = 0; i < mins.length; i++) {
                mins[i] = function.calculate(temp.get(i).decode());
            }
            double min = Arrays.stream(mins).min().orElseThrow();
            int index = Arrays.stream(mins).boxed().collect(Collectors.toList()).indexOf(min);
            result.add(temp.get(index));
            temp.remove(index);
        }
        return result;

    }


    public abstract List<Representation> generateStartingPopulation();

    public List<Representation> clonePopulation(List<Representation> startingPopulation) {
        List<Representation> list = new ArrayList<>();

        for(Representation p : startingPopulation) {
            list.add(p.clone());
        }
        return list;
    }

    public double[] evaluate(List<Representation> population){
        double[] mins = new double[population.size()];
        for(int i = 0; i < population.size(); i++) {
            mins[i] = function.calculate(population.get(i).decode());
        }
        return mins;
    }

    public String arrayToString(double[] solution) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < solution.length; i++) {
            sb.append(solution[i]);
            sb.append(" ");
        }
        return sb.toString();

    }


}
