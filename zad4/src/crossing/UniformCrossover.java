package crossing;

import representation.BinaryRepresentation;
import representation.Representation;

public class UniformCrossover implements ICrossover {

    public BinaryRepresentation cross(Representation parent1, Representation parent2){
        BinaryRepresentation p1 = (BinaryRepresentation)parent1;
        BinaryRepresentation p2 = (BinaryRepresentation)parent2;
        BinaryRepresentation child = p2.clone();

        for(int i = 0; i < child.bits.length; i++) {
            if(child.bits[i] == p1.bits[i]) continue;
            else child.bits[i] = 0;
        }

        return child;
    }


}
