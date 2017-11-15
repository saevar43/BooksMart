package is.hi.booksmart;

import is.hi.booksmart.controller.AppController;
import is.hi.booksmart.controller.LoginController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 *
 * @author Suzanna Sofía
 * @date nóvember 2017 
 * HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 * 
 * Prófunarklasi sem athugar hvort SearchController og LoginController keyrir 
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
    
        @Autowired 
        AppController searchController;
        @Autowired 
        LoginController loginController;

        /**
         * Aðferð til að athuga hvort SearchController og LoginController hlutur hefur verið búinn til 
         */
        
	@Test
	public void contextLoads() {
        
                   assertThat(searchController).isNotNull();
                   assertThat(loginController).isNotNull();
                   
	}

}
