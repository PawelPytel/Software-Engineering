package pl.put.poznan.sqc.rest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/MJController")
public class MJController {

    @RequestMapping(method = RequestMethod.POST, produces = "applicationn/jso")
    @ResponseBody
    public String post( @RequestBody MJUserModel user) {

        return user.imie;
    }
}
