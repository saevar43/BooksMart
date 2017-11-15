package is.hi.booksmart.controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import is.hi.booksmart.model.Book;
import is.hi.booksmart.model.Department;
import is.hi.booksmart.model.School;
import is.hi.booksmart.model.User;
import is.hi.booksmart.model.Course;
import is.hi.booksmart.services.BookService;
import is.hi.booksmart.services.CourseService;
import is.hi.booksmart.services.DepartmentService;
import is.hi.booksmart.services.SchoolService;
import is.hi.booksmart.services.UserService;

/**
 * @author Sævar Ingi Sigurðsson <sis108@hi.is>
 * @author Kári Geir Gunnarsson <kgg5@hi.is>
 * @date October 2017 HBV501G Software Project 1
 *
 * Controller that dictates what is done when the user or UI sends an instruction.
 **/
@Controller
@RequestMapping("") // Request Mapping so that every site starts with /app. 
public class AppController 	{


	// Connection to service class(es).
	@Autowired
	BookService bookService;
	@Autowired
	SchoolService schoolService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	CourseService courseService;
	@Autowired
	UserService userService;

    /**
     * Display search form.
     *
     * @return String pointing to .jsp file.
     */
    @RequestMapping("")
    public String search(HttpSession session)  {
    	System.out.println(session.getAttribute("myUser"));
    		return "app/search";

    }

    /**
     * Display advanced search form.
     *
     * @param model
     * @return String pointing to .jsp file.
     */
    @RequestMapping("/adv_search")
    public String advSearch() {
    		return "app/advancedSearch";
    }

    /**
     * Display add Book form.
     *
     * @return String pointing to .jsp file.
     */
    @RequestMapping("/add_book")
    public String displayBookForm(HttpSession session) {

    	User user = (User) session.getAttribute("myUser");
    	if (user == null) {
    		return "app/forbidden";
    	}
    		return "app/addBook";
    }

    /**
     * Display createUser page.
     *
     * @return String pointing to .jsp file.
     */
    @RequestMapping("/create_user")
    public String displayUserCreate() {
    		return "app/createUser";
    }


    /**
     * Add book to database.
     *
     * @return String pointing to .jsp file.
     */
    @RequestMapping(value = "/book_confirm", method = RequestMethod.POST)
    public String addBook(HttpSession session,
    						  @RequestParam(value="title", required=true) String title,
    		                  @RequestParam(value="author", required=true) String author,
    		                  @RequestParam(value="edition", required=true) String edition,
    		                  @RequestParam(value="course", required=true) String course,
    		                  @RequestParam(value="department", required=true) String department,
    		                  @RequestParam(value="school", required=true) String school,
    		                  ModelMap model) {

    		User user = (User) session.getAttribute("myUser");

    		if (user == null) {
    			return "app/forbidden";
    		}

    		int e = Integer.parseInt(edition);
    		School s = new School(school, "HÍ");
    		schoolService.save(s);
    		Department d = new Department(department, s);
    		departmentService.save(d);
    		Course c = new Course("ASDF", course, d);
    		courseService.save(c);
    		Book b = new Book(title, author, e, c, user.getEmail());

    		model.addAttribute("book", b);
    		bookService.save(b);

    		return "redirect:/app/userInventory";
    }

    /**
     * Add user to database.
     *
     * @return String pointing to .jsp file.
     */
    @RequestMapping(value = "/user_confirm", method = RequestMethod.POST)
    public String createUser(HttpSession session,
    						  @RequestParam(value="username", required=true) String username,
    		                  @RequestParam(value="email", required=true) String email,
       		                  @RequestParam(value="pw", required=true) String pw,
    		                  ModelMap model) {

    		User user = userService.getUserbyUsername(username);
    		User userEmail = userService.getUserByEmail(email);

    		if (user != null) {
    			model.addAttribute("error", "Username already exists!");

    			return "app/createUser";

    		} else if (userEmail != null) {
    			model.addAttribute("error", "Email is already taken!");

    			return "app/createUser";

    		} else {
	    		User a = new User(username, email, pw);
	    		userService.save(a);
	    		model.addAttribute("user", a);

	    		session.setAttribute("myUser", a);

	    		return "redirect:./";
    		}
    }

    /**
     * Search for books by Title entered into form.
     *
     * @param title
     * @param model
     * @return String pointing to .jsp file.
     */
    @RequestMapping(value="/results", method=RequestMethod.GET)
    public String booksByTitle (@RequestParam(value="title") String title, Model model) {
    		ArrayList<Book> list;
    		list = (ArrayList<Book>) bookService.booksByTitle(title);

    		model.addAttribute("books", list);
    		return "app/displayResults";
    }

