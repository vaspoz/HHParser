package springed.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springed.db.Vacancy;
import springed.db.repository.VacancyRepository;

import java.util.List;

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

        List<Vacancy> vacancyList = vacancyRepository.getAllVacanciesForTitle(title);
        long count = vacancyRepository.getCollectionCount();
        model.addAttribute("vacancyList", vacancyList);
        model.addAttribute("count", count);

        return "vacancies";

    }
}

