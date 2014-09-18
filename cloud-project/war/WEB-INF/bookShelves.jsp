<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="java.util.List" %>
<%@ page import="project.bookinfo.BookInfo" %>

<t:wrapper>
<c:forEach var="shelf" items="${bookshelves}">
	<h2>${shelf.name} 
	<form method="post" action="/deleteShelf" class="form-inline">
		<div class="form-group">
			<input type="hidden" name="bookshelf" value="${shelf.name}" />
			<input type="submit" value="Delete" class="btn btn-danger"/>
		</div>
	</form>
	</h2>
	<table class="table table-condensed">
	<tr>
	<th>ISBN</th>
	<th>Title</th>
	<th>Author</th>
	</tr>
	<c:forEach var="book" items="${shelf.books}">
		<tr>
		<td>${book.isbn}</td>		
		<td>${book.title}</td>
		<td>${book.authors[0]}</td>
		</tr>
	</c:forEach>
	
	
	</table>

</c:forEach>
</t:wrapper>