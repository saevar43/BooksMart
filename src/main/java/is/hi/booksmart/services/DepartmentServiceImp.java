package is.hi.booksmart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import is.hi.booksmart.model.Department;
import is.hi.booksmart.repositories.DepartmentRepository;

/**
 * 
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @date 4.október 2017
 * HBV501G Software Development 1
 *  
 */

@Service
public class DepartmentServiceImp implements DepartmentService {
	
	// Connection to DepartmentRepository
	@Autowired
	DepartmentRepository depRep;
	
	@Override
	public List<Department> allDepartments() {
		return depRep.findAll();
	}
	
	@Override
	public Department save(Department dept) {
		return depRep.save(dept);
	}
}
