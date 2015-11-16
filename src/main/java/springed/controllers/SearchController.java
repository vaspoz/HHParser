package springed.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springed.components.SearchParameters;
import springed.db.VacancyService;

/**
 * Created by v.pozdeev on 16.11.2015.
 */
@Controller
public class SearchController {

    @Autowired
    VacancyService vacancyService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String searchForm() {

        return "searchForm";

    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String startSearch(SearchParameters params, Model model) {

//        Do not use this if you have not running "mongod" process on your localhost
//        long collectionCount = vacancyService.getCollectionCount();
        model.addAttribute("title", params.getTitle());
        return "searchForm";

    }
}

