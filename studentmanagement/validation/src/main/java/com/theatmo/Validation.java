package com.theatmo;

public interface Validation {

    boolean validateChoice(String choice);

    boolean validateName(final String name);

    boolean validateEmail(final String email);

    boolean validateAdminPassword(final String password);

    boolean validateStudentRollNumber(final String rollNumber);

    boolean validateDepartmentName(final String departmentName);

    boolean validateGender(final String gender);

    boolean validateDOB(final String dateOfBirth);

    boolean validateAddress(final String address);

    boolean validateGrade(final String grade);
}
