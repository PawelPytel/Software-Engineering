package pl.put.poznan.sqc.visitors;

import pl.put.poznan.sqc.Helpers.WhiteSpace;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;
import pl.put.poznan.sqc.interfaces.IVisitor;
import pl.put.poznan.sqc.models.ScenarioJSONModel;

import java.util.ArrayList;

/**
 * Adds steps in a scenario.
 */
public class StepListVisitor  implements IVisitor {
    /**
     * Stores steps.
     */
    private ArrayList<Integer> listStep;
    public ScenarioJSONModel mainJSON;

    /**
     * Constructor.
     */
    public StepListVisitor() {
        listStep = new ArrayList<Integer>();
        listStep.add(1);
        mainJSON= new ScenarioJSONModel();
    }

    /**
     * Get Title.
     * @param element Title.
     */
    public void Visit(Title element){
        if(element.getTitle() != "")
            mainJSON.Title = element.getTitle();
    }

    /**
     * Get SystemActor.
     * @param element SystemActor.
     */
    public void Visit(SystemActor element){
        if(element.getSystemActor() != "")
            mainJSON.SystemActor = element.getSystemActor();
    }

    /**
     * Get NormalActor.
     * @param element NormalActor.
     */
    public void Visit(NormalActor element){
        if(element.getNormalActor() != "")
            mainJSON.ActorsList.add(element.getNormalActor());
    }

    /**
     * Add steps in front of ScenarioLine.
     * @param element ScenarioLine.
     */
    public void Visit(ScenarioLine element){
        if(!element.getScenarioLine().equals("")) {
            int spaceAmount = WhiteSpace.AmountOnFront(element.getScenarioLine());

            if(spaceAmount >= listStep.size()){
                listStep.add(1);
                Integer read = listStep.get(spaceAmount - 1) - 1;
                listStep.set(spaceAmount - 1, read);
            }
            if(spaceAmount + 1 < listStep.size()){
                Integer delete = listStep.size() - spaceAmount - 1;
                for(int q = 0; q < delete; q++){
                    listStep.remove(listStep.size()-1);
                }
                Integer read = listStep.get(listStep.size()-1) + 1;
                listStep.set(spaceAmount, read);
            }
            StringBuilder steps = new StringBuilder();
            for (Integer integer : listStep) {
                steps.append(integer).append(".");
            }
            mainJSON.ScenarioLinesList.add(element.getScenarioLine().substring(0,spaceAmount) + steps +
                    element.getScenarioLine().substring(spaceAmount));

            Integer read = listStep.get(spaceAmount) + 1;
            listStep.set(spaceAmount, read);

        }
    }
}
