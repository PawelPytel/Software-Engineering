package pl.put.poznan.sqc.elements;

import pl.put.poznan.sqc.interfaces.IElement;
import pl.put.poznan.sqc.interfaces.IVisitor;

public class ScenarioLine implements IElement {
    public String scenarioLine;

    public void accept(IVisitor visitor){
        visitor.Visit(this);
    }
}
