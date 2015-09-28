package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class TestDrive {
    public static void main2(String[] args) throws Exception {
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("hh");
        MongoCollection<Document> collection = db.getCollection("vacancies");
//
//        collection.drop();

//        String token = "oauth2_access_token=AQUXZVgUqu-VXTIHIHLCnqdl2hDeU_EOtvdRB_ySg8vwg4Xi_dPIvqq_HnvRL7TB72yXFCVrHCf5UWWHFIyyE3GZA9XYBxc_kzo08EN0Zzr8dMlMoZYxEGgB7k9oiTYQ9dejPgHpnIbu_Q0CZHGMOGjBfNzzxmuev4XvmQPzKlgDFIYw1Ws";
//        String title = "&job-title=Java+Developer";
//        String country = "&country-code=ru";
//        String company = "&company=Oracle";
//        String count = "&count=20";
//        String start = "&start=1";
//        String facet = "&facets=";
//        String format = "&format=json";
//
//
//        URL url = new URL("https://api.linkedin.com/v1/job-search?" + token + title + count + start + country + facet + format);
//        URL url = new URL("https://api.linkedin.com/v1/jobs/74331664:(company,position,skills-and-experience,description-snippet,salary)?" + token + format);
//        URL url = new URL("https://api.hh.ru/vacancies?text=Java+Developer&period=30&area=2&per_page=469");
//        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
//        httpCon.setRequestMethod("GET");
//        httpCon.connect();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
//        String line;
//
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }


//        Document document = Document.parse(line);
//        collection.insertOne(document);

    }
}
