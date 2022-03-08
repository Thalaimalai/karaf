package com.atmo.view;

import com.atmo.Activator;
import com.atmo.CustomException;
import com.atmo.InputDetails;
import com.atmo.authenticatecontroller.AuthenticationController;
import com.atmo.controller.StudentRecordController;
import com.atmo.validation.CommonValidation;

/**
 * Get all information from the users.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentView {

	private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();
	private static final AuthenticationController AUTHENTICATE_CONTROLLER = new AuthenticationController();
	private static final CommonValidation VALIDATION = new CommonValidation();
	private static final StudentValidation STUDENT_VALIDATION = new StudentValidation();

	/**
	 * Select choice to login and signup.
	 */
	public static void selectChoice() {
		int choice;
		
		do {
			System.out.println("STUDENT RECORD MANAGEMENT SYSTEM\n1.Admin Login\n2.Admin Signup\n3.StudentLogin\n4.Exit");
			choice = Integer.parseInt(StudentView.getChoice());

			switch (choice) {
			case 1:
				StudentView.adminLogin();
				break;
			case 2:
				StudentView.adminSignup();
				break;
			case 3:
				StudentView.studentLogin();
				break;
			case 4:
				InputDetails.SCANNER.close();
				
				 try {
				      Activator.bundle.stop();
				    } catch (Exception exception) {
				      System.out.println(exception);
				    }
			}
		} while (choice < 4 );
	}

	/**
	 * Get choice.
	 * 
	 * @return choice
	 */
	public static String getChoice() {
		final String choice = InputDetails.getInputData("Enter choice");
		StudentView.exit(choice);

		if (Validation.validateChoice(choice)) {
			return choice;
		} else {
			System.out.println("Enter Valid Choice:");
			return StudentView.getChoice();
		}
	}

	/**
	 * Get the name.
	 * 
	 * @return name
	 */
	static String getName() {
		final String name = InputDetails.getInputData("Enter Name:\nPress # To Exit");
		StudentView.exit(name);

		if (VALIDATION.validateName(name)) {
			return name;
		} else {
			System.out.println("Enter Valid Name:\nPress # To Exit");
			return StudentView.getName();
		}
	}

	/**
	 * Get the Email.
	 * 
	 * @return Email
	 */
	static String getEmail() {
		final String email = InputDetails.getInputData("Enter Email:\nPress # To Exit");
		StudentView.exit(email);
		
		if (VALIDATION.validateEmail(email)) {
			return email;
		} else {
			System.out.println("Enter Valid Email:\nPress # To Exit");
			return StudentView.getEmail();
		}
	}

	/**
	 * Get the password.
	 * 
	 * @return Password
	 */
	private static String getPassword() {
		final String password = InputDetails.getInputData("Enter Admin Password:\nPress # To Exit");
		StudentView.exit(password);

		if (VALIDATION.validatePassword(password)) {
			return password;
		} else {
			System.out.println("Enter Valid Password:\nPress # To Exit");
			return StudentView.getPassword();
		}
	}

	/**
	 * Get student roll number.
	 *
	 * @return Roll number
	 */
	static String getStudentRollNumber() {
		final String rollNumber = InputDetails.getInputData("Enter Student Rollnumber\nPress # To Exit");
		StudentView.exit(rollNumber);

		if (STUDENT_VALIDATION.validateStudentRollNumber(rollNumber)) {
			return rollNumber;
		} else {
			System.out.println("Enter Valid Rollnumber:\nPress # To Exit");
			return StudentView.getStudentRollNumber();
		}
	}

	/**
	 * Get the credential to signup.
	 */
	public static void adminSignup() {
		final String adminName = StudentView.getName();
		final String adminEmail = StudentView.getEmail();
		final String password = StudentView.getPassword();

		try {

			if (AUTHENTICATE_CONTROLLER.adminSignup(adminName, adminEmail, password)) {
				System.out.println("Admin Details Inserted Successfully");
				StudentView.adminLogin();
			}
		} catch (CustomException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Get the credential to login.
	 */
	public static void adminLogin() {
		final String adminEmail = StudentView.getEmail();
		final String password = StudentView.getPassword();

		try {

			if (AUTHENTICATE_CONTROLLER.adminLogin(adminEmail, password)) {
				System.out.println("Log in Successfully");
				StudentInformationView.showAdminWorks();
			}
		} catch (CustomException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Student login to view their respective record.
	 */
	public static void studentLogin() {
		final String rollNumber = StudentView.getStudentRollNumber();
		final String studentName = StudentView.getName();

		try {

			if (AUTHENTICATE_CONTROLLER.studentLogin(rollNumber, studentName)) {
				System.out.println("Login Successfully");
				StudentInformationView.showDetails(STUDENTRECORD_CONTROLLER.selectStudentDetail(rollNumber));
			}
		} catch (CustomException exception) {
			System.out.println(exception);
		}
	}
	
	/**
	 * Back to main menu.
	 *
	 * @param choice
	 */
	public static void exit(final String choice) {
		
		if ("#".equals(choice)) {
			StudentView.selectChoice();
		}
	}
}