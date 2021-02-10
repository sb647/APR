package mutation;

import representation.Representation;

public interface IMutation {

    Representation mutate(Representation child);
}
