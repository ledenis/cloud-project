<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
	<form method="post" action="/createShelf" class="form-inline" role="search">
		<div class="form-group">
			<label>Search by:</label>
			<select class="form-control" name="bookcategories">
				<option value="ISBN">isbn</option>
				<option value="Author">author</option>
				<option value="Titre">titre</option>
			</select>
		</div>
		<div class="form-group">
			<input type="submit" value="Create Shelf" class="btn btn-primary btn-lg"/>
		</div>
	</form>
</t:wrapper>
