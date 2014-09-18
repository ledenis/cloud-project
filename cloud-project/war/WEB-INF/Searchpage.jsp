<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
	<form method="post" action="/searchpage" class="form-inline" role="search">
		<div class="form-group">
			<input type="text" required name="searchinput" size="100" class="form-control" placeholder="Author, title or ISBN..."/>
		</div>
		<div class="form-group">
			<label>Search by:</label>
			<select class="form-control" name="bookcategories">
				<option value="Titre">Title</option>
				<option value="Author">Author</option>
				<option value="ISBN">ISBN</option>
			</select>		
		</div>
		<div class="form-group">
			<input type="submit" value="Search Book" class="btn btn-primary btn-lg"/>
		</div>
	</form>
</t:wrapper>
