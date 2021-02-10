package constraints;

import vector.Vector;

public abstract class Equality implements Constraint {


    public Equality() {
    }

    @Override
    public abstract double calculateLeftSide(Vector v);

    @Override
    public boolean check(Vector v) {
        return calculateLeftSide(v) == 0;
    }

}
