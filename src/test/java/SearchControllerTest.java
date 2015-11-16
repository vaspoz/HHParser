import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import springed.controllers.SearchController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by v.pozdeev on 16.11.2015.
 */
public class SearchControllerTest {

    @Test
    public void searchForm() throws Exception {

        SearchController controller = new SearchController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(view().name("searchForm"))
                .andDo(MockMvcResultHandlers.print())
        ;

    }


    @Test
    public void postTest() throws Exception {

        SearchController controller = new SearchController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/").param("title", "TITLE").param("country", "COUNTRY"))
                .andExpect(view().name("searchForm"))
                .andExpect(model().attribute("title", "374"))
                .andDo(MockMvcResultHandlers.print());


    }

}
