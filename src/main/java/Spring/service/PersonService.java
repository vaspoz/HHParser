package Spring.service;

import Spring.domain.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("personService")
@Transactional
public class PersonService {

    protected static Logger log = LoggerFactory.getLogger(PersonService.class);


    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;


    public List<Person> getAll() {

        log.debug("Retrieving all persons.");

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Person");

        return query.list();

    }


    public Person get(Integer id) {

        log.debug("Retrieve one person.");

        Session session = sessionFactory.getCurrentSession();
        Person person = (Person) session.get(Person.class, id);

        return person;

    }


    public void add(Person person) {

        log.debug("Adding new person");

        Session session = sessionFactory.getCurrentSession();
        session.save(person);

    }


    public void delete(Integer id) {

        log.debug("Deleting existing person");

        Session session = sessionFactory.getCurrentSession();
        Person person = (Person) session.get(Person.class, id);

        session.delete(person);

    }


    public void edit(Person person) {

        log.debug("Editing existing person.");

        Session session = sessionFactory.getCurrentSession();

        Person existingPerson = (Person) session.get(Person.class, person.getId());

        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setMoney(person.getMoney());

        session.save(existingPerson);

    }
}
