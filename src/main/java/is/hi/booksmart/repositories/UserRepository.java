package is.hi.booksmart.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import is.hi.booksmart.model.Book;
import is.hi.booksmart.model.User;

/**
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 * @date October 2017
 * HBV501G Software Development 1
 * 
 * Repository for the User model
 */
public interface UserRepository extends JpaRepository<User, Long> {
	 
	/**
	 * Gets all Users
	 * 
	 * @return list of users
	 */
	List<User> findAll();
	
	/**
	 * Add user to repository
	 * 
	 * @param user
	 */
	User save (User user);
	
	/**
	 * Find user by username
	 * 
	 * @param username
	 * @return User with username.
	 */
	@Query(value = "SELECT u FROM User u WHERE u.username=:username)")
	User getUserbyUsername(@Param("username")String username);
	
	/**
	 * Find user by email
	 * 
	 * @param email
	 * @return User with email.
	 */
	@Query(value = "SELECT u FROM User u WHERE u.email=:email")
	User getUserByEmail(@Param("email")String email);
	
}
