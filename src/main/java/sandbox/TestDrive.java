package sandbox;

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
        String count = "&count=1";
        String start = "&start=";
        String facet = "";
        String format = "&format=json";

        URL url2 = new URL("https://api.linkedin.com/v1/" +
                "job-search:(jobs:(" +
                "id,customer-job-code,active,posting-date,expiration-date,posting-timestamp,expiration-timestamp," +
                "company:(" +
                "id,name)," +
                "position:(" +
                "title,location,job-functions,industries,job-type,experience-level)," +
                "skills-and-experience,description-snippet,description,salary," +
                "job-poster:(" +
                "id,first-name,last-name,headline),referral-bonus,site-job-url,location-description))?"
                + token +
                "&distance=10&" +
                "job-title=product&" +
                "facets=company,location&" +
                "facet=industry,6&" +
                "facet=company,1288&" +
                "sort=DA&format=json");
        showRequest(url2);
        int listCount = 0;
        URL url;

        for (int i = 0; i <100; i++) {
            listCount = i;
            start = "&start=" + listCount;
            url = new URL("https://api.linkedin.com/v1/job-search:(jobs:(id,company,position))?" + token + title + count + start + facet + format);
//        URL url = new URL("https://api.linkedin.com/v1/job-search?" + token + title + count + start + country + facet + format);
//        URL url = new URL("https://api.linkedin.com/v1/jobs/74331664:(company,position,skills-and-experience,description-snippet,salary)?" + token + format);
//        URL url = new URL("https://api.hh.ru/vacancies?text=Java+Developer&period=30&area=2&per_page=469");
            showRequest(url);

        }
        start = "&start=10";
        url = new URL("https://api.linkedin.com/v1/job-search:(jobs:(id,company,position))?" + token + title + count + start + facet + format);
        showRequest(url);

        start = "&start=20";
        url = new URL("https://api.linkedin.com/v1/job-search:(jobs:(id,company,position))?" + token + title + count + start + facet + format);
        showRequest(url);

        start = "&start=30";
        url = new URL("https://api.linkedin.com/v1/job-search:(jobs:(id,company,position))?" + token + title + count + start + facet + format);
        showRequest(url);


        start = "&start=40";
        url = new URL("https://api.linkedin.com/v1/job-search:(jobs:(id,company,position))?" + token + title + count + start + facet + format);
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


