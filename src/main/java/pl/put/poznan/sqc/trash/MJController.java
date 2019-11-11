package pl.put.poznan.sqc.trash;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sqc.trash.MJUserModel;


@RestController
@RequestMapping("/MJController")
public class MJController {

    @RequestMapping(method = RequestMethod.POST, produces = "applicationn/jso")
    @ResponseBody
    public String post( @RequestBody MJUserModel user) {

        return user.imie;
    }
}
