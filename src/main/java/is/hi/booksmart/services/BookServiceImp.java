package is.hi.booksmart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import is.hi.booksmart.model.Book;
import is.hi.booksmart.repositories.BookRepository;

/**
 * 
 * @author Kári Geir Gunnarsson 	<kgg5@hi.is>
 * @date 4.október 2017
 * HBV501G Software Development 1
 *  
 */

@Service
public class BookServiceImp implements BookService {

	// Connection to repository of Books.
	@Autowired
	BookRepository bookRep;
	
	@Override
	public List<Book> allBooks() {
		return bookRep.findAll();
	}

	@Override
	public Book save(Book book) {
		return bookRep.save(book);
	}
	@Override
	public void delete(Book book) {
			bookRep.delete(book);
	}
	@Override
	public Book bookById(long id) {
	 	return bookRep.findById(id);
	}
	@Override
	public List<Book> booksByTitle(String title) {
		return bookRep.findByTitle(title);
	}
	
	@Override
	public List<Book> booksByEdition(int edition) {
		return bookRep.findByEdition(edition);
	}
	
	@Override
	public List<Book> booksByAuthor(String author) {
		return bookRep.findByAuthor(author);
	}
	
	@Override 
	public List<Book> booksByTitleEditionAuthor(String title, int edition, String author) {
		return bookRep.findByTitleEditionAuthor(title, edition, author);
	}
	
	@Override 
	public List<Book> booksByTitleEdition(String title, int edition) {
		return bookRep.findByTitleEdition(title, edition);
	}
	
	@Override 
	public List<Book> booksByTitleAuthor(String title, String author) {
		return bookRep.findByTitleAuthor(title, author);
	}
	
	@Override 
	public List<Book> booksByAuthorEdition(String author, int edition) {
		return bookRep.findByAuthorEdition(author, edition);
	}
	
	@Override
	public boolean isAlive() {
		return true;
	}

	@Override
	public List<Book> booksByEmail(String user_contact) {
		return bookRep.findByEmail(user_contact);
	}
}
