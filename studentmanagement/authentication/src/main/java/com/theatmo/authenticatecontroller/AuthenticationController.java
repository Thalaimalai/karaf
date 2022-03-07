package com.theatmo.authenticatecontroller;

import com.theatmo.authenticateservice.AuthenticationService;
import com.theatmo.authenticateservice.AuthenticationServiceImpl;

public class AuthenticationController {

    private static final AuthenticationService STUDENT_SERVICE_DAO = new AuthenticationServiceImpl();

    /**
     * Check admin signup.
     *
     * @param adminName
     * @param adminEmail
     * @param password
     */
    public boolean adminSignup(final String adminName, final String adminEmail, final String password) {
        return STUDENT_SERVICE_DAO.insertAdminDetail(adminName, adminEmail, password);
    }

    /**
     * Check admin login.
     *
     * @param adminEmail
     * @param password
     */
    public boolean adminLogin(final String adminEmail, final String password) {
        return STUDENT_SERVICE_DAO.validateAdminDetail(adminEmail, password);
    }

    /**
     * Check student login.
     *
     * @param rollNumber
     * @param studentName
     */
    public boolean studentLogin(final String rollNumber, final String studentName) {
        return STUDENT_SERVICE_DAO.studentLogin(rollNumber, studentName);
    }
}
