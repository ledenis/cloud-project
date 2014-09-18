package project.bookinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class DeleteBookShelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String bookShelfName = req.getParameter("bookshelf");

		// delete
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		UserLibrary library = new UserLibrary(user);
		library.retrieveInfos();
		
		library.deleteBS(bookShelfName);
		
		req.setAttribute("name", bookShelfName);
		
		// Forward to the jsp
		getServletContext().getRequestDispatcher("/WEB-INF/deletedShelf.jsp")
				.forward(req, resp);
	}

}
