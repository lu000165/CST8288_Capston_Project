<%@ page import ="java.util.ArrayList" %>
<%@ page import ="objects.MenuItem" %>
<%@ page import ="objects.Menu" %>
<%@ page import ="javax.servlet.http.HttpServletRequest" %>
<%@ page import ="javax.servlet.http.HttpServlet" %>
<%@ page import ="javax.servlet.http.HttpServletResponse" %>
<%@ page import ="java.util.List" %>
<%@ page import="java.sql.Connection"%>
<%@ page import="Connection.MyConnection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function message(){
	alert("The new item has been added!");
	return true;
}
</script>
<style>

form {
  border-bottom:2px dotted red;
}
</style>
<title>Update MENU</title>
</head>
<body>
<h1>Update MENU</h1>
<form name ="menu" method="get" action="/CST8288_Capston_Project/Servlet/UpdateMenuServlet" onsubmit ="return message();">
  <label for="title">Name:</label><br>
  <input type="text" id="title" name="title" value="" maxlength="60" size="60"><br>
  <label for="des">Description:</label><br>
  <textarea name="content" rows="5" cols="60" maxlength="120"></textarea><br>
  <label for="price">Price</label>
  <input type="text" id="price" name="price" value=""><br>
  
  <input  type="submit" name = "submit" value="Add">
</form> 
<div>
<% 
ArrayList<MenuItem> menuItems = Menu.showAllItems();
for(MenuItem menuItem : menuItems){
%>

<form name = "menuItems" action="/CST8288_Capston_Project/Servlet/UpdateMenuServlet">
ID: <%=menuItem.getId() %></label><br>
<input type ="hidden" name ="id" value=<%=menuItem.getId() %>>
<label>Name</label><br>
<textarea name="title"  maxlength="60" size="60" rows="1"><%=menuItem.getName() %></textarea><br>
<label>Description</label><br>
<textarea name="content" wrap="hard" rows="5" cols="60" maxlength="120"><%=menuItem.getDes() %></textarea><br>
<label>Price</label><br>
<textarea name="price" rows="1"><%=menuItem.getPrice() %></textarea><br>

<input  type="submit" name = "edit" value="Edit">
<input  type="submit" name = "delete" value="Delete">
</form>
<%} %>


</div>

</body>

</html>