package pl.put.poznan.sqc.visitors;

import pl.put.poznan.sqc.Helpers.WhiteSpace;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;
import pl.put.poznan.sqc.interfaces.IVisitor;
import pl.put.poznan.sqc.interfaces.IVisitorWithIntParametr;
import pl.put.poznan.sqc.models.ScenarioJSONModel;

public class AccessLevelPointVisitor implements IVisitorWithIntParametr {

    public ScenarioJSONModel scenarioJSONModel;

    public AccessLevelPointVisitor(){
        scenarioJSONModel = new ScenarioJSONModel();
    }

    @Override
    public void Visit(Title element, int accesLevel) {
        if(element.getTitle() != "")
            scenarioJSONModel.Title = element.getTitle();
    }

    @Override
    public void Visit(SystemActor element, int accesLevel) {
        if(element.getSystemActor() != "")
            scenarioJSONModel.SystemActor = element.getSystemActor();
    }

    @Override
    public void Visit(NormalActor element, int accesLevel) {
        if(element.getNormalActor() != "") {
            scenarioJSONModel.ActorsList.add(element.getNormalActor());
        }
    }

    @Override
    public void Visit(ScenarioLine element, int accesLevel) {
        if(element.getScenarioLine() != "") {
            int spaceAmount = WhiteSpace.AmountOnFront(element.getScenarioLine());
            if(spaceAmount <= accesLevel-1)
                scenarioJSONModel.ScenarioLinesList.add(element.getScenarioLine());
        }
    }
}
