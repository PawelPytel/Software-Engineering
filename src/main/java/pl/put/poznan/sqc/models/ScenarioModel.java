package pl.put.poznan.sqc.models;
import java.util.ArrayList;

public class ScenarioModel {
    public ScenarioModel() {
        ActorsList = new ArrayList<String>();
        ScenarioLinesList = new ArrayList<String>();
    }

    public String Title;
    public ArrayList<String> ActorsList;
    public String SystemActor;
    public ArrayList<String> ScenarioLinesList;

}
