package project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.bookinfo.UserLibrary;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class BookShelvesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		UserLibrary library = new UserLibrary(user);
		library.retrieveInfos();

		req.setAttribute("bookshelves", library.getBookshelves());
		
		// Forward to the jsp
		getServletContext().getRequestDispatcher("/WEB-INF/bookShelves.jsp")
				.forward(req, resp);
	}

}
