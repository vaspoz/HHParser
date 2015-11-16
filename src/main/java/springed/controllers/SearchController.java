package springed.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springed.components.SearchParameters;

/**
 * Created by v.pozdeev on 16.11.2015.
 */
@Controller
public class SearchController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String searchForm() {

        return "searchForm";

    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String startSearch(SearchParameters params, Model model) {

        System.out.println(params.getCountry() + " : " + params.getTitle() + " : " + params.getClearDBase());
        model.addAttribute("title", params.getTitle());
        model.addAttribute("country", params.getCountry());
        return "searchForm";

    }
}

