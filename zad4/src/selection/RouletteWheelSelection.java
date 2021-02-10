package selection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RouletteWheelSelection {

    private double[] len;
    private double[] p;
    private double sum = 0;


    public List<double[]> selectParents(List<double[]> population, double[] errors,int best) {
        initArrays(population, errors);
        List<double[]> parents = new ArrayList<>();
        int index1 = selectParent(new Random().nextDouble() * sum );
        int index2;
        while(true) {
            index2 = selectParent(new Random().nextDouble() * sum);
            if(index2 != index1) break;
        }
        parents.add(population.get(index1));
        parents.add(population.get(index2));

        return parents;
    }

    private int selectParent(double rand) {
        for(int i = 0; i < p.length; i++) {
            if(rand < p[i]) {
                return i;
            }
        }
        return 0;
    }

    private void initArrays(List<double[]> population, double[] errors){
        len = new double[population.size()];
        p = new double[population.size()];
        double max = Arrays.stream(errors).max().getAsDouble();

        double previous = 0;
        for(int i = 0; i < len.length; i++) {
            len[i] = max - errors[i];
            sum += len[i];
            previous += len[i];
            p[i] = previous;
        }

    }


}
