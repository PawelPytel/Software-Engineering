package pl.put.poznan.sqc.rest;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sqc.controller.ScenarioStepCounterController;
import pl.put.poznan.sqc.controller.StepListController;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.models.ScenarioElementsModel;
import pl.put.poznan.sqc.models.ScenarioJSONModel;
import pl.put.poznan.sqc.visitors.ScenarioStepCounterVisitor;
import pl.put.poznan.sqc.visitors.StepListVisitor;

/**
 * Handles the functionality of the "/StepList" endpoint.
 */
@RestController
@RequestMapping("/StepList")
public class StepList {
    /**
     * Loads data from JSON and uses the StepListVisitor to add steps in a scenario.
     * @param scenarioModel A scenario model in JSON format.
     * @return Scenario with added steps (ScenarioJSONModel).
     */
    // If you dont have argument, you must use ""
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ScenarioJSONModel post( @RequestBody ScenarioJSONModel scenarioModel) {

        ScenarioElementsModel elementsModel = new ScenarioElementsModel(scenarioModel);

        StepListController stepList = new StepListController();
        // Adding all model elements
        stepList.Attach(elementsModel.Title);
        for (NormalActor nActor:elementsModel.ActorsList) {
            stepList.Attach(nActor);
        }
        stepList.Attach(elementsModel.SystemActor);
        for (ScenarioLine sLine:elementsModel.ScenarioLinesList) {
            stepList.Attach(sLine);
        }

        StepListVisitor visitor = new StepListVisitor();
        stepList.Accept(visitor);

        return visitor.mainJSON;
    }
}