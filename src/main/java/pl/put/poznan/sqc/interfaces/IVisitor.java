package pl.put.poznan.sqc.interfaces;

import pl.put.poznan.sqc.elements.*;

public interface IVisitor {
    void Visit(Title element);
    void Visit(SystemActor element);
    void Visit(NormalActor element);
    void Visit(ScenarioLine element);
}
