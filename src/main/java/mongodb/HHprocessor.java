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

import static java.util.Arrays.asList;

/**
 * Created by Василий on 26.09.2015.
 */
public class HHprocessor implements RecordProcessor {

    public void process(MongoCollection<Document> collection, Document document) {
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

                document = Document.parse(line);

                MongoClient client = new MongoClient();
                MongoDatabase db = client.getDatabase(collection.getNamespace().getDatabaseName());
                MongoCollection<Document> coll = db.getCollection("clearVacancies");
                collection.insertOne(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