/*
C:\JAVA\32\jdk1.8.0_31\bin\java -Didea.launcher.port=7546 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.1.4\bin" -Dfile.encoding=UTF-8 -classpath "C:\JAVA\32\jdk1.8.0_31\jre\lib\charsets.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\deploy.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\javaws.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\jce.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\jfr.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\jfxswt.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\jsse.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\management-agent.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\plugin.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\resources.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\rt.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\ext\access-bridge-32.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\ext\cldrdata.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\ext\dnsns.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\ext\jaccess.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\ext\jfxrt.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\ext\localedata.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\ext\nashorn.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\ext\sunec.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\ext\sunjce_provider.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\ext\sunmscapi.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\ext\sunpkcs11.jar;C:\JAVA\32\jdk1.8.0_31\jre\lib\ext\zipfs.jar;C:\IdeaProjects\HHParser\target\classes;C:\Users\v.pozdeev\.m2\repository\org\mongodb\mongodb-driver\3.0.2\mongodb-driver-3.0.2.jar;C:\Users\v.pozdeev\.m2\repository\org\mongodb\bson\3.0.2\bson-3.0.2.jar;C:\Users\v.pozdeev\.m2\repository\org\mongodb\mongodb-driver-core\3.0.2\mongodb-driver-core-3.0.2.jar;C:\Users\v.pozdeev\.m2\repository\org\freemarker\freemarker\2.3.19\freemarker-2.3.19.jar;C:\Users\v.pozdeev\.m2\repository\com\sparkjava\spark-core\1.1.1\spark-core-1.1.1.jar;C:\Users\v.pozdeev\.m2\repository\org\slf4j\slf4j-api\1.7.2\slf4j-api-1.7.2.jar;C:\Users\v.pozdeev\.m2\repository\org\eclipse\jetty\jetty-server\9.0.2.v20130417\jetty-server-9.0.2.v20130417.jar;C:\Users\v.pozdeev\.m2\repository\org\eclipse\jetty\orbit\javax.servlet\3.0.0.v201112011016\javax.servlet-3.0.0.v201112011016.jar;C:\Users\v.pozdeev\.m2\repository\org\eclipse\jetty\jetty-http\9.0.2.v20130417\jetty-http-9.0.2.v20130417.jar;C:\Users\v.pozdeev\.m2\repository\org\eclipse\jetty\jetty-util\9.0.2.v20130417\jetty-util-9.0.2.v20130417.jar;C:\Users\v.pozdeev\.m2\repository\org\eclipse\jetty\jetty-io\9.0.2.v20130417\jetty-io-9.0.2.v20130417.jar;C:\Users\v.pozdeev\.m2\repository\org\eclipse\jetty\jetty-webapp\9.0.2.v20130417\jetty-webapp-9.0.2.v20130417.jar;C:\Users\v.pozdeev\.m2\repository\org\eclipse\jetty\jetty-xml\9.0.2.v20130417\jetty-xml-9.0.2.v20130417.jar;C:\Users\v.pozdeev\.m2\repository\org\eclipse\jetty\jetty-servlet\9.0.2.v20130417\jetty-servlet-9.0.2.v20130417.jar;C:\Users\v.pozdeev\.m2\repository\org\eclipse\jetty\jetty-security\9.0.2.v20130417\jetty-security-9.0.2.v20130417.jar;C:\Users\v.pozdeev\.m2\repository\oauth\signpost\signpost-core\1.2.1.1\signpost-core-1.2.1.1.jar;C:\Users\v.pozdeev\.m2\repository\commons-codec\commons-codec\1.3\commons-codec-1.3.jar;C:\Users\v.pozdeev\.m2\repository\com\googlecode\linkedin-j\linkedin-j-examples\1.0.416\linkedin-j-examples-1.0.416.jar;C:\Users\v.pozdeev\.m2\repository\com\googlecode\linkedin-j\linkedin-j-core\1.0.416\linkedin-j-core-1.0.416.jar;C:\Users\v.pozdeev\.m2\repository\commons-cli\commons-cli\1.2\commons-cli-1.2.jar;C:\Users\v.pozdeev\.m2\repository\net\sf\kxml\kxml2\2.3.0\kxml2-2.3.0.jar;C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.1.4\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain mongodb.TestDrive
{
  },
      "jobPoster": {
        "firstName": "Ariadna",
        "headline": "Research & Recruitment | IT Jobs | IT Opportunities",
        "id": "6ho99EnYxA",
        "lastName": "P."
      },
      "jobPoster": {
        "firstName": "Lamia",
        "headline": "Executive Facilitation & Business Support Professional",
        "id": "G5qp2uW2YJ",
        "lastName": "M."
      },
      "jobPoster": {
        "firstName": "Oksana",
        "headline": "HR Business Partner at NetCracker",
        "id": "IYSRFtm3ly",
        "lastName": "Khomina"
      },
      "jobPoster": {
        "firstName": "Russ",
        "headline": "VP, Talent Management & Human Resources at Stibo Systems",
        "id": "ZWoFwNpSbj",
        "lastName": "S."
      },


        "jobPoster": {
          "firstName": "Ariadna",
          "headline": "Research & Recruitment | IT Jobs | IT Opportunities",
          "id": "6ho99EnYxA",
          "lastName": "P."
        },
        "jobPoster": {
          "firstName": "Lamia",
          "headline": "Executive Facilitation & Business Support Professional",
          "id": "G5qp2uW2YJ",
          "lastName": "M."
        },
        "jobPoster": {
          "firstName": "Oksana",
          "headline": "HR Business Partner at NetCracker",
          "id": "IYSRFtm3ly",
          "lastName": "Khomina"
        },
        "jobPoster": {
          "firstName": "Russ",
          "headline": "VP, Talent Management & Human Resources at Stibo Systems",
          "id": "ZWoFwNpSbj",
          "lastName": "S."
        },
*/