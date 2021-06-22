package com.assignment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.assignment.model.Student;

public class StudentDaoImpl implements StudentDao {

	public DatabaseConnection dbConnection;

	public StudentDaoImpl() {
		this.dbConnection = new DatabaseConnection();
	}

	@Override
	public Student addStudent(Student student) {

		try {
			Connection con = dbConnection.getCon();
			PreparedStatement pst = con
					.prepareStatement("insert into student(student_name,student_dob,student_doj) values(?,?,?)");
			pst.setString(1, student.getStudentName());
			Date dob = Date.valueOf(student.getStudentdob());
			Date doj = Date.valueOf(student.getStudentdoj());
			pst.setDate(2, dob);
			pst.setDate(3, doj);

			int i = pst.executeUpdate();
			if (i > 0) {
				return student;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}

	@Override
	public Student updateStudent(Student student) {

		try {
			Connection con = dbConnection.getCon();
			PreparedStatement pst = con.prepareStatement(
					"update Student set student_name=?,student_dob=?,student_doj=? where student_no=?");
			pst.setString(1, student.getStudentName());
			Date dob = Date.valueOf(student.getStudentdob());
			Date doj = Date.valueOf(student.getStudentdoj());
			pst.setDate(2, dob);
			pst.setDate(3, doj);
			pst.setInt(4, student.getStudentNo());

			int i = pst.executeUpdate();
			if (i > 0) {
				return student;
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return null;
	}

	@Override
	public List<Student> getAllStudent() {

		List<Student> list = new ArrayList<Student>();
		Student student;
		try {

			Connection con = dbConnection.getCon();
			PreparedStatement pst = con.prepareStatement("select * from Student order by student_name");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				student = new Student(rs.getInt("student_no"), rs.getString("student_name"),
						rs.getDate("student_dob").toString(), rs.getDate("student_doj").toString());
				list.add(student);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	
	@Override
	public Student getStudent(int sno) {

		try {

			Connection con = dbConnection.getCon();
			PreparedStatement pst = con.prepareStatement("select * from Student where student_no=?");
			pst.setInt(1, sno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Student student = new Student(rs.getInt("student_no"), rs.getString("student_name"),
						rs.getDate("student_dob").toString(), rs.getDate("student_doj").toString());
				return student;
			}
			else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean removeStudent(int id) {

		try {
			Connection con = dbConnection.getCon();
			PreparedStatement pst = con.prepareStatement("delete from Student where student_no=?");
			pst.setInt(1, id);
			int i = pst.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return false;
	}

}
