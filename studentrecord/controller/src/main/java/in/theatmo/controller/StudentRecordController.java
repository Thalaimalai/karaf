package in.theatmo.controller;

import in.theatmo.model.*;
import in.theatmo.service.*;

/**
 * StudentManagementController. Controls all the requests and responses from the
 * user to the services and vice versa.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordController {

	private static final StudentService STUDENT_SERVICES = new StudentServiceValidation();
	private static final StudentServiceVersion2 STUDENT_SERVICE_DAO = new StudentServiceVersion2Impl();

	/**
	 * Check choice.
	 * 
	 * @param choice
	 */
	public boolean checkChoice(final String choice) {
		return STUDENT_SERVICES.validateChoice(choice);
	}

	/**
	 * Check name.
	 * 
	 * @param name
	 */
	public boolean checkName(final String name) {
		return STUDENT_SERVICES.validateName(name);
	}

	/**
	 * Check email.
	 * 
	 * @param email
	 */
	public boolean checkEmail(final String email) {
		return STUDENT_SERVICES.validateEmail(email);
	}

	/**
	 * Check password.
	 * 
	 * @param password
	 */
	public boolean checkAdminPassword(final String password) {
		return STUDENT_SERVICES.validateAdminPassword(password);
	}

	/**
	 * Check rollNumber.
	 * 
	 * @param rollNumber
	 */
	public boolean checkStudentRollNumber(final String rollNumber) {
		return STUDENT_SERVICES.validateStudentRollNumber(rollNumber);
	}

	/**
	 * Check department name.
	 * 
	 * @param departmentName
	 */
	public boolean checkDepartmentName(final String departmentName) {
		return STUDENT_SERVICES.validateDepartmentName(departmentName);
	}

	/**
	 * Check gender.
	 * 
	 * @param gender
	 */
	public boolean checkGender(final String gender) {
		return STUDENT_SERVICES.validateGender(gender);
	}

	/**
	 * Check dateofbirth.
	 * 
	 * @param dateOfBirth
	 */
	public boolean checkDateOfBirth(final String dateOfBirth) {
		return STUDENT_SERVICES.validateDOB(dateOfBirth);
	}

	/**
	 * Check address.
	 * 
	 * @param address
	 */
	public boolean checkAddress(final String address) {
		return STUDENT_SERVICES.validateAddress(address);
	}

	/**
	 * Check grade.
	 * 
	 * @param grade
	 */
	public boolean checkGrade(final String grade) {
		return STUDENT_SERVICES.validateGrade(grade);
	}

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