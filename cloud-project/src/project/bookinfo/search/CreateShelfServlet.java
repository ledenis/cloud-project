package project.bookinfo.search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.bookinfo.UserLibrary;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class CreateShelfServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String name = req.getParameter("bookcategories");
		
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        
        UserLibrary ul = new UserLibrary(user);
        ul.createBS(name);
        
        req.setAttribute("name", name);
        // Forward to the jsp
        getServletContext().getRequestDispatcher("/WEB-INF/createdShelf.jsp").forward(req, resp);
        
	}

}
