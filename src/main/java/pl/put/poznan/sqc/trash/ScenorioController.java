package pl.put.poznan.sqc.trash;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sqc.models.ScenarioJSONModel;


@RestController
@RequestMapping("/ScenorioController")
public class ScenorioController {

    @RequestMapping(method = RequestMethod.POST, produces = "applicationn/jso")
    @ResponseBody
    public String post( @RequestBody ScenarioJSONModel scenarioModel) {

        return scenarioModel.ActorsList.get(1);
    }
}
