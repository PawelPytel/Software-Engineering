package pl.put.poznan.sqc.models;

import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;

import java.util.ArrayList;

/**
 * Storage object scenario model
 */
public class ScenarioElementsModel {
    /**
     * Stores the Title object.
     */
    public Title Title;
    /**
     * Stores the ActorsList objects.
     */
    public ArrayList<NormalActor> ActorsList;
    /**
     * Stores the SystemActor object.
     */
    public SystemActor SystemActor;
    /**
     * Stores the ScenarioLinesList objects.
     */
    public ArrayList<ScenarioLine> ScenarioLinesList;

    /**
     * Constructor: Initialize objects.
     */
    public ScenarioElementsModel(){
        Title = new Title();
        ActorsList = new ArrayList<NormalActor>();
        SystemActor = new SystemActor();
        ScenarioLinesList = new ArrayList<ScenarioLine>();
    }

    /**
     * Constructor: Transform JSON model to Elements model.
     * @param jsonModel ScenarioJSONModel.
     */
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
