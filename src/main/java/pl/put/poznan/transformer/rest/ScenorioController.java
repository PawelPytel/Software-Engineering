package pl.put.poznan.transformer.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.models.ScenarioModel;


@RestController
@RequestMapping("/ScenorioController")
public class ScenorioController {

    @RequestMapping(method = RequestMethod.POST, produces = "applicationn/jso")
    @ResponseBody
    public String post( @RequestBody ScenarioModel scenarioModel) {

        return scenarioModel.ActorsList.get(1);
    }
}
