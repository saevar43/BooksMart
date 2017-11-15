package is.hi.booksmart.services;

import java.util.List;

import is.hi.booksmart.model.Department;

/**
 * 
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @date 4.október 2017
 * HBV501G Software Development 1
 *  
 */

public interface DepartmentService {

	/**
	 * Gets all departments in DepartmentRepository
	 * 
	 * @return List of departments
	 */
	public List<Department> allDepartments();
	
	/**
	 * Save a book to the repository
	 * 
	 * @param dept
	 * @return
	 */
	public Department save(Department dept);
}
