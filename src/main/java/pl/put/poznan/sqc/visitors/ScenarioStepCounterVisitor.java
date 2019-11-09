package pl.put.poznan.sqc.visitors;

import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;
import pl.put.poznan.sqc.interfaces.IVisitor;

public class ScenarioStepCounterVisitor implements IVisitor{

    public int numberOfSteps;

    public ScenarioStepCounterVisitor() {
        numberOfSteps = 0;
    }

    public void Visit(Title element){
        if(element.title != "")
            numberOfSteps++;
    }

    public void Visit(SystemActor element){
        if(element.systemActor != "")
            numberOfSteps++;
    }
    public void Visit(NormalActor element){
        if(!element.normalActor.isEmpty() )
            numberOfSteps++;
    }
    public void Visit(ScenarioLine element){
        if(!element.scenarioLine.isEmpty() )
            numberOfSteps++;

    }
}
