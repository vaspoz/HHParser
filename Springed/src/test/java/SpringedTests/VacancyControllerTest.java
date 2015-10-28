package SpringedTests;

import findr.Vacancy;
import findr.data.VacancyRepository;
import findr.web.VacancyController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by v.pozdeev on 28.10.2015.
 */
public class VacancyControllerTest {


    @Test
    public void shouldShowRecentVacancies() throws Exception {

        List<Vacancy> expectedVacancies = createVacancyList(20);
        VacancyRepository mockRepository =
                mock(VacancyRepository.class);
        when(mockRepository.findVacancies("Vacancy", "Country", 20))
                .thenReturn(expectedVacancies);

        VacancyController controller =
                new VacancyController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/WEB-INF/views/vacancies.jsp"))
                .build();

        mockMvc.perform(get("/vacancies"))
                .andExpect(view().name("vacancies"))
                .andExpect(model().attributeExists("vacancyList"))
                .andExpect(model().attribute("vacancyList",
                        hasItems(expectedVacancies.toArray())));
    }


    @Test
    public void shouldShowPagedVacancies() throws Exception {

        List<Vacancy> expectedVacancies = createVacancyList(50);
        VacancyRepository mockRepository = mock(VacancyRepository.class);
        when(mockRepository.findVacancies("Java", "Russia", 50))
                .thenReturn(expectedVacancies);

        VacancyController controller = new VacancyController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/WEB-INF/views/vacancies.jsp")
                )
                .build();

        mockMvc.perform(get("/vacancies?title=Java&country=Russia&count=50"))
                .andExpect(view().name("vacancies"))
                .andExpect(model().attributeExists("vacancyList"))
                .andExpect(model().attribute("vacancyList",
                        hasItems(expectedVacancies.toArray())));
    }


    @Test
    public void testOneVacancy() throws Exception {

        Vacancy expectedVacancy = new Vacancy("Tester", "Poland");
        VacancyRepository mockRepository = mock(VacancyRepository.class);
        when(mockRepository.findOne(12345)).thenReturn(expectedVacancy);

        VacancyController controller = new VacancyController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/vacancies/12345"))
                .andExpect(view().name("vacancy"))
                .andExpect(model().attributeExists("vacancy"))
                .andExpect(model().attribute("vacancy", expectedVacancy));

    }


    private List<Vacancy> createVacancyList(int count) {

        List<Vacancy> vacancies = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            vacancies.add(new Vacancy("Vacancy " + i, "Country #" + i));
        }
        return vacancies;

    }

}
