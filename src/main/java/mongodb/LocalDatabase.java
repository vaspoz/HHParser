package mongodb;

import org.bson.Document;

import java.util.List;

public class LocalDatabase {

    private HeadHunterAPI hhAPI;
    private Mongo vacancies;


    public LocalDatabase() {

        vacancies = Mongo.initiateDB("collectedVacancies");
        hhAPI = HeadHunterAPI.createConnection();

    }


    public void collectDBfor(String title, String country) {

        hhAPI.getVacanciesAndSave(vacancies, title, country);

    }


    public List<Document> getCollectedVacancies() {

        return vacancies.returnAll();

    }


}
