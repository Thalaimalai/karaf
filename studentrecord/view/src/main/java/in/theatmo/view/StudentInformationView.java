package in.theatmo.view;

import java.sql.Date;
import org.apache.log4j.Logger;
import in.theatmo.controller.*;
import in.theatmo.exception.CustomException;
import in.theatmo.exception.CustomException.*;
import in.theatmo.model.*;

public class StudentInformationView {
	
//	private static final Logger LOGGER = Logger.getLogger(StudentInformationView.class);
	private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();
	
	/**
	 * Admin duties for modification of the student records.
	 */
    public static void showAdminWorks() {
		
	   	do {
			System.out.println("1.Insert 2.View 3.Delete 4.Update");

			try {
				int choice = Integer.parseInt(StudentView.getChoice().trim());

				if (choice == 1) {
					StudentInformationView.addStudentDetails();
				} else if (choice == 2) {
					StudentInformationView.viewStudentDetails();
				} else if (choice == 3) {
					StudentInformationView.deleteStudentDetails();
				} else if (choice == 4) {
					StudentInformationView.updateStudentDetails();
				} else {
					StudentView.SCANNER.close();
					System.exit(0);
				}
			} catch (NumberFormatException exception) {
				System.out.println("Enter Valid Choice");
			}
		} while (true);
	}

	/**
	 * Get the information of students to insert.
	 */
	private static void addStudentDetails() {
		final String rollNumber = StudentView.getStudentRollNumber();
		
		try {
			STUDENTRECORD_CONTROLLER.checkRollNumber(rollNumber);
		} catch (CustomException exception) {
			System.out.println(exception);
			StudentInformationView.addStudentDetails();
			StudentInformationView.showAdminWorks();
		}
		final String studentName = StudentView.getName();
		final String departmentName = StudentView.getDepartmentName();
		final String email = StudentView.getEmail();
		final String gender = StudentView.getGender();
		final Date dateOfBirth = StudentView.getDateOfBirth();
		final String address = StudentView.getAddress();
		final String grade = StudentView.getGrade(); 

		final Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth, address, grade);
		
		try {
			
			if (STUDENTRECORD_CONTROLLER.insertStudentDetails(student)) {
				System.out.println("Record Inserted Successfully");
			}
		} catch (CustomException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * View the respective student records.
	 */
	private static void viewStudentDetails() {
		final String rollNumber = StudentView.getStudentRollNumber();
		
		try {
			StudentInformationView.showDetails(STUDENTRECORD_CONTROLLER.selectStudentDetail(rollNumber));
		} catch (RecordNotfoundException exception) {
			System.out.println(exception);
		}
	}
	
	/**
	 * Print the student details.
	 * 
	 * @param student
	 */
	static void showDetails(final Student student) {
        System.out.println(student);
    }

	/**
	 * Delete the student records.
	 */
	private static void deleteStudentDetails() {
		final String rollNumber = StudentView.getStudentRollNumber();
		
		try {
		
			if (STUDENTRECORD_CONTROLLER.deleteStudentDetails(rollNumber)) {
				System.out.println("Record Deleted Successfully");
			}
		} catch (CustomException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Update the student records.
	 */
	private static void updateStudentDetails() {
		final String rollNumber = StudentView.getStudentRollNumber();
		
		try {
			STUDENTRECORD_CONTROLLER.checkUpdate(rollNumber);
		} catch (CustomException exception) {
			System.out.println(exception);
			StudentInformationView.updateStudentDetails();
			StudentInformationView.showAdminWorks();
		}
		final String studentName = StudentView.getName();
		final String departmentName = StudentView.getDepartmentName();
		final String email = StudentView.getEmail();
		final String gender = StudentView.getGender();
		final Date dateOfBirth = StudentView.getDateOfBirth();
		final String address = StudentView.getAddress();
		final String grade = StudentView.getGrade();
		
		final Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth, address, grade);
		
		try {
			
			if (STUDENTRECORD_CONTROLLER.updateStudentDetails(student)) {
				System.out.println("Record Updated Successfully");
			}
		} catch (CustomException exception) {
			System.out.println(exception);
		}
	}
}