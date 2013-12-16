package project.bookinfo.search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.appengine.api.users.User;
//import com.google.appengine.api.users.UserService;
//import com.google.appengine.api.users.UserServiceFactory;

//import project.bookinfo.BookInfo;

public class GoogleBooksTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
			GoogleBooks books = null;
			BookInfo bookInfo = null;*/

			// Constructs query
			String query = req.getParameter("q");
			if (query == null) {
				resp.getWriter().println(
						"No 'q' parameter found (?q=isbn:1551923963)<br/><br/>");
				query = "isbn:1551923963";
			}

			/*try {
				books = new GoogleBooks();
				bookInfo = books.query(query);
			} catch (Exception e) {
				e.printStackTrace(System.out);
				return;
			}

			req.setAttribute("bookinfo", bookInfo);
			
			UserLibrary u = new UserLibrary(user);
			req.setAttribute("user", u);
			
		*/
		
		
		// Forward to the jsp
		getServletContext().getRequestDispatcher(
				"/WEB-INF/google-books-test.jsp").forward(req, resp);
	}

}
