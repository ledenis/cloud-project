package project.bookinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String bookShelfName = req.getParameter("bookshelf");

		// add to datastore
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		UserLibrary library = new UserLibrary(user);
		library.retrieveInfos();
		
		boolean found = false;
		for (Bookshelf shelf : library.getBookshelves()) {
			// if bookshelf found
			if (bookShelfName.equals(shelf.getName())) {
				found = true;
				shelf.createBook(req.getParameter("isbn"));
				break;
			}
		}
		
		req.setAttribute("success", found);

		// Forward to the jsp
		getServletContext().getRequestDispatcher("/WEB-INF/bookAdded.jsp")
				.forward(req, resp);
	}

}
