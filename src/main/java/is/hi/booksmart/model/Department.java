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
 * @author Sævar Ingi Sigurðsson	<sis108@hi.is>
 * @date 19.september 2017
 * HBV501G Software Development 1
 * 
 * Implements the Department type.
 */
@Entity
@Table (name="department")
public class Department {
	
	@Id
	@Column (name = "departmentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "schoolId")
	private School school;
	
	@OneToMany(mappedBy="department", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Course> courses = new HashSet<Course>();

	/**
	 * Default constructor.
	 */
	public Department() {
	}
	
	/**
	 * Constructor for Department.
	 * 
	 * @param name - Department name.
	 * @param school - School that Department is associated with.
	 */
	public Department(String name, School school) {
		this.name = name;
		this.school = school;
	}
	
	/**
	 * Getter for id attribute.
	 * 
	 * @return id - Department ID.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Getter for name attribute.
	 * 
	 * @return name - Department name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter for name attribute.
	 * 
	 * @param name - Department name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for school attribute.
	 * 
	 * @return school - School associated with department.
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * Setter for school attribute.
	 * 
	 * @param school - School associated with department.
	 */
	
	public void setSchool(School school) {
		this.school = school;
	}
	
	/**
	 * A simple toString implementation.
	 * 
	 * @return - Department as a string.
	 */
	@Override
	public String toString() {
		return name + ", " + school.getName();
	}
	
}
