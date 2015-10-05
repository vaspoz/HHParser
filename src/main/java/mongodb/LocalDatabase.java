package mongodb;

import org.bson.Document;

import java.util.List;

public class LocalDatabase {

    private HeadHunterAPI hhAPI;
    private Mongo vacancies;


    public LocalDatabase() {

        vacancies = Mongo.initiateDB("vacancies");
        hhAPI = HeadHunterAPI.createConnection();

    }


    public void collectDBfor(String title, String country) {

        hhAPI.getVacanciesAndSave(vacancies, title, country);

    }


    @Deprecated
    public void clearDatabases() {

        vacancies.clearDBase();
        hhAPI.clearDBase();

    }


    public List<Document> getCollectedVacancies() {

        return vacancies.returnAll();

    }


}
