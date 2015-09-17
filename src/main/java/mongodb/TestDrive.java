package mongodb;

import org.bson.Document;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) throws Exception {

//         * Create connection with database
        MongoDBConnection dbConnection = MongoDBConnection.getDBConnection("hh");
        dbConnection.useCollection("vacancies");
        dbConnection.drop();

        URL url = new URL("https://api.hh.ru/vacancies?text=Java+Developer&period=30&area=2&per_page=200");

        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setRequestMethod("GET");
//        httpCon.setRequestProperty("text", "Java");
//        httpCon.setRequestProperty("search_field", "name");
//        httpCon.setRequestProperty("area", "2");
//        httpCon.setRequestProperty("period", "3");
//        httpCon.setRequestProperty("", "");
        httpCon.connect();

        Scanner scanner = new Scanner(httpCon.getInputStream());

        String line = scanner.nextLine();
        Document document = Document.parse(line);
        dbConnection.saveDocument(document);

//         *
//         * Create http connection
//         * download dictionaries from hh
//         *      vacancy_search_fields
//         *      area
//         *      specialization
//         *
//         *  save dictionaries in database
    }
}
