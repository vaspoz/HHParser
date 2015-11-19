package springed.db.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springed.db.Vacancy;

import java.util.List;

/**
 * Created by v.pozdeev on 16.11.2015.
 */
@Repository
public interface VacancyRepository extends MongoRepository<Vacancy, ObjectId> {

    List<Vacancy> findByCountry(String country);
    List<Vacancy> findByTitleLike(String title);

}
