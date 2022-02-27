package in.theatmo.view;

import java.sql.Date;
import java.util.Scanner;
import org.apache.log4j.Logger;
import in.theatmo.controller.*;
import in.theatmo.exception.*;

/**
 * Get all information from the users.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentView {

	public static final Scanner SCANNER = new Scanner(System.in);
	private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();
//	private static final Logger LOGGER = Logger.getLogger(StudentView.class);

	 /**
		 * Select choice to login and signup.
		 */
		public static void selectChoice() {

			do {
			//	final Logger LOGGER = Logger.getLogger(Activator.class);
				System.out.println("STUDENT RECORD MANAGEMENT SYSTEM\n1.Admin Login\n2.Admin Signup\n3.StudentLogin\n4.Exit");
				final int choice = Integer.parseInt(StudentView.getChoice());

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
				default:
					StudentView.SCANNER.close();
					System.exit(0);
				}
			} while (true);
		}
	
	/**
	 * Get choice.
	 * 
	 * @return choice
	 */
	public static String getChoice() {
		System.out.println("Enter Choice:");
		final String choice = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(choice)) {
			StudentView.selectChoice();
		}

		if (STUDENTRECORD_CONTROLLER.checkChoice(choice)) {
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
		final String name = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(name)) {
			StudentView.selectChoice();
		}

		if (STUDENTRECORD_CONTROLLER.checkName(name)) {
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
		final String email = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(email)) {
			StudentView.selectChoice();
		}

		if (STUDENTRECORD_CONTROLLER.checkEmail(email)) {
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
		final String password = StudentView.SCANNER.nextLine();

		if ("#".equals(password)) {
			StudentView.selectChoice();
		}

		if (STUDENTRECORD_CONTROLLER.checkAdminPassword(password)) {
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
		final String rollNumber = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(rollNumber)) {
			StudentInformationView.showAdminWorks();
		}

		if (STUDENTRECORD_CONTROLLER.checkStudentRollNumber(rollNumber)) {
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
		final String departmentName = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(departmentName)) {
			StudentInformationView.showAdminWorks();
		}

		if (STUDENTRECORD_CONTROLLER.checkDepartmentName(departmentName)) {
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
		final String gender = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(gender)) {
			StudentInformationView.showAdminWorks();
		}

		if (STUDENTRECORD_CONTROLLER.checkGender(gender)) {
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
		final String date = StudentView.SCANNER.nextLine();

		if ("#".equals(date)) {
			StudentInformationView.showAdminWorks();
		}
		boolean isValidDate = false;

		try {
			isValidDate = STUDENTRECORD_CONTROLLER.checkDateOfBirth(date);
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
		final String address = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(address)) {
			StudentInformationView.showAdminWorks();
		}

		if (STUDENTRECORD_CONTROLLER.checkAddress(address)) {
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
		final String grade = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(grade)) {
			StudentInformationView.showAdminWorks();
		}

		if (STUDENTRECORD_CONTROLLER.checkGrade(grade)) {
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

			if (STUDENTRECORD_CONTROLLER.adminSignup(adminName, adminEmail, password)) {
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

			if (STUDENTRECORD_CONTROLLER.adminLogin(adminEmail, password)) {
				System.out.println("Log in Successfully");
				StudentInformationView.showAdminWorks();
			}
		} catch (CustomException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Student login to view thier respective record.
	 */
	public static void studentLogin() {
		final String rollNumber = StudentView.getStudentRollNumber();
		final String studentName = StudentView.getName();

		try {

			if (STUDENTRECORD_CONTROLLER.studentLogin(rollNumber, studentName)) {
				System.out.println("Login Successfully");
				StudentInformationView.showDetails(STUDENTRECORD_CONTROLLER.selectStudentDetail(rollNumber));
			}
		} catch (CustomException exception) {
			System.out.println(exception);
		}
	}
}