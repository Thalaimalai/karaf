package com.atmo.studentrecord.service;

import com.atmo.studentrecord.model.Student;

/**
 * Interface to validate details. 
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public interface StudentService {

	boolean insertStudentDetails(final Student student);

	boolean deleteStudentDetails(final String rollNumber);

	boolean updateStudentDetails(final Student student);

	boolean checkRollNumber(final String rollNumber);

	Student selectStudentDetail(final String rollNumber);

	boolean checkUpdate(String rollNumber);
}
