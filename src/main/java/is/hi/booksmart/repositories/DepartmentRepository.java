package is.hi.booksmart.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import is.hi.booksmart.model.Department;

/**
 * 
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @date 4.október 2017
 * HBV501G Software Development 1
 * 
 * Repository for the Department model
 * 
 */

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	/**
	 * Gets all departments
	 * 
	 * @return List of Departments.
	 */
	List<Department> findAll();
	
	/**
	 * Add department to database.
	 * 
	 * @param dept
	 */
	Department save(Department dept);
}
