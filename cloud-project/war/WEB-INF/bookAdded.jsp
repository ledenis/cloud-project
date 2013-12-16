<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:wrapper>
	<c:choose>
		<c:when test="${success == true}">
			<div class="alert alert-success">You successfully added the book</div>
		</c:when>
		
		<c:otherwise>
			<div class="alert alert-danger">An error has occured</div>
		</c:otherwise>
	</c:choose>
</t:wrapper>