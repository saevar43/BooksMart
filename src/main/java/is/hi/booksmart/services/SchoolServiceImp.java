package is.hi.booksmart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import is.hi.booksmart.model.School;
import is.hi.booksmart.repositories.SchoolRepository;

/**
 * 
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @date 4.október 2017
 * HBV501G Software Development 1
 *  
 */

@Service
public class SchoolServiceImp implements SchoolService {
	
	//Connection to a list of schools
	@Autowired
	SchoolRepository schoolRep;
	
	@Override 
	public List<School> allSchools() {
		return schoolRep.findAll();
	}
	
	@Override
	public School save(School school) {
		return schoolRep.save(school);
	}
}
