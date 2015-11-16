package mongodb.DAO;

import java.util.List;

public interface VacancyService {

    void updateDB();
    List<Vacancy> getVacanciesFor(String title, String country);

}
