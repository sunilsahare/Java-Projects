package com.assignment.model;

public class Student {

	private int studentNo;
	private String studentName;
	private String studentdob;
	private String studentdoj;

	public Student() {
		super();
	}

	public Student(String studentName, String studentdob, String studentdoj) {
		super();
		this.studentName = studentName;
		this.studentdob = studentdob;
		this.studentdoj = studentdoj;
	}
	public Student(int studentNo, String studentName, String studentdob, String studentdoj) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentdob = studentdob;
		this.studentdoj = studentdoj;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentdob() {
		return studentdob;
	}

	public void setStudentdob(String studentdob) {
		this.studentdob = studentdob;
	}

	public String getStudentdoj() {
		return studentdoj;
	}

	public void setStudentdoj(String studentdoj) {
		this.studentdoj = studentdoj;
	}

	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", studentdob=" + studentdob
				+ ", studentdoj=" + studentdoj + "]";
	}

}
