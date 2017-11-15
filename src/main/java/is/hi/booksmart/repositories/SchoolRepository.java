package is.hi.booksmart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.booksmart.model.School;

/**
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 * @date October 2017
 * HBV501G Software Development 1
 * 
 * Repository for the School model.
 */

public interface SchoolRepository extends JpaRepository<School, Long> {
	
	/**
	 * Gets all schools
	 * 
	 * @return List of schools
	 */
	List<School> findAll();
	
	/**
	 * Add school to database
	 * 
	 * @param school
	 */
	School save(School school);
}
