package is.hi.booksmart.services;

import java.util.List;

import is.hi.booksmart.model.Book;
import is.hi.booksmart.model.User;

/**
 * 
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @date 4.október 2017
 * HBV501G Software Development 1
 *  
 */

public interface UserService {

	/**
	 * Gets all Users in UserRepository
	 * 
	 * @return list of Users
	 */
	public List<User> allUsers();
	
	/**
	 * Save a user into the repository
	 * 
	 * @param book
	 * @return
	 */
	public User save(User book);
	
	/**
	 * Return User with username
	 * 
	 * @param username
	 * @return
	 */
	public User getUserbyUsername(String username);
	
	/**
	 * Return User with email
	 * 
	 * @param email
	 * @return
	 */
	public User getUserByEmail(String email);
}
