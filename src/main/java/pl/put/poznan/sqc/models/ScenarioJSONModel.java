package pl.put.poznan.sqc.models;
import pl.put.poznan.sqc.elements.Title;

import java.util.ArrayList;

public class ScenarioJSONModel {
    public ScenarioJSONModel() {
        ActorsList = new ArrayList<String>();
        ScenarioLinesList = new ArrayList<String>();
    }

    public String Title;
    public ArrayList<String> ActorsList;
    public String SystemActor;
    public ArrayList<String> ScenarioLinesList;

}
