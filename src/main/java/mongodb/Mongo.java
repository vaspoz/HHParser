package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Василий on 26.09.2015.
 */
public class Mongo {


    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> collection;


    private Mongo(String dbName) {

        client = new MongoClient();
        db = client.getDatabase(dbName);
        collection = db.getCollection("vacancies");

    }


    public static Mongo initiateDB(String dbName) {

        return new Mongo(dbName);

    }


    public void insertDocument(Document document) {

        collection.insertOne(document);

    }


    public List<Document> findAll(Document document) {

        return collection.find(document).into(new ArrayList<Document>());

    }


    public List<Document> request() {

        return stub();

    }


    public void clearDBase() {

        db.drop();

    }


    public void processAndSave(Mongo db) {

        Document unwind = new Document()
                .append("$unwind", "$items");

        Document project = new Document()
                .append("$project", new Document()
                                .append("_id", "$items.id")
                                .append("vacancy", "$items.name")
                                .append("employer", "$items.employer.name")
                                .append("salary", "$items.salary")
                                .append("description", "$items.snippet")
                );

        Document group = new Document()
                .append("$group", new Document()
                                .append("_id", "$items.employer.name")
                                .append("vacancies", new Document()
                                                .append("$addToSet", "$items.name")
                                )
                );

        Document filterBySalary = new Document()
                .append("$match", new Document()
                                .append("$or", asList(
                                                new Document("items.salary", null),
                                                new Document("items.salary.from", new Document()
                                                        .append("$gte", 80000))
                                        )
                                )
                );

        Document jobsIDonly = new Document()
                .append("$project", new Document()
                                .append("_id", 1)
                );

        Document jobsIDout = new Document()
                .append("$out", "jobsId");

        MongoCursor<Document> idCursor = collection.aggregate(asList(unwind, filterBySalary, project, jobsIDonly)).iterator();

        try {
            while (idCursor.hasNext()) {
                Document currentID = idCursor.next();

                String vacancyID = currentID.getString("_id");
                URL url = new URL("https://api.hh.ru/vacancies/" + vacancyID);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                httpCon.setRequestMethod("GET");
                httpCon.connect();
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
                String line = reader.readLine();

                Document document = Document.parse(line);

                db.insertDocument(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Document> returnAll() {

        List<Document> entries;
        MongoCursor<Document> cursor = collection.find().iterator();
        entries = fillFrom(cursor);

        return entries;

    }


    private List<Document> fillFrom(MongoCursor<Document> cursor) {

        List<Document> filled = new ArrayList<>();
        while (cursor.hasNext()) {
            filled.add(cursor.next());
        }
        return filled;

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
