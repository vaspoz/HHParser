package springed.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/vacancies")
    @ModelAttribute("vacancyList")
    public List<Vacancy> showVacancies(String title, String country) {

        return vacancyRepository.findByTitleLike(title);

    }


    @RequestMapping("vacancy/{id}")
    public String showVacancy(@PathVariable String id, Model model) {

        Vacancy vacancy = vacancyRepository.findOne(new ObjectId(id));
        System.out.println("Request id: " + id);
        System.out.println("Vacancy:");
        System.out.println("\tTitle : " + vacancy.getTitle());
        System.out.println("\tDescription : " + vacancy.getDescription());

        model.addAttribute("title", vacancy.getTitle());
        model.addAttribute("description", vacancy.getDescription());

        return "vacancy";

    }

}

