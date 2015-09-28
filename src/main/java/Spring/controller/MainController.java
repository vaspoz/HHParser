package Spring.controller;

import Spring.domain.Person;
import Spring.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {
    protected static final Logger log = LoggerFactory.getLogger(MainController.class);


    @Resource(name = "personService")
    private PersonService personService;


    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String getPersons(Model model) {

        log.debug("Received request to show all persons.");

        List<Person> persons = personService.getAll();
        model.addAttribute("persons", persons);

        return "personspage";

    }


    @RequestMapping(value = "/persons/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("porsonAttribute") Person person) {

        log.debug("Received request to add new person");

        personService.add(person);

        return "addedpage";

    }


    @RequestMapping(value = "/persons/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) Integer id, Model model) {

        log.debug("Received request to delete existing person.");

        personService.delete(id);
        model.addAttribute("id", id);

        return "deletedpage";

    }


    @RequestMapping(value = "/persons/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id", required = true) Integer id, Model model) {

        log.debug("Received request to show edit page");

        model.addAttribute("personAttribute", personService.get(id));

        return "editpage";

    }


    @RequestMapping(value = "/persons/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("personAttribute") Person person,
                           @RequestParam(value = "id", required = true) Integer id,
                           Model model) {

        log.debug("Receiving request to update person");

        person.setId(id);
        personService.edit(person);
        model.addAttribute("id", id);

        return "editedpage";

    }
}
