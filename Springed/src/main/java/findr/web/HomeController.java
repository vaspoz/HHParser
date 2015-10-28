package findr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by v.pozdeev on 28.10.2015.
 */
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {


    @RequestMapping(method = GET)
    public String home() {

        return "home";

    }


}
