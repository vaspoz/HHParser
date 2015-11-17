package springed.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springed.db.repository.VacancyRepository;

/**
 * Created by v.pozdeev on 17.11.2015.
 */
@Controller
public class VacancyController {

    @Autowired
    VacancyRepository vacancyRepository;

    @RequestMapping(value = "/vacancies", method = RequestMethod.GET)
    public String showVacancies(String title,
                                String country,
                                Model model) {

        long count = vacancyRepository.getCollectionCount();
        model.addAttribute("title", title);
        model.addAttribute("country", country);
        model.addAttribute("count", count);
        return "vacancies";

    }
}

