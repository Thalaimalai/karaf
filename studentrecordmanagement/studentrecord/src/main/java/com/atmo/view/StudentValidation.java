package com.atmo.view;

public class StudentValidation {

    /**
     * Validate Rollnumber.
     *
     * @param rollNumber
     */
    public boolean validateStudentRollNumber(final String rollNumber) {
        return rollNumber.matches("[0-9]{3,15}") ? true : false;
    }

    /**
     * Validate Department Name.
     *
     * @param departmentName
     */
    public boolean validateDepartmentName(final String departmentName) {
        return departmentName.matches("((?i)ECE|EEE|MECH|CSE|CIVIL)") ? true : false;
    }

    /**
     * Validate Gender.
     *
     * @param gender
     */
    public boolean validateGender(final String gender) {
        return gender.matches("((?i)MALE|FEMALE|OTHERS)") ? true : false;
    }

    /**
     * Validate Address.
     *
     * @param address
     */
    public boolean validateAddress(final String address) {
        return address.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*") ? true : false;
    }

    /**
     * Validate grade.
     *
     * @param grade
     */
    public boolean validateGrade(final String grade) {
        return grade.matches("((?i)O|A+|A|B|U)") ? true : false;
    }

    /**
     * Validate choice.
     *
     * @param choice
     */
    public static boolean validateChoice(String choice) {
        return choice.matches("[1-5]") ? true : false;
    }
}
