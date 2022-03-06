package com.theatmo.studentcontroller;

import com.theatmo.studentservice.StudentService;
import com.theatmo.studentservice.StudentServiceImpl;
import com.theatmo.studentmodel.Student;

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
	 * Check admin signup.
	 * 
	 * @param adminName
	 * @param adminEmail
	 * @param password
	 */
	public boolean adminSignup(final String adminName, final String adminEmail, final String password) {
		return STUDENT_SERVICE_DAO.insertAdminDetail(adminName, adminEmail, password);
	}

	/**
	 * Check admin login.
	 * 
	 * @param adminEmail
	 * @param password
	 */
	public boolean adminLogin(final String adminEmail, final String password) {
		return STUDENT_SERVICE_DAO.validateAdminDetail(adminEmail, password);
	}

	/**
	 * Check student login.
	 * 
	 * @param rollNumber
	 * @param studentName
	 */
	public boolean studentLogin(final String rollNumber, final String studentName) {
		return STUDENT_SERVICE_DAO.studentLogin(rollNumber, studentName);
	}

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
	 * @param rollNumber
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