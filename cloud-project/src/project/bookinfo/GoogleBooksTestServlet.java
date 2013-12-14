package project.bookinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoogleBooksTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		GoogleBooks books = null;
		BookInfo bookInfo = null;
		try {
			books = new GoogleBooks();
			bookInfo = books.query("isbn:1551923963");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("bookinfo", bookInfo);
		
		// Forward to the jsp
		getServletContext().getRequestDispatcher(
				"/WEB-INF/google-books-test.jsp").forward(req, resp);
	}

}