package in.theatmo.service;

/**
 * Interface to validate details.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public interface StudentService {
	
	boolean validateName(final String name);

	boolean validateEmail(final String email);

	boolean validateAdminPassword(final String password);

	boolean validateStudentRollNumber(final String rollNumber);

	boolean validateDepartmentName(final String departmentName);

	boolean validateGender(final String gender);

	boolean validateDOB(final String dateOfBirth);

	boolean validateAddress(final String address);

	boolean validateChoice(final String choice);

	boolean validateGrade(final String grade);
}

