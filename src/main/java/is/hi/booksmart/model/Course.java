package is.hi.booksmart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 * @date 19. september 2017
 * HBV501G Software Development 1
 * 
 * Implements the Course type.
 */
@Entity
@Table (name="course")
public class Course {
	
	@Id
	@Column (name = "courseId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String courseNo;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "departmentId")
	private Department department;

	@OneToMany(mappedBy="course", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Book> books = new HashSet<Book>();
	
	/**
	 * Default constructor.
	 */
	public Course() {
	}
	
	/**
	 * Constructor for course.
	 * 
	 * @param courseNo - Number of Course.
	 * @param name - Name of Course.
	 * @param department - Department that Course is associated with.
	 */
	public Course(String courseNo, String name, Department department) {
		super();
		this.courseNo = courseNo;
		this.name = name;
		this.department = department;
	}
	
	/**
	 * Getter for id attribute.
	 * 
	 * @return id - Course ID.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Getter for number attribute.
	 * 
	 * @return courseNo - Course number.
	 */
	public String getCourseNo() {
		return courseNo;
	}

	/**
	 * Setter for number attribute.
	 * 
	 * @param courseNo - Course number.
	 */
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	/**
	 * Getter for name attribute.
	 * 
	 * @return name - Course name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name attribute.
	 * 
	 * @param name - Course name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for department attribute.
	 * 
	 * @return department - Department associated with course.
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Setter for department attribute.
	 * 
	 * @param department - Department associated with course.
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	/**
	 * A simple toString implementation.
	 * 
	 * @return - Course as a string.
	 */
	@Override
	public String toString() {
		return name + ", " + courseNo + ", " + department.getName();
	}
	
}
