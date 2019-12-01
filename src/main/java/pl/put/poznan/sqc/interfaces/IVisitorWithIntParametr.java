package pl.put.poznan.sqc.interfaces;

import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;

public interface IVisitorWithIntParametr {
    void Visit(Title element, int parametr);
    void Visit(SystemActor element, int parametr);
    void Visit(NormalActor element, int parametr);
    void Visit(ScenarioLine element, int parametr);
}
