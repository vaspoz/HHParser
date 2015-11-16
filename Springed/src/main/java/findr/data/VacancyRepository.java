package findr.data;

import findr.Vacancy;

import java.util.List;

/**
 * Created by v.pozdeev on 28.10.2015.
 */
public interface VacancyRepository {
    List<Vacancy> findVacancies(String title, String country);
}
