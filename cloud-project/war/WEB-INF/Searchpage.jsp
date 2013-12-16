
<%@ page import="com.google.appengine.api.users.User" %> 
<%@ page import="com.google.appengine.api.users.UserService" %> 
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %> 

<% 
UserService userService = UserServiceFactory.getUserService(); 
User user=userService.getCurrentUser();
%>
<form method="post" action="/searchpage">
<input type="text" name="searchinput" size="100" />
Search by:
<select name="bookcategories">
<option value="ISBN">isbn</option>
<option value="Author">author</option>
<option value="Titre">titre</option>
</select>
<input type="submit" value="Search Book" />
<a href="<%=userService.createLogoutURL("/")%>">sign out</a>
</form>
