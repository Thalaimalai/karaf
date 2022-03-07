package com.theatmo.model;

import java.sql.Date;

public class Student {
	
	private String studentRollNumber;
	private String studentName;
	private String departmentName;
	private String email;
	private String gender;
	private Date dateOfBirth;
	private String address;
	private String grade;

	public Student() {
		super();
	}

	public Student(String rollNumber, String name, String departmentName, String email, String gender, Date dateOfBirth,
                   String address, String grade) {
		this.studentRollNumber = rollNumber;
		this.studentName = name;
		this.departmentName = departmentName;
		this.email = email;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.grade = grade;
	}

	public String getRollNumber() {
		return studentRollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.studentRollNumber = rollNumber;
	}

	public String getName() {
		return studentName;
	}

	public void setName(String name) {
		this.studentName = name;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String toString() {
		return String.format("%s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s", "\nRollNumber:", studentRollNumber,
				"\nName:", studentName, "\nDeptName:", departmentName, "\nEmail:", email, "\nGender:", gender, "\nDob:",
				dateOfBirth, "\nAddress:", address, "\nGrade:", grade);
	}
}
