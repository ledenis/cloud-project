<%@ page import="project.bookinfo.Bookshelf" %>
<%@ page import="project.bookinfo.UserLibrary" %>
<%@ page import="project.bookinfo.BookInfo" %>

Title: ${bookinfo.title} <br />
Author: ${bookinfo.authors[0]} <br />
Publisher: ${bookinfo.publisher} <br />
Description: ${bookinfo.description} <br />
Rating: ${bookinfo.googleRating} (${bookinfo.googleRatingsCount} reviews) <br />
ISBN: ${bookinfo.isbn} <br>


Shelves:
<% 
UserLibrary user = (UserLibrary) request.getAttribute("user");
for(Bookshelf s : user.getBookshelves()) { %>
	name: <%= s.getName() %> <br>
	books:
	<% for(BookInfo b : s.getBooks()) { %>
		<%= b.getTitle() %> <br>
	<% } %>
<% } %>
