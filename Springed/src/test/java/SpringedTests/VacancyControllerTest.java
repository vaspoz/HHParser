package SpringedTests;

import findr.Vacancy;
import findr.data.VacancyRepository;
import findr.web.SearcherController;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by v.pozdeev on 28.10.2015.
 */
public class VacancyControllerTest {

    @Test
<<<<<<< HEAD
    public void shouldShowVacancyByID() throws Exception {

        Vacancy expectedVacancy = new Vacancy("DevOps", "Australia");
        VacancyRepository mockRepository = mock(VacancyRepository.class);
        when(mockRepository.findOne(11135)).thenReturn(expectedVacancy);

        VacancyController controller = new VacancyController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/vacancies/show")
                            .param("vacancy_id", "11135"))
                .andExpect(view().name("vacancy"))
                .andExpect(model().attribute("vacancy", expectedVacancy));

    }

    @Test
    public void shouldShowRecentVacancies() throws Exception {

        List<Vacancy> expectedVacancies = createVacancyList(20);
        VacancyRepository mockRepository =
                mock(VacancyRepository.class);
        when(mockRepository.findVacancies("Vacancy", "Country", 20))
                .thenReturn(expectedVacancies);
=======
    public void searchHome() throws Exception{
>>>>>>> origin/master

        SearcherController controller = new SearcherController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/search"))
                .andExpect(view().name("search-start"));

    }


    @Test
    public void search() throws Exception {

        List<Vacancy> expectedVacancies = createVacancyList(46);
        VacancyRepository mockRepository = mock(VacancyRepository.class);
        when(mockRepository.findVacancies("Java", "Antwerpen"))
                .thenReturn(expectedVacancies);

        SearcherController controller = new SearcherController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/search")
                .contentType(MediaType.ALL)
                .param("title", "Java")
                .param("country", "Antwerpen"))
                .andExpect(redirectedUrl("/vacancies?title=Java&country=Antwerpen"))
                .andExpect(model().attribute("title", "Java"))
                .andExpect(model().attribute("country", "Antwerpen"));

    }


    private List<Vacancy> createVacancyList(int count) {

        List<Vacancy> vacancies = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            vacancies.add(new Vacancy("Vacancy " + i, "Country #" + i));
        }
        return vacancies;

    }
}
