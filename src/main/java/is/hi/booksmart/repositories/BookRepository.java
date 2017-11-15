package is.hi.booksmart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import is.hi.booksmart.model.Book;

/**
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 * @date October 2017
 * HBV501G Software Development 1
 * 
 * Repository for the Book model.
 */


public interface BookRepository extends JpaRepository<Book,Long>{
	
	/**
	 * Gets all books
	 * 
	 * @return List of all books
	 */
	List<Book> findAll();
	
	/**
	 * Add book to database
	 * 
	 * @param book
	 */
	Book save (Book book);
	
	/**
 	 * Remove book from database
 	 * 
 	 * @param book
	 */
	void delete (Book book);
	 	
	/**
	 * Find book by ID.
	 * 
	 * @param id
	 * @return A book.
	 */
	Book findById(long id);
	
	/**
	 * Find Book by title
	 * 
	 * @param title
	 * @return List of Books with "title" in title
	 */
	@Query(value = "SELECT p FROM Book p WHERE p.title LIKE CONCAT('%',:title,'%')")
	List<Book> findByTitle(@Param("title")String title);
	
	/**
	 * Find books by edition.
	 * 
	 * @param edition
	 * @return List of books with edition "edition".
	 */
	List<Book> findByEdition(int edition);
	
	/**
	 * Find books by author.
	 * 
	 * @param author
	 * @return List of books written by "author".
	 */
	@Query(value = "SELECT p FROM Book p WHERE p.author LIKE CONCAT('%',:author,'%')")
	List<Book> findByAuthor(@Param("author")String author);
	
	/**
	 * Find Book by title, edition and author
	 * 
	 * @param title
	 * @param edition
	 * @param author
	 * @return List of books with "title, edition and author"
	 */
	@Query(value = "SELECT p FROM Book p WHERE (p.title LIKE CONCAT('%',:title,'%') AND p.edition = :edition AND p.author LIKE CONCAT('%',:author,'%'))")
	List<Book> findByTitleEditionAuthor(@Param("title")String title, @Param("edition")int edition, @Param("author")String author);
	
	/**
	 * Find books by title and edition.
	 * 
	 * @param title
	 * @param edition
	 * @return List of books.
	 */
	@Query(value = "SELECT p FROM Book p WHERE (p.title LIKE CONCAT('%',:title,'%') AND p.edition = :edition)")
	List<Book> findByTitleEdition(@Param("title")String title, @Param("edition")int edition);
	
	/**
	 * Find books by title and author.
	 * 
	 * @param title
	 * @param author
	 * @return List of books.
	 */
	@Query(value = "SELECT p FROM Book p WHERE (p.title LIKE CONCAT('%',:title,'%') AND p.author LIKE CONCAT('%',:author,'%'))")
	List<Book> findByTitleAuthor(@Param("title")String title, @Param("author")String author);
	
	/**
	 * Find books by author and edition.
	 * 
	 * @param author
	 * @param edition
	 * @return List of books.
	 */
	@Query(value = "SELECT p FROM Book p WHERE (p.author LIKE CONCAT('%',:author,'%') AND p.edition = :edition)")
	List<Book> findByAuthorEdition(@Param("author")String author, @Param("edition")int edition);
	
	/**
	 * Find books by user_contact (email).
	 * 
	 * @param author
	 * @param edition
	 * @return List of books.
	 */
	@Query(value = "SELECT u FROM Book u WHERE u.userContact=:user_contact")
	List<Book> findByEmail(@Param("user_contact")String user_contact);
}
