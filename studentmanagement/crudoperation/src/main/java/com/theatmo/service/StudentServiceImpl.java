package com.theatmo.service;

import com.theatmo.dao.StudentDAO;
import com.theatmo.dao.StudentDAOImpl;
import com.theatmo.model.Student;
import com.theatmo.CustomException.RecordNotfoundException;
import com.theatmo.CustomException.RollNumberAlreadyExistException;

/**
 * StudentServiceDAO.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentServiceImpl implements StudentService {

	private static final StudentDAO STUDENTRECORD_DAO = new StudentDAOImpl();

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