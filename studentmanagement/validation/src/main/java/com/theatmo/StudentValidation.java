package com.theatmo;

import com.theatmo.CustomException.DateNotValidException;
import java.time.LocalDate;

/**
 * StudentRecordServiceImpl.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentValidation {

	/**
	 * Validate choice.
	 * 
	 * @param choice
	 */
	public static boolean validateChoice(String choice) {
		return choice.matches("[1-5]") ? true : false;
	}

	/**
	 * Validate Name.
	 * 
	 * @param name
	 */
	public static boolean validateName(final String name) {
		return name.matches("^[A-Z][A-Za-z+\\s]*$") ? true : false;
	}

	/**
	 * Validate Email.
	 * 
	 * @param email
	 */
	public static boolean validateEmail(final String email) {
		return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-z]+$") ? true : false;
	}

	/**
	 * Validate Password.
	 * 
	 * @param password
	 */
	public static boolean validateAdminPassword(final String password) {
		return password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,12}") ? true : false;
	}

	/**
	 * Validate Rollnumber.
	 * 
	 * @param rollNumber
	 */
	public static boolean validateStudentRollNumber(final String rollNumber) {
		return rollNumber.matches("[0-9]{3,15}") ? true : false;
	}

	/**
	 * Validate Department Name.
	 * 
	 * @param departmentName
	 */
	public static boolean validateDepartmentName(final String departmentName) {
		return departmentName.matches("((?i)ECE|EEE|MECH|CSE|CIVIL)") ? true : false;
	}

	/**
	 * Validate Gender.
	 * 
	 * @param gender
	 */
	public static boolean validateGender(final String gender) {
		return gender.matches("((?i)MALE|FEMALE|OTHERS)") ? true : false;
	}

	/**
	 * Validate Date-of-Birth.
	 * 
	 * @param dateOfBirth
	 */
	public static boolean validateDOB(final String dateOfBirth) {

		try {
			final LocalDate dateParse = LocalDate.parse(dateOfBirth);
			final LocalDate todayDate = LocalDate.now();
			final LocalDate particularDate = LocalDate.of(2007, 12, 31);

			return (todayDate.isAfter(dateParse) && dateParse.isAfter(particularDate)) ? true : false; 
		} catch (Exception exception) {
			throw new DateNotValidException("Invalid Date");
		}
	}

	/**
	 * Validate Address.
	 * 
	 * @param address
	 */
	public static boolean validateAddress(final String address) {
		return address.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*") ? true : false;
	}

	/**
	 * Validate grade.
	 * 
	 * @param grade
	 */
	public static boolean validateGrade(final String grade) {
		return grade.matches("((?i)O|A+|A|B|U)") ? true : false;
	}
}