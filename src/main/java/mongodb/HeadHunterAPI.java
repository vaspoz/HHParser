package mongodb;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

/**
 * Created by Василий on 26.09.2015.
 */
public class HeadHunterAPI {

    private static final Logger log = LoggerFactory.getLogger(HeadHunterAPI.class);

    private Mongo hhVacancies;

    private HeadHunterAPI() {
        hhVacancies = Mongo.initiateDB("headhunter");
    }


    public static HeadHunterAPI createConnection() {

        return new HeadHunterAPI();

    }


    public void getVacanciesAndSave(Mongo mainDatabase, String title, String country) {

        HttpURLConnection httpCon = prepareConnection(title, country);
        BufferedReader reader = new BufferedReader(new InputStreamReader(getStreamFrom(httpCon)));
        String line;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new AssertionError("Could not read from stream!");
        }

        Document document = Document.parse(line);
        hhVacancies.insertDocument(document);
        hhVacancies.processAndSave(mainDatabase);

    }


    private HttpURLConnection prepareConnection(String title, String country) {

        HttpURLConnection connection;

        try {
            URL url = new URL(getRequestString(title, country));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
        } catch (MalformedURLException mue) {
            log.error(mue.getMessage());
            return null;
        } catch (ProtocolException pe) {
            log.error(pe.getMessage());
            return null;
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
            return null;
        }

        return connection;

    }


    private String getRequestString(String title, String country) {

        String[] titleSplitted = title.split(" ");
        String area = "";
        switch (country) {
            case "Russia":
                area = "&area=2";
                break;
        }
        String connectionString = "https://api.hh.ru/vacancies?text=" +
                titleSplitted[0] + "+" + titleSplitted[1] +
                area + "&period=30&per_page=469";

        return connectionString;
    }


    private InputStream getStreamFrom(HttpURLConnection connection) {
        try {
            return connection.getInputStream();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new AssertionError("Error occurred during opening input stream from http-connection.");
        }
    }
}
