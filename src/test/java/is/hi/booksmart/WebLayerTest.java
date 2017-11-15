package is.hi.booksmart;


import is.hi.booksmart.controller.AppController;
import is.hi.booksmart.services.BookService;
import is.hi.booksmart.services.CourseService;
import is.hi.booksmart.services.DepartmentService;
import is.hi.booksmart.services.SchoolService;
import is.hi.booksmart.services.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

// Athugið vel að þessi import séu rétt 
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
/**
 *
 * @author Suzanna Sofía
 * @date nóvember 2017 
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 * 
 * Prófunarklasi sem framkvæmir prófanir á weblayer og notar WebMvcTest 
*/
@RunWith(SpringRunner.class)

/**
 *  Aðeins veflagið er keyrt upp en ekki allur "context"-inn
 *  Getum beðið um að keyra bara upp SearchController klasann 
 */
@WebMvcTest (AppController.class)       
                                            
public class WebLayerTest {
    
        // Þjónninn ekki keyrður upp 
        @Autowired
        private MockMvc mockMvc;
        
        @MockBean
        BookService bookService;
        @MockBean
        SchoolService schoolService;
        @MockBean
        CourseService courseService;
        @MockBean
        DepartmentService deptService;
        @MockBean
        UserService userService;
        /**
         * Aðferð til að athuga hvort virkar að senda HttpRequest á listiKennari
         * og fá til baka listiKennara.html síðuna 
         */
	@Test 
        public void appReturnsSearch() throws Exception {
        this.mockMvc.perform(get("/app/"))                
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("app/search"));
    }

}
