package com.theatmo.controller;

import com.theatmo.model.Student;
import com.theatmo.service.StudentService;
import com.theatmo.service.StudentServiceImpl;

/**
 * StudentManagementController. Controls all the requests and responses from the
 * user to the services and vice.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordController {

	private static final StudentService STUDENT_SERVICE_DAO = new StudentServiceImpl();

	/**
	 * Insert student details.
	 * 
	 * @param student
	 */
	public boolean insertStudentDetails(final Student student) {
		return STUDENT_SERVICE_DAO.insertStudentDetails(student);
	}

	/**
	 * Get student details.
	 * 
	 * @param rollNumber
	 */
	public Student selectStudentDetail(final String rollNumber) {
		return STUDENT_SERVICE_DAO.selectStudentDetail(rollNumber);
	}

	/**
	 * Delete student details.
	 * 
	 * @param rollNumber
	 */
	public boolean deleteStudentDetails(final String rollNumber) {
		return STUDENT_SERVICE_DAO.deleteStudentDetails(rollNumber);
	}

	/**
	 * Update student details.
	 * 
	 * @param student
	 */
	public boolean updateStudentDetails(final Student student) {
		return STUDENT_SERVICE_DAO.updateStudentDetails(student);
	}

	/**
	 * Check rollnumber.
	 * 
	 * @param rollNumber
	 */
	public boolean checkRollNumber(final String rollNumber) {
		return STUDENT_SERVICE_DAO.checkRollNumber(rollNumber);
	}

	/**
	 * Check rollnumber for update.
	 * 
	 * @param rollNumber
	 */
	public boolean checkUpdate(String rollNumber) {
		return STUDENT_SERVICE_DAO.checkUpdate(rollNumber);
	}
}