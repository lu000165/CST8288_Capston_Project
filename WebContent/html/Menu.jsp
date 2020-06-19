<%@ page import ="java.util.ArrayList" %>
<%@ page import ="objects.MenuItem" %>
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
</head>


<!-- <div class="container">
  <form name="menu" id="menu">
  <h3>MENU</h3>
    <table style="width:100%">
     <tr>
      <th>Name</th>
      <th>Description</th>
      <th>Price</th>
      <th>Quantity</th>
      <th></th>
     </tr>
     <tr>
      <th header="Name">Item 1</th>
      <th header="Description">Item 1 description</th>
      <th header="Price">$10.00</th>
      <th><input type="number" id="quantity" name="quantity" value =0></th>
      <th><input type="submit" name ="submit" value="Add to cart"></th>
     </tr>
     <tr>
      <th>Item 2</th>
      <th>Item 2 description</th>
      <th>$20.00</th>
      <th><input type="number" id="quantity" name="quantity" value =0></th>
      <th><input type="submit" name ="submit" value="Add to cart"></th>
     </tr>
     <tr>
      <th>Item 3</th>
      <th>Item 3 description</th>
      <th>$30.00</th>
      <th><input type="number" id="quantity" name="quantity" value =0></th>
      <th><input type="submit" name ="submit" value="Add to cart"></th>
     </tr>
    </table> 
    </form>-->
 
   
   <label >Table Number</label>
   <input name="tableNumber value=""><br>
  
   <div>
<% 
Statement statement = null;
ResultSet resultSet = null;
try{
Connection con = (Connection) MyConnection.initDB();
statement =con.createStatement();
String sql ="select * from menu order by id desc";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<form name = "menuItems" action="/CST8288_Capston_Project/Servlet/MenuServlet">
<textarea name="title"  maxlength="60" size="60" rows="2" disabled>Name: <%=resultSet.getString("name") %></textarea>
<textarea name="content" wrap="hard" rows="2" cols="60" disabled>Description: <%=resultSet.getString("description") %></textarea>
<textarea name="price" rows="2" disabled>Price: <%=resultSet.getInt("price") %></textarea>
<input type="number" id="quantity" name="quanity" value=0>
<input  type="submit" name = "addCart" value="Add to Cart">

</form>
<%
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

</div>
  

  <h2>Carts</h2>
   <div>
<% 

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