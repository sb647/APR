package crossing;

import representation.BinaryRepresentation;
import representation.Representation;

import java.util.Random;

public class OnePointCrossover implements ICrossover {

    public BinaryRepresentation cross (Representation parent1, Representation parent2) {
        BinaryRepresentation p1 = (BinaryRepresentation) parent1;
        BinaryRepresentation p2 = (BinaryRepresentation) parent2;

        int point = new Random().nextInt(p1.bits.length - 1) + 1;
        BinaryRepresentation child = new BinaryRepresentation(p1);
        for(int i = 0; i < point; i++) {
            child.bits[i] = p1.bits[i];

        } for(int i = point; i < p1.bits.length; i++) {
            child.bits[i] = p2.bits[i];
        }
        return child;
    }
}
