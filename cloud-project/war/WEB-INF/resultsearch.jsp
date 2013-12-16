<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="java.util.List" %>
<%@ page import="project.bookinfo.BookInfo" %>

<t:wrapper>

<table class="table table-condensed">
<tr>
<th>Title</th>
<th>Author</th>
<th>Add</th>
</tr>
<c:forEach var="bookinfo" items="${bookinfos}" varStatus="counter">

<tr>
<td>${bookinfo.title}</td>
<td>${bookinfo.authors[0]}</td>

<td>
<div class="form-group">
			<select class="form-control" name="bookcategories">
				<c:forEach var="shelf" items="${bookshelves}">
				<option value="${shelf.name}">${shelf.name}</option>
				</c:forEach>
			</select>		
		</div>
		<div class="form-group">
			<input type="submit" value="Add" class="btn btn-primary"/>
		</div>
</td>
</tr>

</c:forEach>

</table>

</t:wrapper>