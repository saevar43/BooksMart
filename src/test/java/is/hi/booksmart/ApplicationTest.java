package is.hi.booksmart;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// Athugið vel að þessi import séu rétt 
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.hamcrest.Matchers.containsString;
/**
 *
 * @author Suzanna Sofía
 * @date nóvember 2017 
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 * 
 * Prófunarklasi sem framkvæmir prófanir án þess að þurfa að kalla á þjóninn 
*/

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc       // Spring MockMvc - allt "context"-ið keyrt upp 
public class ApplicationTest {
    
        // Tomcat server ekki keyrður upp
        @Autowired
        private MockMvc mockMvc;
         
        /**
         * Aðferð til að athuga hvort virkar að senda HttpRequest á /app/
         * og fá til baka að nafnið á view fyrir /app/ sé "app/search".
         */
	@Test 
       	public void appReturnsSearch() throws Exception {
        this.mockMvc.perform(get("/app/"))                
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("app/search"));

    }

}
