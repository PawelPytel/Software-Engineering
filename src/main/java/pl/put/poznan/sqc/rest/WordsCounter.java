package pl.put.poznan.sqc.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sqc.controller.WordsCounterController;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.models.ScenarioElementsModel;
import pl.put.poznan.sqc.models.ScenarioJSONModel;
import pl.put.poznan.sqc.visitors.WordsCounterVisitor;

import java.util.Arrays;

/**
 * Handles the functionality of the "/ScenarioStepCounter" endpoint.
 */
@RestController
@RequestMapping("/WordsCounter")
public class WordsCounter {
    /**
     * Loads data from JSON and uses the ScenarioStepCounterVisitor to count steps in a scenario.
     * @param scenarioModel A scenario model in JSON format.
     * @return The number of steps in a scenario (string).
     */
    private static final Logger logger = LoggerFactory.getLogger(WordsCounter.class);

    // If you dont have argument, you must use ""
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String post( @RequestBody ScenarioJSONModel scenarioModel) {

        // log the parameters
        logger.debug("WordsCounter used");

        ScenarioElementsModel elementsModel = new ScenarioElementsModel(scenarioModel);

        WordsCounterController stepCounterList = new WordsCounterController();
        // Adding all model elements
        stepCounterList.Attach(elementsModel.Title);
        for (NormalActor nActor:elementsModel.ActorsList) {
            stepCounterList.Attach(nActor);
        }
        stepCounterList.Attach(elementsModel.SystemActor);
        for (ScenarioLine sLine:elementsModel.ScenarioLinesList) {
            stepCounterList.Attach(sLine);
        }

        WordsCounterVisitor visitor = new WordsCounterVisitor();
        stepCounterList.Accept(visitor);

        logger.debug("WordsCounter return " + visitor.getNumberOfWords());
        return Integer.toString(visitor.getNumberOfWords());
    }
}