package constraints;

import vector.Vector;

public interface Constraint {

    double calculateLeftSide(Vector V);

    boolean check (Vector v);

}
