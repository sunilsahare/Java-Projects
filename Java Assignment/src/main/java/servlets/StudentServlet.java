package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.model.Student;
import com.assignment.service.StudentService;
import com.assignment.service.StudentServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentService service;
	private HttpSession session;
	
	public StudentServlet() {
		this.service = new StudentServiceImpl();	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		int sno = Integer.parseInt(request.getParameter("sno"));
		session = request.getSession();
		// if request for delete
		if(op.equals("delete")) {
			if(service.deleteStudent(sno)) {
				session.setAttribute("MSG", "Record Successfully deleted.");
				response.sendRedirect("index.jsp");
			}
			else {
				session.setAttribute("MSG", "Sorry!!! Record not deleted.");
				response.sendRedirect("index.jsp");
			}
		}
		else if(op.equals("update")) {
			Student std = service.getStudent(sno);
			if(std!=null) {
				session.setAttribute("STUDENT", std);
				response.sendRedirect("update-student.jsp");
			}
			else {
				session.setAttribute("MSG", "Sorry!!! Somethiong went wrong.");
				response.sendRedirect("index.jsp");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String op = request.getParameter("operation");
		String sname = request.getParameter("sname");
		String dob = request.getParameter("dob");
		String doj = request.getParameter("doj");
		
		if(op.equals("add")) {
			Student savedStudent = service.registerStudent(new Student(sname, dob, doj));
			session = request.getSession();
			if(savedStudent!=null) {
				session.setAttribute("MSG", "Student Added Successfully.");
				response.sendRedirect("index.jsp");
			}
			else {
				session.setAttribute("MSG", "Student not Added!!!");
				response.sendRedirect("index.jsp");
			}
		}
		else if(op.equals("update")) {
			int sno = Integer.parseInt(request.getParameter("sno"));
			Student updatedStudent = service.updateStudent(new Student(sno,sname, dob, doj));
			session = request.getSession();
			if(updatedStudent!=null) {
				session.setAttribute("MSG", "Student Data Updated Successfully.");
				response.sendRedirect("index.jsp");
			}
			else {
				session.setAttribute("MSG", "Data not Updated!!!");
				response.sendRedirect("index.jsp");
			}
		}
		
	}

}
