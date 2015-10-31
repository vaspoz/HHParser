package findr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by v.pozdeev on 28.10.2015.
 */
@Controller
@RequestMapping("/search")
public class SearcherController {

    @RequestMapping(method = GET)
    public String search() {

        return "search-start";

    }


    @RequestMapping(method = POST)
    public String searchProcessing(
            @ModelAttribute("title") String title,
            @ModelAttribute("country") String country)
    {

        return "redirect:/vacancies";

    }
}

