package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static java.util.Arrays.asList;

public class TestDrive {
    public static void main(String[] args) throws Exception {
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("hh");
        MongoCollection<Document> collection = db.getCollection("vacancies");

//        collection.drop();
//
//
//        URL url = new URL("https://api.hh.ru/vacancies?text=Java+Developer&period=30&area=2&per_page=469");
//        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
//        httpCon.setRequestMethod("GET");
//        httpCon.connect();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
//        String line = reader.readLine();
//
//
//        Document document = Document.parse(line);
//        collection.insertOne(document);

        Document unwind = new Document()
                .append("$unwind", "$items");

        Document project = new Document()
                .append("$project", new Document()
                        .append("vacancy", "$items.name")
                        .append("employer","$items.employer.name")
                        .append("salary", "$items.salary")
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

        Document out = new Document()
                .append("$out", "filteredJobs");

        MongoCursor<Document> cur =  collection.aggregate(asList(unwind, filterBySalary, project, out)).iterator();

        showCur(cur);



//         *
//         * Create http connection
//         * download dictionaries from hh
//         *      vacancy_search_fields
//         *      area
//         *      specialization
//         *
//         *  save dictionaries in database
    }

    private static void showCur(MongoCursor<Document> cursor) {
        int count = 0;
        while (cursor.hasNext()) {
            Document currentDoc = cursor.next();
            System.out.println(currentDoc.toJson());
            count++;
        }

        System.out.println();
        System.out.println(count);
    }
}
