package pl.put.poznan.sqc.visitors;

import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;
import pl.put.poznan.sqc.interfaces.IVisitor;

public class KeyWordsCounterVisitor implements IVisitor{

    public int numberOfKeyWords;

    public KeyWordsCounterVisitor() {
        numberOfKeyWords = 0;
    }

    public void Visit(Title element){}

    public void Visit(SystemActor element){}

    public void Visit(NormalActor element){}

    public void Visit(ScenarioLine element){
        if(!element.scenarioLine.isEmpty() ){
            if (element.scenarioLine.length()>=8) {
                if (element.scenarioLine.substring(0, 3).equals("IF ") ||
                    element.scenarioLine.substring(0, 5).equals("ELSE ") ||
                    element.scenarioLine.substring(0, 8).equals("FOREACH "))
                    numberOfKeyWords++;
            }
            else if (element.scenarioLine.length()>=5){
                if (element.scenarioLine.substring(0,3).equals("IF ") ||
                    element.scenarioLine.substring(0,5).equals("ELSE "))
                    numberOfKeyWords++;
            }
            else if (element.scenarioLine.length()>=3) {
                if (element.scenarioLine.substring(0, 3).equals("IF "))
                    numberOfKeyWords++;
            }
        }
    }
}
