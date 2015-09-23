package mongodb;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class LocalDatabase {


    public List<Document> getVacanciesFor(String title, String country) {
        List<Document> vacancies = new ArrayList<>();

        vacancies.add(new Document("title", "A")
                .append("company", "1")
                .append("description", "qwe")
                .append("producer", "hh")
                .append("salary", "100000")
                .append("location", "spb")
        );
        vacancies.add(new Document("title", "Qwass")
                        .append("company", "Main")
                        .append("description", "Great opportunity")
                        .append("producer", "lin")
                        .append("salary", "100000")
                        .append("location", "poland")
        );

        return vacancies;
    }


}
