package constraints;

import vector.Vector;

public abstract class Inequality implements Constraint {


    public Inequality() {
    }

    @Override
    public abstract double calculateLeftSide(Vector v);

    @Override
    public boolean check(Vector v) {
        return calculateLeftSide(v) >= 0;
    }
}
