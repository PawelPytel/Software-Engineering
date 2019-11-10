package pl.put.poznan.sqc.rest;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sqc.controller.ScenarioStepCounterController;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.models.ScenarioElementsModel;
import pl.put.poznan.sqc.models.ScenarioJSONModel;
import pl.put.poznan.sqc.visitors.ScenarioStepCounterVisitor;

@RestController
@RequestMapping("/ScenarioStepCounter")
public class ScenarioStepCounter {

    // If you dont have argument, you must use ""
    @RequestMapping(method = RequestMethod.POST, produces = "applicationn/jso")
    @ResponseBody
    public String post( @RequestBody ScenarioJSONModel scenarioModel) {

        ScenarioElementsModel elementsModel = new ScenarioElementsModel(scenarioModel);

        ScenarioStepCounterController stepCounterList = new ScenarioStepCounterController();
        // Adding all model elements
        stepCounterList.Attach(elementsModel.Title);
        for (NormalActor nActor:elementsModel.ActorsList) {
            stepCounterList.Attach(nActor);
        }
        stepCounterList.Attach(elementsModel.SystemActor);
        for (ScenarioLine sLine:elementsModel.ScenarioLinesList) {
            stepCounterList.Attach(sLine);
        }

        ScenarioStepCounterVisitor visitor = new ScenarioStepCounterVisitor();
        stepCounterList.Accept(visitor);

        return Integer.toString(visitor.numberOfSteps);
    }
}