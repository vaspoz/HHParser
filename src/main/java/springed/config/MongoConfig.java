package springed.config;

import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by v.pozdeev on 16.11.2015.
 */
@Configuration
@EnableMongoRepositories(basePackages = "springed.db.repository")
public class MongoConfig {


    @Bean
    public MongoFactoryBean mongo() {

        MongoFactoryBean mongoFactory = new MongoFactoryBean();
        mongoFactory.setHost("localhost");
        return mongoFactory;

    }


    @Bean
    public MongoOperations mongoTemplate(Mongo mongo) {

        return new MongoTemplate(mongo, "vacancies");

    }


    @Bean
    public DBCollection collection(MongoOperations operations) {

        return operations.getCollection("vacancies");

    }
}
