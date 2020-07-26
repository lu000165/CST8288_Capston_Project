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
<%@ page import ="objects.Order" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MENU</title>
</head>


<body>
 
	<h1>MENU</h1>
		<%
			int tableNumber = (Integer)request.getAttribute("tableNumber");
			int orderId = (Integer)request.getAttribute("orderID");
			System.out.println("table number is " + tableNumber + " and order id is "+orderId);
		
		%>
	<label >Table Number:<%= tableNumber%></label><br>
	<label >Order Number:<%= orderId%></label><br>
  
   <div>
		<% 
		ArrayList<MenuItem> menuItems = Menu.getItems();
		for(MenuItem menuItem : menuItems){
		%>

		<form name = "menuItems" action="/CST8288_Capston_Project/Servlet/MenuServlet">
			<textarea name="title"  maxlength="30" size="30" rows="2" disabled>Name: <%=menuItem.getName() %></textarea>
			<textarea name="content" wrap="hard" rows="2" cols="30" disabled>Description: <%=menuItem.getDes() %></textarea>
			<textarea name="price" rows="2" disabled>Price: <%=menuItem.getPrice() %></textarea>
			<input type="number" id="quantity" name="quantity" value=0>
			<input type ="hidden" name ="tableNumber" value=<%=tableNumber %>>
			<input type ="hidden" name ="orderNumber" value=<%=orderId%>>
			<input type ="hidden" name ="itemID" value=<%=menuItem.getId() %>>
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
String sql ="select * from orderitem where orderid = " +orderId;
resultItems = statement.executeQuery(sql);
while(resultItems.next()){
%>


	<form name= "orderItems"  action="/CST8288_Capston_Project/Servlet/MenuServlet"></form>
	<textarea name="orderid" rows="1" disabled>Order Number: <%=resultItems.getInt("orderid") %></textarea>
	<textarea name="tableid" rows="1" disabled>Table Number: <%=resultItems.getInt("tableid") %></textarea>
	<textarea name="menuId"  rows="1" disabled>Menu ID: <%=resultItems.getInt("menuId") %></textarea>
	<textarea name="quantity" rows="1" disabled>Quantity: <%=resultItems.getInt("quantity") %></textarea>
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