package com.atmo.dao;

import com.atmo.model.Student;
import java.util.Map;

public interface StudentDAO {

	boolean insertStudentDetails(final Student student);

	boolean deleteStudentDetails(final String rollNumber);

	boolean updateStudentDetails(final Student student);
	
	Student selectStudentDetail(final String rollNumber);

	Map<String, Student> getAllStudents();
}
