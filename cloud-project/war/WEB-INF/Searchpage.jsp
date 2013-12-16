<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
	<form method="post" action="/searchpage" class="form-inline" role="search">
		<input type="text" name="searchinput" size="100" class="form-control" placeholder="Author, title or ISBN..."/>
		Search by:
		<select name="bookcategories">
			<option value="ISBN">isbn</option>
			<option value="Author">author</option>
			<option value="Titre">titre</option>
		</select>
		<input type="submit" value="Search Book" class="btn btn-primary btn-lg"/>
	</form>
</t:wrapper>