package pl.put.poznan.sqc.rest;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sqc.controller.KeyWordsCounterController;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.models.ScenarioElementsModel;
import pl.put.poznan.sqc.models.ScenarioJSONModel;
import pl.put.poznan.sqc.visitors.KeyWordsCounterVisitor;

/**
 * Handles the functionality of the "/KeyWordsCounter" endpoint.
 */
@RestController
@RequestMapping("/KeyWordsCounter")

public class KeyWordsCounter {
    /**
     * Loads data from JSON and uses the KeyWordsCounterVisitor to count key words.
     * @param scenarioModel A scenario model in JSON format.
     * @return The number of key words (string).
     */
    // If you dont have argument, you must use ""
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody

    public String post( @RequestBody ScenarioJSONModel scenarioModel) {

        ScenarioElementsModel elementsModel = new ScenarioElementsModel(scenarioModel);

        KeyWordsCounterController keyWordsCounterList = new KeyWordsCounterController();
        // Adding all model elements
        for (ScenarioLine sLine:elementsModel.ScenarioLinesList) {
            keyWordsCounterList.Attach(sLine);
        }

        KeyWordsCounterVisitor visitor = new KeyWordsCounterVisitor();
        keyWordsCounterList.Accept(visitor);

        return Integer.toString(visitor.numberOfKeyWords);
    }
}