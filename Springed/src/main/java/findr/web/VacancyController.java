package findr.web;

import findr.Vacancy;
import findr.data.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    public List<Vacancy> vacancy(
            @RequestParam String title,
            @RequestParam String country
    ) {

        return vacancyRepository.findVacancies(title, country);

    }
}

