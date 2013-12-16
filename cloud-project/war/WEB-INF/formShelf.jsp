<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
	<form method="post" action="/createShelf" class="form-inline" role="search">
		<div class="form-group">
			<input type="text" name="shelfName" required size="100" class="form-control" placeholder="Name of the shelf"/>
		</div>
		<div class="form-group">
			<input type="submit" value="Create Shelf" class="btn btn-primary btn-lg"/>
		</div>
	</form>
</t:wrapper>