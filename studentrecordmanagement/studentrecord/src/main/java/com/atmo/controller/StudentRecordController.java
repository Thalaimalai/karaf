package com.atmo.controller;

import com.atmo.model.Student;
import com.atmo.service.StudentService;
import com.atmo.service.StudentServiceImpl;

/**
 * StudentManagementController. Controls all the requests and responses from the
 * user to the services and vice.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordController {

	private static final StudentService STUDENT_SERVICE = new StudentServiceImpl();

	/**
	 * Insert student details.
	 * 
	 * @param student
	 */
	public boolean insertStudentDetails(final Student student) {
		return STUDENT_SERVICE.insertStudentDetails(student);
	}

	/**
	 * Get student details.
	 * 
	 * @param rollNumber
	 */
	public Student selectStudentDetail(final String rollNumber) {
		return STUDENT_SERVICE.selectStudentDetail(rollNumber);
	}

	/**
	 * Delete student details.
	 * 
	 * @param rollNumber
	 */
	public boolean deleteStudentDetails(final String rollNumber) {
		return STUDENT_SERVICE.deleteStudentDetails(rollNumber);
	}

	/**
	 * Update student details.
	 * 
	 * @param student
	 */
	public boolean updateStudentDetails(final Student student) {
		return STUDENT_SERVICE.updateStudentDetails(student);
	}

	/**
	 * Check rollnumber.
	 * 
	 * @param rollNumber
	 */
	public boolean checkRollNumber(final String rollNumber) {
		return STUDENT_SERVICE.checkRollNumber(rollNumber);
	}

	/**
	 * Check rollnumber for update.
	 * 
	 * @param rollNumber
	 */
	public boolean checkUpdate(String rollNumber) {
		return STUDENT_SERVICE.checkUpdate(rollNumber);
	}
}