package selection;

import representation.Representation;

import java.util.List;

public interface ISelectMethod {

    List<Representation> selectParents(List<Representation> population);

}
