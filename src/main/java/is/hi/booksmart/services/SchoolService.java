package is.hi.booksmart.services;

import java.util.List;

/**
 * 
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @date 4.október 2017
 * HBV501G Software Development 1
 *  
 */

import is.hi.booksmart.model.School;

/**
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 * @date October 2017
 * HBV501G Software Development 1
 */

public interface SchoolService {
	
	/**
	 * Gets all schools in SchoolRepository
	 * 
	 * @return list of courses
	 */
	public List<School> allSchools();
	
	/**
	 * Save a school into the repository
	 * 
	 * @param school
	 * @return
	 */
	public School save(School school);
}
