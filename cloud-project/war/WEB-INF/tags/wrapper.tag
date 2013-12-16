<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ tag import="com.google.appengine.api.users.User" %> 
<%@ tag import="com.google.appengine.api.users.UserService" %> 
<%@ tag import="com.google.appengine.api.users.UserServiceFactory" %>

 
<% UserService userService = UserServiceFactory.getUserService(); 
User user=userService.getCurrentUser();  %>
<!DOCTYPE HTML>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="navbar navbar-inverse">
	    <div class="container">
	      <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	          <span class="sr-only">Toggle navigation</span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	        </button>
	        <a class="navbar-brand" href="#">Bookshelf</a>
	      </div>
	      <div class="navbar-collapse collapse">
	        <ul class="nav navbar-nav">
	          <li class="active"><a href="#">Home</a></li>
	          <li><a href="#about">Bookshelves</a></li>
	          <li><a href="#contact">Search a book</a></li>
	          <li><a href="<%= userService.createLogoutURL("/") %>">Sign out</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	</div>
	<div class="container" style="margin: auto;
  position: absolute;
  top: 0; left: 0; bottom: 0; right: 0;
	display: table;
  height: auto;">
		<jsp:doBody/>
	</div>
</body>
</html>