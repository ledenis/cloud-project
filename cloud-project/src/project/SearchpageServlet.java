package project;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import project.bookinfo.BookInfo;
import project.bookinfo.UserLibrary;
import project.bookinfo.search.GoogleBooks;

@SuppressWarnings("serial")
public class SearchpageServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException
	{
		getServletContext().getRequestDispatcher("/WEB-INF/Searchpage.jsp").forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException
	{
		String apirequest = "";
		GoogleBooks books = null;
		List<BookInfo> bookInfos = null;
		resp.setContentType("text/plain");
		
		switch(req.getParameter("bookcategories"))
		{
		case "ISBN":apirequest = "isbn:"+req.getParameter("searchinput"); 
					break;
		case "Author":apirequest = "inauthor:"+req.getParameter("searchinput");
					break;
		case "Titre":apirequest = "intitle:"+req.getParameter("searchinput");
					break;
		default: resp.getWriter().println("Error"); break;
		}
		
		if(!apirequest.equals(""))
		{
			// Fix "Cannot determine user location..."?
			apirequest += "&country=US";
			resp.getWriter().println("apirequest: " + apirequest);
			
			try 
			{
				books = new GoogleBooks();
				bookInfos = books.query2(apirequest);
			} 
			catch (Exception e) 
			{
				e.printStackTrace(System.out);
				return;
			}
		}
		
		req.setAttribute("bookinfos", bookInfos);
		
		// Bookshelves
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        
        UserLibrary ul = new UserLibrary(user);
        ul.retrieveInfos();
		req.setAttribute("bookshelves", ul.getBookshelves());
		
		// Forward to the jsp
		getServletContext().getRequestDispatcher("/WEB-INF/resultsearch.jsp").forward(req, resp);
		
	}
}

