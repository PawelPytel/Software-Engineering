package pl.put.poznan.sqc.rest;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sqc.controller.AccessLevelPointController;
import pl.put.poznan.sqc.controller.ScenarioStepCounterController;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.models.ScenarioElementsModel;
import pl.put.poznan.sqc.models.ScenarioJSONModel;
import pl.put.poznan.sqc.visitors.AccessLevelPointVisitor;
import pl.put.poznan.sqc.visitors.ScenarioStepCounterVisitor;

/**
 * Handles the functionality of the "/AccessLevelPoint" endpoint.
 */
@RestController
@RequestMapping("/AccessLevelPoint")
public class AccessLevelPoint {

    /**
     * Loads data from JSON and uses the AccessLevelPointVisitor to an access point.
     * @param scenarioModel A scenario model in JSON format.
     * @return The Scenario with define access level (string, JSON).
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ScenarioJSONModel post(@RequestBody ScenarioJSONModel scenarioModel) {
        ScenarioElementsModel elementsModel = new ScenarioElementsModel(scenarioModel);

        AccessLevelPointController accessLevelPointList = new AccessLevelPointController();
        // Adding all model elements
        accessLevelPointList.Attach(elementsModel.Title);
        for (NormalActor nActor:elementsModel.ActorsList) {
            accessLevelPointList.Attach(nActor);
        }
        accessLevelPointList.Attach(elementsModel.SystemActor);
        for (ScenarioLine sLine:elementsModel.ScenarioLinesList) {
            accessLevelPointList.Attach(sLine);
        }

        AccessLevelPointVisitor visitor = new AccessLevelPointVisitor();
        accessLevelPointList.Accept(visitor, scenarioModel.AccessLevel);
        visitor.scenarioJSONModel.AccessLevel = scenarioModel.AccessLevel;
        return visitor.scenarioJSONModel;
    }
}