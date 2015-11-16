package springed.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

/**
 * Created by v.pozdeev on 16.11.2015.
 */
@Service
public class VacancyService {

    @Autowired
    MongoOperations mongo;


    public long getCollectionCount() {

        return mongo.getCollection("vacancies").count();

    }
}
