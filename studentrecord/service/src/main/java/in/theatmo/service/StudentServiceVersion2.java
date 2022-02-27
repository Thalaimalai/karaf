package in.theatmo.service;

import in.theatmo.model.*;

/**
 * Interface to validate details. 
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public interface StudentServiceVersion2 {
	
	boolean insertAdminDetail(final String adminName, final String adminEmail, final String password);

	boolean validateAdminDetail(final String adminEmail, final String password);

	boolean studentLogin(final String rollNumber, final String studentName);

	boolean insertStudentDetails(final Student student);

	boolean deleteStudentDetails(final String rollNumber);

	boolean updateStudentDetails(final Student student);

	boolean checkRollNumber(final String rollNumber);

	Student selectStudentDetail(final String rollNumber);

	boolean checkUpdate(String rollNumber);
}
