package pl.put.poznan.sqc.visitors;

import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;
import pl.put.poznan.sqc.interfaces.IVisitor;

/**
 * Counts key words in a scenario.
 */
public class KeyWordsCounterVisitor implements IVisitor{
    /**
     * Stores the current number of key words found in a scenario.
     */
    public int numberOfKeyWords;

    /**
     * Constructor: sets the starting number of key words.
     */
    public KeyWordsCounterVisitor() {
        numberOfKeyWords = 0;
    }

    /**
     * An empty method, implements IVisitor.
     * @param element --
     */
    public void Visit(Title element){}
    /**
     * An empty method, implements IVisitor.
     * @param element --
     */
    public void Visit(SystemActor element){}
    /**
     * An empty method, implements IVisitor.
     * @param element --
     */
    public void Visit(NormalActor element){}

    /**
     * Checks if the scenario line begins with a key word.
     * @param element Scenario line.
     */
    public void Visit(ScenarioLine element){
        if(!element.scenarioLine.isEmpty() ){
            if (element.scenarioLine.length()>=3) {
                if (element.scenarioLine.substring(0, 3).equals("IF "))
                                numberOfKeyWords++;
                else if (element.scenarioLine.length()>=5){
                    if (element.scenarioLine.substring(0,5).equals("ELSE "))
                        numberOfKeyWords++;
                    else if (element.scenarioLine.length()>=8) {
                        if ( element.scenarioLine.substring(0, 8).equals("FOREACH "))
                            numberOfKeyWords++;
                    }
                }
            }
        }
    }   
}
