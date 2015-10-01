package mongodb;

import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestDrive {
    public static void main(String[] args) throws Exception {
//        MongoClient client = new MongoClient();
//        MongoDatabase db = client.getDatabase("hh");
//        MongoCollection<Document> collection = db.getCollection("vacancies");

//        collection.drop();
//
        String token = "oauth2_access_token=AQUXZVgUqu-VXTIHIHLCnqdl2hDeU_EOtvdRB_ySg8vwg4Xi_dPIvqq_HnvRL7TB72yXFCVrHCf5UWWHFIyyE3GZA9XYBxc_kzo08EN0Zzr8dMlMoZYxEGgB7k9oiTYQ9dejPgHpnIbu_Q0CZHGMOGjBfNzzxmuev4XvmQPzKlgDFIYw1Ws";
        String title = "&job-title=Java+Developer";
        String country = "&country-code=ru";
        String company = "&company=Oracle";
        String count = "&count=2";
        String start = "&start=1";
        String facet = "&facets=";
        String format = "&format=json";


        URL url = new URL("https://api.linkedin.com/v1/job-search?" + token + title + count + start + facet + format);
//        URL url = new URL("https://api.linkedin.com/v1/job-search?" + token + title + count + start + country + facet + format);
//        URL url = new URL("https://api.linkedin.com/v1/jobs/74331664:(company,position,skills-and-experience,description-snippet,salary)?" + token + format);
//        URL url = new URL("https://api.hh.ru/vacancies?text=Java+Developer&period=30&area=2&per_page=469");
        showRequest(url);

        start = "&start=10";
        url = new URL("https://api.linkedin.com/v1/job-search?" + token + title + count + start + facet + format);
        showRequest(url);

        start = "&start=10";
        url = new URL("https://api.linkedin.com/v1/job-search?" + token + title + count + start + facet + format);
        showRequest(url);

        start = "&start=10";
        url = new URL("https://api.linkedin.com/v1/job-search?" + token + title + count + start + facet + format);
        showRequest(url);

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
//                                .append("description", "$items.snippet")
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
//        Document jobsIDonly = new Document()
//                .append("$project", new Document()
//                                .append("_id", 1)
//                );
//
//        Document jobsIDout = new Document()
//                .append("$out", "jobsId");
//
//        System.out.println();
//
//        MongoCursor<Document> idCursor = collection.aggregate(asList(unwind, filterBySalary, project, jobsIDonly)).iterator();
//
//        while (idCursor.hasNext()) {
//            Document currentID = idCursor.next();
//
//            String vacancyID = currentID.getString("_id");
//            URL url = new URL("https://api.hh.ru/vacancies/" + vacancyID);
//            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
//            httpCon.setRequestMethod("GET");
//            httpCon.connect();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
//            String line = reader.readLine();
//
//            Document document = Document.parse(line);
//            collection = db.getCollection("clearVacancies");
//            collection.insertOne(document);
//        }

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

    private static void showRequest(URL url) throws Exception{
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setRequestMethod("GET");
        httpCon.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
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

//    public static void main(String[] args) throws Exception{
//        String country = "Russia";
//        String title = "Java developer";
//
//        MongoClient client = new MongoClient();
//        MongoDatabase hhDatabase = client.getDatabase("hh");
//        MongoCollection<Document> downloadedVacancies = hhDatabase.getCollection("downloadedVacancies");
//
//        String[] titleSplitted = title.split(" ");
//        String area = "";
//        switch (country) {
//            case "Russia":
//                area = "&area=2";
//                break;
//        }
//        URL url = new URL("https://api.hh.ru/vacancies?text=" + titleSplitted[0] + "+" + titleSplitted[1] + area + "&period=30&per_page=469");
//        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
//        httpCon.setRequestMethod("GET");
//        httpCon.connect();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
//        String line = reader.readLine();
//
//        Document document = Document.parse(line);
//        MongoCollection<Document> dirtyVacancies = hhDatabase.getCollection("dirtyVacancies");
//        dirtyVacancies.insertOne(document);
//
//        Document unwind = new Document()
//                .append("$unwind", "$items");
//
//        Document project = new Document()
//                .append("$project", new Document()
//                                .append("_id", "$items.id")
//                                .append("vacancy", "$items.name")
//                                .append("employer", "$items.employer.name")
//                                .append("salary", "$items.salary")
//                                .append("description", "$items.snippet")
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
//        Document jobsIDonly = new Document()
//                .append("$project", new Document()
//                                .append("_id", 1)
//                );
//
//        MongoCursor<Document> idCursor = dirtyVacancies.aggregate(asList(unwind, filterBySalary, project, jobsIDonly)).iterator();
//
//        while (idCursor.hasNext()) {
//            Document currentID = idCursor.next();
//
//            String vacancyID = currentID.getString("_id");
//            url = new URL("https://api.hh.ru/vacancies/" + vacancyID);
//            httpCon = (HttpURLConnection) url.openConnection();
//            httpCon.setRequestMethod("GET");
//            httpCon.connect();
//            reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
//            line = reader.readLine();
//
//            document = Document.parse(line);
//            downloadedVacancies.insertOne(document);
//        }
//
//    }
}
