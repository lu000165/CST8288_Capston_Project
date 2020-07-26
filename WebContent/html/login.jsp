<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

form {
  border-bottom:2px dotted red;
}
</style>
<title>Log In</title>
</head>
<body>
	<form action="/CST8288_Capston_Project/Servlet/LoginServlet">
		<label>User Name</label>
		<input name = "userName" type = "text"><br>
		<label>Password</label>
		<input name = "password" type = "text">
		<input name = "submit" type = "Submit" value ="log In">
	</form>
	<%
		String errorMessage = (String)request.getAttribute("ErrorMessage");
		if (errorMessage == null){
			errorMessage = "";
		}

		System.out.println("Error Message is: " + errorMessage);
		
	%>
	<label ><%= errorMessage%></label><br>
	
	<p>
		<button onclick="location.href='register.jsp'" type = "button">Register</button>
	</p>
	<p>
		<label>Customer View</label><br>
		<button onclick="location.href='../html/CustomerView.jsp'" type = "button">Customer</button>
	</p>
	
</body>