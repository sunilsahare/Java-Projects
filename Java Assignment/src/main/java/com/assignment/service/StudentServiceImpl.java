package com.assignment.service;

import java.util.List;

import com.assignment.dao.StudentDao;
import com.assignment.dao.StudentDaoImpl;
import com.assignment.model.Student;


public class StudentServiceImpl implements StudentService {

	public StudentDao stdDao;
	
	public StudentServiceImpl(){
		this.stdDao = new StudentDaoImpl();
	}
	
	@Override
	public Student registerStudent(Student student) {
		return stdDao.addStudent(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return stdDao.updateStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return stdDao.getAllStudent();
	}

	@Override
	public boolean deleteStudent(int id) {
		return stdDao.removeStudent(id);
	}

	@Override
	public Student getStudent(int sno) {
		return stdDao.getStudent(sno);
	}

}
