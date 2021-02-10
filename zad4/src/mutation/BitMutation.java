package mutation;

import representation.BinaryRepresentation;
import representation.Representation;

import java.util.Random;

public class BitMutation implements IMutation{
    private double p;

    public BitMutation(double p) {
        this.p = p;
    }

    public BinaryRepresentation mutate(Representation c) {
        Random r = new Random();
        BinaryRepresentation child =(BinaryRepresentation) c.clone();
        for(int i = 0; i < child.bits.length; i++) {
            if(r.nextDouble() <= p) child.bits[i] = (1 - child.bits[i]);
        }
        return child;
    }
}
