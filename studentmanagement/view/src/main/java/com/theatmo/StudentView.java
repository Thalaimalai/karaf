package com.theatmo;

import com.theatmo.authenticatecontroller.AuthenticationController;
import com.theatmo.controller.StudentRecordController;
import org.osgi.service.component.annotations.Reference;
import java.sql.Date;
import java.util.Scanner;

/**
 * Get all information from the users.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentView {

	public static final Scanner SCANNER = new Scanner(System.in);
	private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();
	private static final AuthenticationController AUTHENTICATE_CONTROLLER = new AuthenticationController();

	@Reference
	static
	Validation validation;

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
				SCANNER.close();
				
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
		System.out.println("Enter Choice:");
		final String choice = StudentView.SCANNER.next().trim();
		StudentView.exit(choice);

		if (validation.validateChoice(choice)) {
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
		System.out.println("Enter Name:\nPress # To Exit");
		final String name = StudentView.SCANNER.next().trim();
		StudentView.exit(name);

		if (validation.validateName(name)) {
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
		System.out.println("Enter Email:\nPress # To Exit");
		final String email = StudentView.SCANNER.next().trim();
		StudentView.exit(email);
		
		if (validation.validateEmail(email)) {
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
		System.out.println("Enter Admin Password:\nPress # To Exit");
		final String password = StudentView.SCANNER.next();
		StudentView.exit(password);

		if (validation.validateAdminPassword(password)) {
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
		System.out.println("Enter Student Rollnumber\nPress # To Exit");
		final String rollNumber = StudentView.SCANNER.next().trim();
		StudentView.exit(rollNumber);

		if (validation.validateStudentRollNumber(rollNumber)) {
			return rollNumber;
		} else {
			System.out.println("Enter Valid Rollnumber:\nPress # To Exit");
			return StudentView.getStudentRollNumber();
		}
	}

	/**
	 * Get student department name.
	 * 
	 * @return department
	 */
	static String getDepartmentName() {
		System.out.println("Enter Department Name (ECE, EEE, CIVIL, MECH, CSE)\nPress # To Exit");
		final String departmentName = StudentView.SCANNER.next().trim();
		StudentView.exit(departmentName);

		if (validation.validateDepartmentName(departmentName)) {
			return departmentName;
		} else {
			System.out.println("Enter Valid Department:\nPress # To Exit");
			return StudentView.getDepartmentName();
		}
	}

	/**
	 * Get student gender.
	 * 
	 * @return Gender
	 */
	static String getGender() {
		System.out.println("Enter Student Gender (Male or Female or Others)\nPress # To Exit");
		final String gender = StudentView.SCANNER.next().trim();
		StudentView.exit(gender);
		
		if (validation.validateGender(gender)) {
			return gender;
		} else {
			System.out.println("Enter Valid Gender:\nPress # To Exit");
			return StudentView.getGender();
		}
	}

	/**
	 * Get student Date-of-birth.
	 * 
	 * @return DOB
	 */
	static Date getDateOfBirth() {
		System.out.println("Enter Student Date-of-Birth (yyyy-MM-dd)\nPress # To Exit");
		final String date = StudentView.SCANNER.next();
		StudentView.exit(date);
		boolean isValidDate = false;

		try {
			isValidDate = validation.validateDOB(date);
		} catch (CustomException exception) {
			System.out.println(exception);
		}

		if (isValidDate) {
			return Date.valueOf(date);
		} else {
			System.out.println("Enter Valid Date:\nPress # To Exit");
			return StudentView.getDateOfBirth();
		}
	}

	/**
	 * Get the address of the student.
	 * 
	 * @return Address
	 */
	static String getAddress() {
		System.out.println("Enter Student Address:\nPress # To Exit");
		final String address = StudentView.SCANNER.next().trim();
		StudentView.exit(address);

		if (validation.validateAddress(address)) {
			return address;
		} else {
			System.out.println("Enter Valid Address:\nPress # To Exit");
			return StudentView.getAddress();
		}
	}

	/**
	 * Get grade of the student.
	 * 
	 * @return grade
	 */
	static String getGrade() {
		System.out.println("Enter Student Grade:(O, A, A+, B, U)\nPress # To Exit");
		final String grade = StudentView.SCANNER.next().trim();
		StudentView.exit(grade);
		
		if (validation.validateGrade(grade)) {
			return grade;
		} else {
			System.out.println("Enter Valid Grade:\nPress # To Exit");
			return StudentView.getGrade();
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