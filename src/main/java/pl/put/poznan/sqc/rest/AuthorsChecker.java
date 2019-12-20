package pl.put.poznan.sqc.rest;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sqc.controller.AuthorsCheckerController;
import pl.put.poznan.sqc.controller.KeyWordsCounterController;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.models.ScenarioElementsModel;
import pl.put.poznan.sqc.models.ScenarioJSONModel;
import pl.put.poznan.sqc.visitors.AuthorsCheckerVisitor;
import pl.put.poznan.sqc.visitors.KeyWordsCounterVisitor;

import java.util.ArrayList;

@RestController
@RequestMapping("/AuthorsChecker")
public class AuthorsChecker {
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody

    public ArrayList<String> post(@RequestBody ScenarioJSONModel scenarioModel) {

        ScenarioElementsModel elementsModel = new ScenarioElementsModel(scenarioModel);

        AuthorsCheckerController authorsCheckerList = new AuthorsCheckerController();
        // Adding all model elements
        for (NormalActor nActor:elementsModel.ActorsList) {
            authorsCheckerList.Attach(nActor);
        }
        authorsCheckerList.Attach(elementsModel.SystemActor);
        for (ScenarioLine sLine:elementsModel.ScenarioLinesList) {
            authorsCheckerList.Attach(sLine);
        }

        AuthorsCheckerVisitor visitor = new AuthorsCheckerVisitor();
        authorsCheckerList.Accept(visitor);

        return visitor.linesWithoutActors;
    }
}
