package pl.put.poznan.sqc.models;
import pl.put.poznan.sqc.elements.Title;

import java.util.ArrayList;

/**
 * Storage JSON scenario model.
 */
public class ScenarioJSONModel {
    /**
     * Constructor: Initialize ActorsList and ScenarioLinesList.
     */
    public ScenarioJSONModel() {
        ActorsList = new ArrayList<String>();
        ScenarioLinesList = new ArrayList<String>();
    }

    /**
     * Stores the Title.
     */
    public String Title;
    /**
     * Stores the ActorsList.
     */
    public ArrayList<String> ActorsList;
    /**
     * Stores the SystemActor.
     */
    public String SystemActor;
    /**
     * Stores the ScenarioLinesList.
     */
    public ArrayList<String> ScenarioLinesList;

}
