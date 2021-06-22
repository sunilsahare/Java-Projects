<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>

	<h2>Add Student</h2>	
	<hr>
	<form action="StudentServlet" method="post">
		<label>Enter Full Name: </label> <input type="text" name="sname"> <br><br>
		<label>Enter Date of Birth : </label> <input type="date" name="dob"><br><br>
		<label>Enter Date of Joining: </label> <input type="date" name="doj"><br>
		<input type="hidden" name="operation" value="add">
		<input type="submit" value="Add"/>
	</form>

	<hr>
	<a href="index.jsp">Home</a>

</body>
</html>