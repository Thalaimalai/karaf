package com.theatmo.controller;

import com.theatmo.model.Student;
import com.theatmo.service.StudentService;
import org.osgi.service.component.annotations.Reference;

/**
 * StudentManagementController. Controls all the requests and responses from the
 * user to the services and vice.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordController {

	@Reference
	StudentService studentService;

	/**
	 * Insert student details.
	 * 
	 * @param student
	 */
	public boolean insertStudentDetails(final Student student) {
		return studentService.insertStudentDetails(student);
	}

	/**
	 * Get student details.
	 * 
	 * @param rollNumber
	 */
	public Student selectStudentDetail(final String rollNumber) {
		return studentService.selectStudentDetail(rollNumber);
	}

	/**
	 * Delete student details.
	 * 
	 * @param rollNumber
	 */
	public boolean deleteStudentDetails(final String rollNumber) {
		return studentService.deleteStudentDetails(rollNumber);
	}

	/**
	 * Update student details.
	 * 
	 * @param student
	 */
	public boolean updateStudentDetails(final Student student) {
		return studentService.updateStudentDetails(student);
	}

	/**
	 * Check rollnumber.
	 * 
	 * @param rollNumber
	 */
	public boolean checkRollNumber(final String rollNumber) {
		return studentService.checkRollNumber(rollNumber);
	}

	/**
	 * Check rollnumber for update.
	 * 
	 * @param rollNumber
	 */
	public boolean checkUpdate(String rollNumber) {
		return studentService.checkUpdate(rollNumber);
	}
}