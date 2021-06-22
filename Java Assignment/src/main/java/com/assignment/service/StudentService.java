package com.assignment.service;

import java.util.List;

import com.assignment.model.Student;

public interface StudentService {

	public Student registerStudent(Student student);
	public Student updateStudent(Student student);
	public List<Student> getAllStudents();
	public boolean deleteStudent(int id);
	public Student getStudent(int sno);
	
}
