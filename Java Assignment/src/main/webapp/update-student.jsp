<%@page import="com.assignment.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body>

	<%
		Student s = (Student)session.getAttribute("STUDENT");
	%>

	<h2>Update Student Details</h2>	
	<hr>
	<form action="StudentServlet" method="post">
		<label>Student No: </label> <input type="text" name="sno" value="<%=s.getStudentNo() %>" readonly="readonly"> &nbsp; (*You can't update Student no) <br> <br>
		<label>Enter Full Name: </label> <input type="text" name="sname" value="<%= s.getStudentName() %>"> <br><br>
		<label>Enter  Date of Birth : </label> <input type="date" name="dob" value="<%= s.getStudentdob() %>"><br><br>
		<label>Enter Date of Joining: </label> <input type="date" name="doj" value="<%= s.getStudentdoj() %>"><br>
		<input type="hidden" name="operation" value="update">
		<input type="submit" value="Update"/>
	</form>

	<hr>
	<a href="index.jsp">Home</a>

</body>
</html>