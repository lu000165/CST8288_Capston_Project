<%@ page import ="java.util.ArrayList" %>
<%@ page import ="javax.servlet.http.HttpServletRequest" %>
<%@ page import ="javax.servlet.http.HttpServlet" %>
<%@ page import ="javax.servlet.http.HttpServletResponse" %>
<%@ page import ="java.util.List" %>
<%@ page import="java.sql.Connection"%>
<%@ page import="Connection.MyConnection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import ="objects.MenuItem" %>
<%@ page import ="objects.Menu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MENU</title>
</head>


<body>
 
   <h1>MENU</h1>
	<label >Table Number</label>
	<input name="tableNumber value=""><br>
  
   <div>
		<% 
		ArrayList<MenuItem> menuItems = Menu.getItems();
		for(MenuItem menuItem : menuItems){
		%>

		<form name = "menuItems" action="/CST8288_Capston_Project/Servlet/MenuServlet">
			<textarea name="title"  maxlength="30" size="30" rows="2" disabled>Name: <%=menuItem.getName() %></textarea>
			<textarea name="content" wrap="hard" rows="2" cols="30" disabled>Description: <%=menuItem.getDes() %></textarea>
			<textarea name="price" rows="2" disabled>Price: <%=menuItem.getPrice() %></textarea>
			<input type="number" id="quantity" name="quanity" value=0>
			<input  type="submit" name = "addCart" value="Add to Cart">
		
		</form>
		<%}%>

	</div>
  

  <h2>Carts</h2>
   <div>
<% 
Statement statement;
ResultSet resultItems = null;
try{
Connection con = (Connection) MyConnection.initDB();
statement =con.createStatement();
String sql ="select * from orderitem where orderid = 1";
resultItems = statement.executeQuery(sql);
while(resultItems.next()){
%>


	<form name= "orderItems"  action="/CST8288_Capston_Project/Servlet/MenuServlet"></form>
	<textarea name="orderid" rows="1" disabled>Table Number: <%=resultItems.getInt("orderid") %></textarea>
	<textarea name="tableid" rows="1" disabled>Table Number: <%=resultItems.getInt("tableid") %></textarea>
	<textarea name="name"  maxlength="60" size="60" rows="1" disabled>Name: <%=resultItems.getString("name") %></textarea>
	<textarea name="quantity" rows="1" disabled>Quantity: <%=resultItems.getInt("quantity") %></textarea>
	<textarea name="price" rows="1" disabled>Price: <%=resultItems.getInt("price") %></textarea>
	</form>


<%
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
<br><input  type="submit" name = "submitOrder" value="Submit Order">

</div>
  </form>
  


</div>
</body>