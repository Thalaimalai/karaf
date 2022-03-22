package com.atmo.studentrecord.service;

import com.atmo.studentrecord.dao.StudentDAO;
import com.atmo.studentrecord.exception.RecordNotFoundException;
import com.atmo.studentrecord.exception.RollNumberAlreadyExistException;
import com.atmo.studentrecord.model.Student;
import com.atmo.studentrecord.dao.StudentDAOImpl;

import java.util.ArrayList;
import java.util.List;

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
		throw new RecordNotFoundException("Record Not Found");
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
		throw new RecordNotFoundException("Record Not Found");
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
			throw new RecordNotFoundException("Record Not Found");
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
	 * Get all student details.
	 */
	public List<Student> getAllStudents() {
		return new ArrayList<Student>(STUDENTRECORD_DAO.getAllStudents().values());
	}
	
	/**
	 * Check rollnumber for update.
	 */
	public boolean checkUpdate(String rollNumber) {
		if (STUDENTRECORD_DAO.getAllStudents().containsKey(rollNumber)) {
			return true;
		}
		throw new RecordNotFoundException("Record Not Found");
	}
}