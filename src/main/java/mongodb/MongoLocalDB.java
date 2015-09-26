package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Василий on 26.09.2015.
 */
public class MongoLocalDB {

    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> vacancies;


    private MongoLocalDB(String dbName) {

        client = new MongoClient();
        db = client.getDatabase(dbName);
        vacancies = db.getCollection("vacancies");

    }


    public static MongoLocalDB initiateDB(String dbName) {

        return new MongoLocalDB(dbName);

    }


    public void insertDocument(RecordProcessor processor, Document document) {
        //todo: start processor!
        vacancies.insertOne(document);

    }


    public List<Document> request(String title, String country) {

        return stub();

    }


    private List<Document> stub() {

        List<Document> vacancies = new ArrayList<>();

        vacancies.add(new Document("title", "A")
                        .append("company", "1")
                        .append("description", "qwe")
                        .append("producer", "hh")
                        .append("salary", "100000")
                        .append("location", "spb")
        );
        vacancies.add(new Document("title", "Qwass")
                        .append("company", "Main")
                        .append("description", "Great opportunity")
                        .append("producer", "lin")
                        .append("salary", "100000")
                        .append("location", "poland")
        );

        return vacancies;

    }
}
