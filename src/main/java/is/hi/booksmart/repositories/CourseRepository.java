package is.hi.booksmart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.booksmart.model.Course;

/**
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 * @date October 2017
 * HBV501G Software Development 1
 * 
 * Repository for the Course model
 */

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	/**
	 * Gets all courses
	 * 
	 * @return List of courses
	 */
	List<Course> findAll();
	
	/**
	 * Add course to database
	 * 
	 * @param course
	 */
	Course save(Course course);
	
	/**
	 * Find courses by Department
	 * 
	 * @param depId
	 * @return List of courses in a department.
	 */
	List<Course> findByDepartment(long depId);
}
