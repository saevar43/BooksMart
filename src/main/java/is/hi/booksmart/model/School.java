package is.hi.booksmart.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Kári Geir Gunnarsson <kgg5@hi.is>
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 * @date 19.september 2017
 * HVB501G Software Development 1
 * 
 * Implements the School type.
 */
@Entity
@Table (name="school")
public class School {
	
	@Id
	@Column (name = "schoolId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String abbrev;
	
	@OneToMany(mappedBy="school", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Department> department = new HashSet<Department>();	
	
	/**
	 * Default constructor.
	 */
	public School() {	
	}
	
	/**
	 * Constructor for School.
	 * 
	 * @param name - Name of School.
	 * @param abbrev - Abbreviation of School name.
	 */
	public School(String name, String abbrev) {
		super();
		this.name = name;
		this.abbrev = abbrev;
	}
	
	/**
	 * Getter for school ID.
	 * 
	 * @return id - id of school.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Getter for school name.
	 * 
	 * @return name - Name of school.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for school name.
	 * 
	 * @param name - Name of school.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for abbreviation of school name.
	 * 
	 * @return abbrev - Abbreviation of school name.
	 */
	public String getAbbrev() {
		return abbrev;
	}

	/**
	 * Setter for abbreviation of school name.
	 * 
	 * @param abbrev - Abbreviation of school name.
	 */
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
	
	/**
	 * A simple toString implementation.
	 * 
	 * @return - School as a string.
	 */
	@Override
	public String toString() {
		return name + ", " + abbrev;
	}
}
