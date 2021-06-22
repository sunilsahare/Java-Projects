package com.assignment.dao;

import java.util.List;

import com.assignment.model.Student;

public interface StudentDao {

	public Student addStudent(Student student);
	public Student updateStudent(Student student);
	public List<Student> getAllStudent();
	public boolean removeStudent(int id);
	public Student getStudent(int sno);
	
}
