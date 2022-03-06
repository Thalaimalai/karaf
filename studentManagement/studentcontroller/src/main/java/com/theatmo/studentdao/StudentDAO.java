package com.theatmo.studentdao;

import java.util.List;
import java.util.Map;
import com.theatmo.studentmodel.Student;

public interface StudentDAO {
	
	boolean studentLogin(final String rollNumber, final String studentName);

	boolean insertStudentDetails(final Student student);

	boolean deleteStudentDetails(final String rollNumber);

	boolean updateStudentDetails(final Student student);
	
	Student selectStudentDetail(final String rollNumber);
	
	boolean insertAdminDetails(final String adminName, final String adminEmail, final String password);	
	
	List<String> getAdminEmail();

	Map<String, Student> getAllStudents();

	boolean loginAdmin(final String adminEmail, final String password);
}
