package findr.web;

import findr.Vacancy;
import findr.data.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by v.pozdeev on 28.10.2015.
 */
@Controller
@RequestMapping("/vacancies")
public class VacancyController {

    private VacancyRepository vacancyRepository;


    @Autowired
    public VacancyController(VacancyRepository vacancyRepository) {

        this.vacancyRepository = vacancyRepository;

    }


    @RequestMapping(method = GET)
    public String vacancy(
            @RequestParam(defaultValue = "Vacancy") String title,
            @RequestParam(defaultValue = "Country") String country,
            @RequestParam(defaultValue = "20") long count,
            Model model
    ) {

        model.addAttribute("vacancyList", vacancyRepository.findVacancies(title, country, count));
        return "vacancies";

    }


    @RequestMapping(value = "/show", method = GET)
    public String showVacancy(
            @RequestParam("vacancy_id") long id,
            Model model) {

        model.addAttribute("vacancy", vacancyRepository.findOne(id));
        return "vacancy";

    }


    @RequestMapping(value = "/{vacancyId}", method = GET)
    public String vacancy(
            @PathVariable long vacancyId,
            Model model) throws Exception{

        Vacancy vacancy = vacancyRepository.findOne(vacancyId);
        model.addAttribute("vacancy", vacancy);
        return "vacancy";

    }
}