    /**
     * Search for books by Title owned by the user logged in.
     *
     * @param title
     * @param model
     * @return
     */
    @RequestMapping(value="/searchMyBooks", method=RequestMethod.GET)
    public String searchBooksOwnedByUser (@RequestParam(value="title") String title, HttpSession session, Model model) {

    		ArrayList<Book> list;
    		list = (ArrayList<Book>) bookService.booksByTitle(title);
    		ArrayList<Book> myList = new ArrayList<Book>();

    		if (list.isEmpty()) {
    			model.addAttribute("books", list);
        		return "app/displayResultsUserBooks";
    		}
    		User user = (User) session.getAttribute("myUser");
    		if (user == null) {
    			return "app/forbidden";
    		}

    		for (Book book : list) {
    			if (book.getUserContact().equals(user.getEmail())) {
    				myList.add(book);
    			}
    		}

    		model.addAttribute("userBooks", myList);
    		return "app/userInventory";
    }

	 /**
	 * Get books by user displayed in his inventory
	 *
	 * Get books by user displayed in his inventory.
	 *
	 * @param session
	 * @param model
	 * @return String pointing to .jsp file.
	 */
    @RequestMapping(value="/userInventory", method=RequestMethod.GET)
    public String booksOwnedByUser (HttpSession session, Model model) {

    		ArrayList<Book> list;

    		User user = (User) session.getAttribute("myUser");

    		if (user == null) {
    			return "app/forbidden";
    		}

    		list = (ArrayList<Book>) bookService.booksByEmail(user.getEmail());

    		model.addAttribute("userBooks", list);
    		return "app/userInventory";
    }

    /**
     * Delete book from database.
     *
     * @param session
     * @param model
     * @param id
     * @return String pointing to .jsp file.
     */
    @RequestMapping(value="/deletion", method=RequestMethod.GET)
    public String deleteBook (HttpSession session, Model model,
    						   @RequestParam(value="book_id") String id) {

    		ArrayList<Book> list;
    		User user = (User) session.getAttribute("myUser");

    		if (user == null) {
    			return "app/forbidden";
    		}

    		long idNo = Long.parseLong(id);
        	System.out.println(user.getEmail() + " " + idNo);

        	model.addAttribute("user", user.getEmail());

        	Book book = bookService.bookById(idNo);
        	bookService.delete(book);

        	list = (ArrayList<Book>) bookService.booksByEmail(user.getEmail());

        	model.addAttribute("userBooks", list);
        	return "app/userInventory";
        }

     /**
     * Use advanced search.
     *
     * @param title
     * @param edition
     * @param author
     * @param model
     * @return String pointing to .jsp file.
     */
    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String advSearch (@RequestParam(value="title", required=false) String title,
    		                     @RequestParam(value="edition", required=false) String edition,
    		                     @RequestParam(value="author", required=false) String author, Model model) {
    		System.out.println(title + ", " + edition + ", " + author);
    		ArrayList<Book> list;
    		String nullStr = "";

    		int ed;
    		if (edition == nullStr) ed = 0;
    		else ed = Integer.parseInt(edition);

    		if (title != nullStr && ed != 0 && author != nullStr) {
    			list = (ArrayList<Book>) bookService.booksByTitleEditionAuthor(title, ed, author);
    		} else if (title != nullStr && ed != 0) {
    			list = (ArrayList<Book>) bookService.booksByTitleEdition(title, ed);
    		} else if (title != nullStr && author != nullStr) {
    			list = (ArrayList<Book>) bookService.booksByTitleAuthor(title, author);
    		} else if (author != nullStr && ed != 0) {
    			list = (ArrayList<Book>) bookService.booksByAuthorEdition(author, ed);
    		} else if (title != nullStr) {
    			list = (ArrayList<Book>) bookService.booksByTitle(title);
    		} else if (ed != 0) {
    			list = (ArrayList<Book>) bookService.booksByEdition(ed);
    		} else if (author != nullStr) {
    			list = (ArrayList<Book>) bookService.booksByAuthor(author);
    		} else {
    			list = (ArrayList<Book>) bookService.allBooks();
    		}


    		model.addAttribute("books", list);
    		return "app/displayResults";
    }

    /**
     * Test function (Useless).
     *
     * @param model
     * @return String pointing to .jsp file.
     */
	@RequestMapping(value = "/lifir", method = RequestMethod.GET)
	public String lifir(Model model) {
		if (bookService.isAlive()) {
			return "app/search";
		} else {
			return "app/login";
		}
	}
}
