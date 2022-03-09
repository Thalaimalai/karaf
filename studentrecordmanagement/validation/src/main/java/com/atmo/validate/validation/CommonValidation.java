package com.atmo.validate.validation;

import com.atmo.validate.exception.DateNotValidException;

import java.time.LocalDate;

/**
 * StudentRecordServiceImpl.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class CommonValidation {

	/**
	 * Validate Name.
	 * 
	 * @param name
	 */
	public boolean validateName(final String name) {
		return name.matches("^[A-Z][A-Za-z+\\s]*$") ? true : false;
	}

	/**
	 * Validate Email.
	 * 
	 * @param email
	 */
	public boolean validateEmail(final String email) {
		return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-z]+$") ? true : false;
	}

	/**
	 * Validate Password.
	 * 
	 * @param password
	 */
	public boolean validatePassword(final String password) {
		return password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,12}") ? true : false;
	}

	/**
	 * Validate Date-of-Birth.
	 * 
	 * @param dateOfBirth
	 */
	public boolean validateDate(final String dateOfBirth) {

		try {
			final LocalDate dateParse = LocalDate.parse(dateOfBirth);
			final LocalDate todayDate = LocalDate.now();
			final LocalDate particularDate = LocalDate.of(2007, 12, 31);

			return (todayDate.isAfter(dateParse) && dateParse.isAfter(particularDate)) ? true : false; 
		} catch (Exception exception) {
			throw new DateNotValidException("Invalid Date");
		}
	}
}