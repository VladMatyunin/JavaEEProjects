package vlad.matyunin;
import org.springframework.web.bind.annotation.*;
import vlad.matyunin.model.Animal;
import vlad.matyunin.model.AnimalService;
import vlad.matyunin.model.Cat;
import vlad.matyunin.model.Dog;

import java.util.ArrayList;

/**
 * Created by Vlad on 11.11.2017.
 */
@RestController
public class MyRestController {
    @RequestMapping("/test")
    public String getSum(@RequestParam("a") int a, @RequestParam("b") int b) {
        return String.valueOf(a+b);
    }
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String getSum2(@RequestParam("a") int a, @RequestParam("b") int b) {
        return String.valueOf(a+b);
    }
    @RequestMapping(value = "/getObject", method = RequestMethod.POST)
    public String getObjectString(@RequestBody Animal animal) {
        return new AnimalService().getInfo(animal);
    }

}
