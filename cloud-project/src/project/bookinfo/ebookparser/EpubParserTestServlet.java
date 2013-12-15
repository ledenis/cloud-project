package project.bookinfo.ebookparser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.bookinfo.BookInfo;
import project.bookinfo.search.GoogleBooks;

public class EpubParserTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Parsing
//		String query = EpubParser.buildGoogleBooksQuery("alice.epub");
		String query = EpubParser.buildGoogleBooksQuery("sherlock.epub");
		
		if (query == null) {
			System.out.println("Error during parsing");
			return;
		}
		
		System.out.println(query);

		// Google Books
		GoogleBooks books = null;
		BookInfo bookInfo = null;

		try {
			books = new GoogleBooks();
			bookInfo = books.query(query);
			System.out.println(bookInfo.getTitle());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return;
		}

		req.setAttribute("bookinfo", bookInfo);

		// Forward to the jsp
		getServletContext().getRequestDispatcher(
				"/WEB-INF/google-books-test.jsp").forward(req, resp);
	}
}
