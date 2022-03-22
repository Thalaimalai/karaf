package com.atmo.authentication.view;

import com.atmo.authentication.authenticatecontroller.AuthenticationController;
import com.atmo.authentication.Activator;
import com.atmo.exception.CustomException;
import com.atmo.userinput.UserInput;
import com.atmo.studentrecord.controller.StudentRecordController;
import com.atmo.validate.validation.CommonValidation;
import com.atmo.studentrecord.view.StudentInformationView;
import com.atmo.studentrecord.view.StudentValidation;

import org.apache.log4j.Logger;

/**
 * Get all information from the users.
 *
 * @author ThalaimalaiPandiyanT
 */
public class StudentView {

    private static final Logger LOGGER = Logger.getLogger(StudentView.class);
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
                    UserInput.SCANNER.close();

                    try {
                        Activator.bundle.stop();
                    } catch (Exception exception) {
                        LOGGER.error(exception);
                    }
            }
        } while (choice < 4);
    }

    /**
     * Get choice.
     *
     * @return choice
     */
    public static String getChoice() {
        final String choice = UserInput.getString("Enter choice");
        StudentView.exit(choice);

        if (Validation.validateChoice(choice)) {
            return choice;
        } else {
            LOGGER.warn("Enter Valid Choice:");
            return StudentView.getChoice();
        }
    }

    /**
     * Get the name.
     *
     * @return name
     */
    static String getName() {
        final String name = UserInput.getString("Enter Name:\nPress # To Exit");
        StudentView.exit(name);

        if (VALIDATION.validateName(name)) {
            return name;
        } else {
            LOGGER.warn("Enter Valid Name:\nPress # To Exit");
            return StudentView.getName();
        }
    }

    /**
     * Get the Email.
     *
     * @return Email
     */
    static String getEmail() {
        final String email = UserInput.getString("Enter Email:\nPress # To Exit");
        StudentView.exit(email);

        if (VALIDATION.validateEmail(email)) {
            return email;
        } else {
            LOGGER.warn("Enter Valid Email:\nPress # To Exit");
            return StudentView.getEmail();
        }
    }

    /**
     * Get the password.
     *
     * @return Password
     */
    private static String getPassword() {
        final String password = UserInput.getString("Enter Admin Password:\nPress # To Exit");
        StudentView.exit(password);

        if (VALIDATION.validatePassword(password)) {
            return password;
        } else {
            LOGGER.warn("Enter Valid Password:\nPress # To Exit");
            return StudentView.getPassword();
        }
    }

    /**
     * Get student roll number.
     *
     * @return Roll number
     */
    static String getStudentRollNumber() {
        final String rollNumber = UserInput.getString("Enter Student Rollnumber\nPress # To Exit");
        StudentView.exit(rollNumber);

        if (STUDENT_VALIDATION.validateStudentRollNumber(rollNumber)) {
            return rollNumber;
        } else {
            LOGGER.warn("Enter Valid Rollnumber:\nPress # To Exit");
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
            LOGGER.error(exception);
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
            LOGGER.error(exception);
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
                LOGGER.info("Login Successfully");
                StudentInformationView.showDetails(STUDENTRECORD_CONTROLLER.selectStudentDetail(rollNumber));
            }
        } catch (CustomException exception) {
            LOGGER.error(exception);
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