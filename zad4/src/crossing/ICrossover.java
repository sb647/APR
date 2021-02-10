package crossing;

import representation.Representation;

public interface ICrossover {

    Representation cross(Representation parent1, Representation parent2);
}
