package findr.data;

import findr.Vacancy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by v.pozdeev on 29.10.2015.
 */
@Component
public class VacancyRepositoryImpl implements VacancyRepository {

    @Override
    public List<Vacancy> findVacancies(String title, String country) {
        return null;
    }

}
