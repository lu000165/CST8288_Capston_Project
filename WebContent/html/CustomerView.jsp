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
		<form name = "menuItems" action="/CST8288_Capston_Project/Servlet/MenuServlet">
			<label for="title">Table Number:</label><br>
			<input type="number" id="tableNumber" name="tableNumber" value="" maxlength="60" size="60" required><br>
			<input  type="submit" name = "setTable" value="Set Table">
		</form>
	</body>
</html>