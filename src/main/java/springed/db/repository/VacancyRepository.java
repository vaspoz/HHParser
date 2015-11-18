package springed.db.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import springed.db.Vacancy;

import java.util.List;

/**
 * Created by v.pozdeev on 16.11.2015.
 */
@Repository
public class VacancyRepository {

    private final String COLLECTION_NAME = "vacancies";

//    List<Vacancy> findByCountry(String country) {return null;}
//    List<Vacancy> findByTitleLike(String title){return null;}

    @Autowired
    MongoOperations mongo;


    public long getCollectionCount() {

        return mongo.count(new Query(), COLLECTION_NAME);

    }


    public List<Vacancy> getAllVacanciesForTitle(String title) {

        return mongo.find(
                new Query(Criteria.where("name").regex(title)),
                Vacancy.class,
                COLLECTION_NAME);

    }

}
