package com.atmo.studentrecord.view;

import com.atmo.exception.CustomException;
import com.atmo.userinput.UserInput;
import com.atmo.validate.validation.CommonValidation;
import java.sql.Date;
import org.apache.log4j.Logger;

public class StudentRecordView {

    private static final Logger LOGGER = Logger.getLogger(StudentRecordView.class);
    private static final CommonValidation STUDENT_VALIDATION = new CommonValidation();
    private static final StudentValidation VALIDATION = new StudentValidation();

    /**
     * Get choice.
     *
     * @return choice
     */
    public static String getChoice() {
        final String choice = UserInput.getString("Enter Choice:");
        StudentRecordView.exit(choice);

        if (StudentValidation.validateChoice(choice)) {
            return choice;
        } else {
            LOGGER.warn("Enter Valid Choice:");
            return StudentRecordView.getChoice();
        }
    }

    /**
     * Get the name.
     *
     * @return name
     */
    static String getName() {
        final String name = UserInput.getString("Enter Name:\nPress # To Exit");
        StudentRecordView.exit(name);

        if (STUDENT_VALIDATION.validateName(name)) {
            return name;
        } else {
            LOGGER.warn("Enter Valid Name:\nPress # To Exit");
            return StudentRecordView.getName();
        }
    }

    /**
     * Get the Email.
     *
     * @return Email
     */
    static String getEmail() {
        final String email = UserInput.getString("Enter Email:\nPress # To Exit");
        StudentRecordView.exit(email);

        if (STUDENT_VALIDATION.validateEmail(email)) {
            return email;
        } else {
            LOGGER.warn("Enter Valid Email:\nPress # To Exit");
            return StudentRecordView.getEmail();
        }
    }

    /**
     * Get student roll number.
     *
     * @return Roll number
     */
    static String getStudentRollNumber() {
        final String rollNumber = UserInput.getString("Enter Student Rollnumber\nPress # To Exit");
        StudentRecordView.exit(rollNumber);

        if (VALIDATION.validateStudentRollNumber(rollNumber)) {
            return rollNumber;
        } else {
            LOGGER.warn("Enter Valid Rollnumber:\nPress # To Exit");
            return StudentRecordView.getStudentRollNumber();
        }
    }

    /**
     * Get student department name.
     *
     * @return department
     */
    static String getDepartmentName() {
        final String departmentName = UserInput.getString("Enter Department Name (ECE, EEE, CIVIL, MECH, CSE)\nPress # To Exit");
        StudentRecordView.exit(departmentName);

        if (VALIDATION.validateDepartmentName(departmentName)) {
            return departmentName;
        } else {
            LOGGER.warn("Enter Valid Department:\nPress # To Exit");
            return StudentRecordView.getDepartmentName();
        }
    }

    /**
     * Get student gender.
     *
     * @return Gender
     */
    static String getGender() {
        final String gender = UserInput.getString("Enter Student Gender (Male or Female or Others)\nPress # To Exit");
        StudentRecordView.exit(gender);

        if (VALIDATION.validateGender(gender)) {
            return gender;
        } else {
            LOGGER.warn("Enter Valid Gender:\nPress # To Exit");
            return StudentRecordView.getGender();
        }
    }

    /**
     * Get student Date-of-birth.
     *
     * @return DOB
     */
    static Date getDateOfBirth() {
        final String date = UserInput.getString("Enter Student Date-of-Birth (yyyy-MM-dd)\nPress # To Exit");
        StudentRecordView.exit(date);
        boolean isValidDate = false;

        try {
            isValidDate = STUDENT_VALIDATION.validateDate(date);
        } catch (CustomException exception) {
            LOGGER.error(exception);
        }

        if (isValidDate) {
            return Date.valueOf(date);
        } else {
            LOGGER.warn("Enter Valid Date:\nPress # To Exit");
            return StudentRecordView.getDateOfBirth();
        }
    }

    /**
     * Get the address of the student.
     *
     * @return Address
     */
    static String getAddress() {
        final String address = UserInput.getString("Enter Student Address:\nPress # To Exit");
        StudentRecordView.exit(address);

        if (VALIDATION.validateAddress(address)) {
            return address;
        } else {
            LOGGER.warn("Enter Valid Address:\nPress # To Exit");
            return StudentRecordView.getAddress();
        }
    }

    /**
     * Get grade of the student.
     *
     * @return grade
     */
    static String getGrade() {
        final String grade = UserInput.getString("Enter Student Grade:(O, A, A+, B, U)\nPress # To Exit");
        StudentRecordView.exit(grade);

        if (VALIDATION.validateGrade(grade)) {
            return grade;
        } else {
            LOGGER.warn("Enter Valid Grade:\nPress # To Exit");
            return StudentRecordView.getGrade();
        }
    }

    /**
     * Back to main menu.
     *
     * @param choice
     */
    public static void exit(final String choice) {

        if ("#".equals(choice)) {
            StudentInformationView.showAdminWorks();
        }
    }
}
