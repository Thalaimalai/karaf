package com.theatmo.studentservice;

import com.theatmo.studentdao.StudentDAO;
import com.theatmo.studentdao.StudentDAOImpl;
import com.theatmo.studentexception.CustomException.RecordNotfoundException;
import com.theatmo.studentexception.CustomException.DetailsAlreadyFoundException;
import com.theatmo.studentexception.CustomException.RollNumberAlreadyExistException;
import com.theatmo.studentmodel.*;

/**
 * StudentServiceDAO.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentServiceImpl implements StudentService {

	private static final StudentDAO STUDENTRECORD_DAO = new StudentDAOImpl();

	/**
	 * Check the existing admin emails.
	 * 
	 * @param adminName
	 * @param adminEmail
	 * @param password
	 */
	public boolean insertAdminDetail(final String adminName, final String adminEmail, final String password) {

		if (!STUDENTRECORD_DAO.getAdminEmail().contains(adminEmail)) {

			if (STUDENTRECORD_DAO.insertAdminDetails(adminName, adminEmail, password)) {
				return true;
			}
		}
		throw new DetailsAlreadyFoundException("Admin Details Already Exist");
	}

	/**
	 * Validate admin details for signin.
	 * 
	 * @param adminEmail
	 * @param password
	 */
	public boolean validateAdminDetail(final String adminEmail, final String password) {

		if (STUDENTRECORD_DAO.loginAdmin(adminEmail, password)) {
			return true;
		} else {
			throw new RecordNotfoundException("Record Not Found");
		}
	}

	/**
	 * Validate student details for login.
	 * 
	 * @param rollNumber
	 * @param studentName
	 */
	public boolean studentLogin(final String rollNumber, final String studentName) {

		if (STUDENTRECORD_DAO.studentLogin(rollNumber, studentName)) {
			return true;
		} else {
			throw new RecordNotfoundException("Record Not Found");
		}
	}

	/**
	 * Insert student details.
	 * 
	 * @param student
	 */
	public boolean insertStudentDetails(final Student student) {

		if (!STUDENTRECORD_DAO.getAllStudents().containsKey(student.getRollNumber())) {

			if (STUDENTRECORD_DAO.insertStudentDetails(student)) {
				return true;
			}
		}
		throw new RollNumberAlreadyExistException("RollNumber Already Exist");
	}

	/**
	 * Delete student details.
	 * 
	 * @param rollNumber
	 */
	public boolean deleteStudentDetails(final String rollNumber) {

		if (STUDENTRECORD_DAO.deleteStudentDetails(rollNumber)) {
			return true;
		}
		throw new RecordNotfoundException("Record Not Found");
	}

	/**
	 * Update student details.
	 * 
	 * @param student
	 */
	public boolean updateStudentDetails(final Student student) {

		if (STUDENTRECORD_DAO.updateStudentDetails(student)) {
			return true;
		}
		throw new RecordNotfoundException("Record Not Found");
	}

	/**
	 * Get student detail.
	 * 
	 * @param rollNumber
	 */
	public Student selectStudentDetail(final String rollNumber) {

		if (STUDENTRECORD_DAO.getAllStudents().containsKey(rollNumber)) {
			return STUDENTRECORD_DAO.selectStudentDetail(rollNumber);
		} else {
			throw new RecordNotfoundException("Record Not Found");
		}
	}

	/**
	 * Check roll number.
	 * 
	 * @param rollNumber
	 */
	public boolean checkRollNumber(final String rollNumber) {

		if (!STUDENTRECORD_DAO.getAllStudents().containsKey(rollNumber)) {
			return true;
		}
		throw new RollNumberAlreadyExistException("The Given Rollnumber Already Exist\n Re-Enter RollNo ");
	}
	
	/**
	 * Check rollnumber for update.
	 */
	public boolean checkUpdate(String rollNumber) {
		if (STUDENTRECORD_DAO.getAllStudents().containsKey(rollNumber)) {
			return true;
		}
		throw new RecordNotfoundException("Record Not Found");
	}
}