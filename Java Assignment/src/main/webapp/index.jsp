<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.assignment.model.Student"%>
<%@page import="com.assignment.dao.StudentDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
</head>
<body>

	<%
		if(session.getAttribute("MSG")!=null){
			%>
			<h2><%= session.getAttribute("MSG") %></h2>
			<%
			session.removeAttribute("MSG");
		}
	%>

	<%
	StudentDaoImpl s = new StudentDaoImpl();
	List<Student> students = s.getAllStudent();
	Student student;
	
	%>	
	
	<h2>All Students </h2>
	<hr> <br>
	<%
		// tabloe will display if data exist
		if(students!=null){
		
	%>
	<table border="1">
		<thead>
			<tr>
				<th>Student No</th>
				<th>Student Name</th>
				<th>Student DOB</th>
				<th>Student DOJ</th>
				<th>Action</th>
			</tr>
		</thead>
		
		<tbody>
			<%
				for(int i=0;i<students.size();i++){
					student = students.get(i);
					%>
						<tr>
							<td><%=student.getStudentNo() %></td>
							<td><%=student.getStudentName() %></td>
							<td><%=student.getStudentdob() %></td>
							<td><%=student.getStudentdoj() %></td>
							<td>
								<a href="StudentServlet?operation=update&&sno=<%= student.getStudentNo() %>">Update</a> &nbsp;
								<a href="StudentServlet?operation=delete&&sno=<%= student.getStudentNo() %>">Delete</a>
							</td>
						</tr>
					<%
				}
			%>
			

		</tbody>
	
	</table>
	
	<%
		}
		else{
			%>
				<h4>Sorry!!! No data Found.</h4>
			<%
		}
	%>
	<br>
	<hr>
	
	<a href="add-student.jsp">Add Student</a>

</body>
</html>