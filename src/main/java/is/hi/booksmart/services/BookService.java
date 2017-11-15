package is.hi.booksmart.services;

import java.util.List;
import is.hi.booksmart.model.Book;

/**
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 * @date October 2017
 * HBV501G Software Development 1
 */

public interface BookService {
	
	/**
	 * Gets all books in BookRpository
	 * 
	 * @return list of Books
	 */
	public List<Book> allBooks();
	
	/**
	 * Save a book into the repository
	 * 
	 * @param book
	 * @return
	 */
	public Book save(Book book);
	
	/**
	 * Delete a book from the repository
	 * 
	 * @param book
	 * @return
	 */
	public void delete(Book book);
	 	
	/**
	 * Return a book corresponding to ID.
	 * 
	 * @param id
	 * @return A book with id = id. 
	 */
	public Book bookById(long id);	
	
	
	
	/**
	 * Return a list of books with a title
	 * 
	 * @param title
	 * @return List of Books with title "title"
	 */
	public List<Book> booksByTitle(String title);
	
	/**
	 * Return a list of books of given edition
	 * 
	 * @param edition
	 * @return List of books of given edition
	 */
	public List<Book> booksByEdition(int edition);
	
	/**
	 * Return a list of books written by author
	 * 
	 * @param author
	 * @return List of books wirtten by author
	 */
	public List<Book> booksByAuthor(String author);
	
	/**
	 * Return a list of books by title, edition and author.
	 * 
	 * @param title
	 * @param edition
	 * @param author
	 * @return List of books.
	 */
	public List<Book> booksByTitleEditionAuthor(String title, int edition, String author);
	
	/**
	 * Return a list of books by title and edition.
	 * 
	 * @param title
	 * @param edition
	 * @return List of books.
	 */
	public List<Book> booksByTitleEdition(String title, int edition);
	
	/**
	 * Return a list of books by title and author.
	 * 
	 * @param title
	 * @param author
	 * @return List of books.
	 */
	public List<Book> booksByTitleAuthor(String title, String author);
	
	/**
	 * Return a list of books by author and edition.
	 * 
	 * @param author
	 * @param edition
	 * @return List of books.
	 */
	public List<Book> booksByAuthorEdition(String author, int edition);
	
	/**
	 * For testing
	 * 
	 */
	public boolean isAlive();
	
	/**
	 * Return a list of books by email.
	 * 
	 * @param user_contact
	 * @return
	 */
	public List<Book> booksByEmail(String user_contact);
}
