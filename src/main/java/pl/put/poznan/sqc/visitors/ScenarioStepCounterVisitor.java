package pl.put.poznan.sqc.visitors;

import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;
import pl.put.poznan.sqc.interfaces.IVisitor;

/**
 * Counts steps in a scenario.
 */
public class ScenarioStepCounterVisitor implements IVisitor{

    /**
     * Stores the current number of steps words found in a scenario.
     */
    public int numberOfSteps;
    private int actorListIs;

    /**
     * Constructor: sets the starting number of steps words.
     */
    public ScenarioStepCounterVisitor() {
        numberOfSteps = 0;
    }
    /**
     * Increments number of steps if the title is not empty.
     * @param element Title.
     */
    public void Visit(Title element){
        if(element.title != "")
            numberOfSteps++;
    }
    /**
     * Increments number of steps if the System Actor is not empty.
     * @param element SystemActor.
     */
    public void Visit(SystemActor element){
        if(element.systemActor != "")
            numberOfSteps++;
    }
    /**
     * Increments number of steps if the Normal Actor is not empty.
     * @param element NormalActor.
     */
    public void Visit(NormalActor element){
        if(!element.normalActor.isEmpty() ){
            actorListIs++;
            if(actorListIs == 1)
                numberOfSteps++;
        }
    }
    /**
     * Increments number of steps if the Scenario Line is not empty.
     * @param element ScenarioLine.
     */
    public void Visit(ScenarioLine element){
        if(!element.scenarioLine.isEmpty() )
            numberOfSteps++;

    }
}
