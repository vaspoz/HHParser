package springed.db.repository;

import com.mongodb.DBCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by v.pozdeev on 16.11.2015.
 */
@Repository
public class VacancyRepository {

//    List<Vacancy> findByCountry(String country) {return null;}
//    List<Vacancy> findByTitleLike(String title){return null;}

    @Autowired
    DBCollection collection;


    public long getCollectionCount() {

        return collection.count();

    }

}
