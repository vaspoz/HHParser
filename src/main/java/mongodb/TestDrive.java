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

public class TestDrive {
    public static void main(String[] args) throws Exception {
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("linkedin");
        MongoCollection<Document> collection = db.getCollection("vacancies");

        collection.drop();

        String token = "oauth2_access_token=AQUXZVgUqu-VXTIHIHLCnqdl2hDeU_EOtvdRB_ySg8vwg4Xi_dPIvqq_HnvRL7TB72yXFCVrHCf5UWWHFIyyE3GZA9XYBxc_kzo08EN0Zzr8dMlMoZYxEGgB7k9oiTYQ9dejPgHpnIbu_Q0CZHGMOGjBfNzzxmuev4XvmQPzKlgDFIYw1Ws";
        String title = "&job-title=Java+Developer";
        String country = "&country-code=ru";
        String company = "&company=Oracle";
        String count = "&count=20";
        String start = "&start=10";
        String format = "&format=json";


        URL url = new URL("https://api.linkedin.com/v1/job-search?" + token + start + format);
//        URL url = new URL("https://api.linkedin.com/v1/job-search?" + token  + title + company + count + start + format);
//        URL url2 = new URL("https://api.linkedin.com/v1/jobs/74331664?" + token + format);
//        URL url = new URL("https://api.hh.ru/vacancies?text=Java+Developer&period=30&area=2&per_page=469");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setRequestMethod("GET");
        httpCon.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
//        Document document = Document.parse(line);
//        collection.insertOne(document);

//        Document unwind = new Document()
//                .append("$unwind", "$items");
//
//        Document project = new Document()
//                .append("$project", new Document()
//                                .append("_id", "$items.id")
//                                .append("vacancy", "$items.name")
//                                .append("employer", "$items.employer.name")
//                                .append("salary", "$items.salary")
//                );
//
//        Document group = new Document()
//                .append("$group", new Document()
//                                .append("_id", "$items.employer.name")
//                                .append("vacancies", new Document()
//                                                .append("$addToSet", "$items.name")
//                                )
//                );
//
//        Document filterBySalary = new Document()
//                .append("$match", new Document()
//                                .append("$or", asList(
//                                                new Document("items.salary", null),
//                                                new Document("items.salary.from", new Document()
//                                                        .append("$gte", 80000))
//                                        )
//                                )
//                );
//
//        Document out = new Document()
//                .append("$out", "filteredJobs");
//
//        System.out.println();
//        collection.aggregate(asList(unwind, filterBySalary, project, out));



//         *
//         * Create http connection
//         * download dictionaries from hh
//         *      vacancy_search_fields
//         *      area
//         *      specialization
//         *
//         *  save dictionaries in database
//        AQUXZVgUqu-VXTIHIHLCnqdl2hDeU_EOtvdRB_ySg8vwg4Xi_dPIvqq_HnvRL7TB72yXFCVrHCf5UWWHFIyyE3GZA9XYBxc_kzo08EN0Zzr8dMlMoZYxEGgB7k9oiTYQ9dejPgHpnIbu_Q0CZHGMOGjBfNzzxmuev4XvmQPzKlgDFIYw1Ws
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
