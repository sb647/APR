package selection;

import representation.FloatRepresentation;
import representation.Representation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TournamentSelection implements ISelectMethod {
    int N;

    public TournamentSelection (int N) {
        this.N = N;
    }

    @Override
    public List<Representation> selectParents(List<Representation> population) {
        List<Integer> indices = new ArrayList<>();
        List<Representation> result = new ArrayList<>();


        for(int i = 0; i < N; i++) {
            int index;
            while(true){
                index = ThreadLocalRandom.current().nextInt(0, population.size());
                if(! indices.contains(Integer.valueOf(index))) {
                    indices.add(index);
                    result.add(population.get(index));
                    break;
                }
            }
        }
        return result;
    }

}
