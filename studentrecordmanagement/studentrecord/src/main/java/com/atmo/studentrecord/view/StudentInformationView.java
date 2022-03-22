package com.atmo.studentrecord.view;

import com.atmo.exception.CustomException;
import com.atmo.userinput.UserInput;
import com.atmo.studentrecord.controller.StudentRecordController;
import com.atmo.studentrecord.exception.RecordNotFoundException;
import com.atmo.studentrecord.model.Student;

import org.apache.log4j.Logger;

import java.sql.Date;

public class StudentInformationView {

    private static final Logger LOGGER = Logger.getLogger(StudentInformationView.class);
    private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();

    /**
     * Admin duties for modification of the student records.
     */
    public static void showAdminWorks() {

        do {
            System.out.println("1.Insert 2.View 3.Delete 4.Update 5.ShowAll Details");
            int choice = Integer.parseInt(StudentRecordView.getChoice().trim());

            if (choice == 1) {
                StudentInformationView.addStudentDetails();
            } else if (choice == 2) {
                StudentInformationView.viewStudentDetails();
            } else if (choice == 3) {
                StudentInformationView.deleteStudentDetails();
            } else if (choice == 4) {
                StudentInformationView.updateStudentDetails();
            } else if (choice == 5) {
                StudentInformationView.showAllStudentDetails();
            } else {
                UserInput.SCANNER.close();
                System.exit(0);
            }
        } while (true);
    }

    /**
     * Get the information of students to insert.
     */
    private static void addStudentDetails() {
        final String rollNumber = StudentRecordView.getStudentRollNumber();

        try {
            STUDENTRECORD_CONTROLLER.checkRollNumber(rollNumber);
        } catch (CustomException exception) {
            LOGGER.error(exception);
            StudentInformationView.addStudentDetails();
            StudentInformationView.showAdminWorks();
        }
        final String studentName = StudentRecordView.getName();
        final String departmentName = StudentRecordView.getDepartmentName();
        final String email = StudentRecordView.getEmail();
        final String gender = StudentRecordView.getGender();
        final Date dateOfBirth = StudentRecordView.getDateOfBirth();
        final String address = StudentRecordView.getAddress();
        final String grade = StudentRecordView.getGrade();

        final Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth, address, grade);

        try {

            if (STUDENTRECORD_CONTROLLER.insertStudentDetails(student)) {
                LOGGER.info("Record Inserted Successfully");
            }
        } catch (CustomException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * View the respective student records.
     */
    private static void viewStudentDetails() {
        final String rollNumber = StudentRecordView.getStudentRollNumber();

        try {
            StudentInformationView.showDetails(STUDENTRECORD_CONTROLLER.selectStudentDetail(rollNumber));
        } catch (RecordNotFoundException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * Print the student details.
     *
     * @param student
     */
    public static void showDetails(final Student student) {
        System.out.println(student);
    }

    /**
     * Delete the student records.
     */
    private static void deleteStudentDetails() {
        final String rollNumber = StudentRecordView.getStudentRollNumber();

        try {

            if (STUDENTRECORD_CONTROLLER.deleteStudentDetails(rollNumber)) {
                LOGGER.info("Record Deleted Successfully");
            }
        } catch (CustomException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * Update the student records.
     */
    private static void updateStudentDetails() {
        final String rollNumber = StudentRecordView.getStudentRollNumber();

        try {
            STUDENTRECORD_CONTROLLER.checkUpdate(rollNumber);
        } catch (CustomException exception) {
            LOGGER.error(exception);
            StudentInformationView.updateStudentDetails();
            StudentInformationView.showAdminWorks();
        }
        final String studentName = StudentRecordView.getName();
        final String departmentName = StudentRecordView.getDepartmentName();
        final String email = StudentRecordView.getEmail();
        final String gender = StudentRecordView.getGender();
        final Date dateOfBirth = StudentRecordView.getDateOfBirth();
        final String address = StudentRecordView.getAddress();
        final String grade = StudentRecordView.getGrade();

        final Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth, address, grade);

        try {

            if (STUDENTRECORD_CONTROLLER.updateStudentDetails(student)) {
                LOGGER.warn("Record Updated Successfully");
            }
        } catch (CustomException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * Show all student details.
     */
    private static void showAllStudentDetails() {
        System.out.println(STUDENTRECORD_CONTROLLER.getAllStudents());
    }
}