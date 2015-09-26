package mongodb;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class LocalDatabase {

    private HeadHunterAPI hhAPI;


    public LocalDatabase() {

        hhAPI = HeadHunterAPI.createConnection();

    }


    public List<Document> getVacanciesFor(String title, String country) {

        return hhAPI.getVacancies(title, country);

    }


}
