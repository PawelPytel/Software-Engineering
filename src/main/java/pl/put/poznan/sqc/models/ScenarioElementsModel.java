package pl.put.poznan.sqc.models;

import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;

import java.util.ArrayList;

public class ScenarioElementsModel {
    public Title Title;
    public ArrayList<NormalActor> ActorsList;
    public SystemActor SystemActor;
    public ArrayList<ScenarioLine> ScenarioLinesList;

    public ScenarioElementsModel(){
        Title = new Title();
        ActorsList = new ArrayList<NormalActor>();
        SystemActor = new SystemActor();
        ScenarioLinesList = new ArrayList<ScenarioLine>();
    }

    public ScenarioElementsModel(ScenarioJSONModel jsonModel){
        Title = new Title();
        ActorsList = new ArrayList<NormalActor>();
        SystemActor = new SystemActor();
        ScenarioLinesList = new ArrayList<ScenarioLine>();


        this.Title.setTitle(jsonModel.Title);
        this.SystemActor.systemActor = jsonModel.SystemActor;

        for (String nActor: jsonModel.ActorsList) {
            NormalActor normalActor = new NormalActor();
            normalActor.normalActor = nActor;
            this.ActorsList.add(normalActor);
        }

        for (String sLine: jsonModel.ScenarioLinesList) {
            ScenarioLine scenarioLine = new ScenarioLine();
            scenarioLine.scenarioLine = sLine;
            this.ScenarioLinesList.add(scenarioLine);
        }
    }
}
