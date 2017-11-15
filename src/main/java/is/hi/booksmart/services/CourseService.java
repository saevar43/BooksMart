package is.hi.booksmart.services;

import java.util.List;

import is.hi.booksmart.model.Course;

/**
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 * @date October 2017
 * HBV501G Software Development 1
 */

public interface CourseService {
	
	/**
	 * Gets all courses in courseRepository
	 * 
	 * @return list of courses
	 */
	public List<Course> allCourses();
	
	/**
	 * Save a course into the repository
	 * 
	 * @param course
	 * @return
	 */
	public Course save(Course course);
	
	/**
	 * Return a list of courses by department
	 * 
	 * @param depId
	 * @return
	 */
	public List<Course> coursesByDepartment(long depId);
}
