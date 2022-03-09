package com.atmo.authentication.authenticatecontroller;

import com.atmo.authentication.authenticateservice.AuthenticationService;
import com.atmo.authentication.authenticateservice.AuthenticationServiceImpl;

public class AuthenticationController {

    private static final AuthenticationService AUTHENTICATE_SERVICE = new AuthenticationServiceImpl();

    /**
     * Check admin signup.
     *
     * @param adminName
     * @param adminEmail
     * @param password
     */
    public boolean adminSignup(final String adminName, final String adminEmail, final String password) {
        return AUTHENTICATE_SERVICE.insertAdminDetail(adminName, adminEmail, password);
    }

    /**
     * Check admin login.
     *
     * @param adminEmail
     * @param password
     */
    public boolean adminLogin(final String adminEmail, final String password) {
        return AUTHENTICATE_SERVICE.validateAdminDetail(adminEmail, password);
    }

    /**
     * Check student login.
     *
     * @param rollNumber
     * @param studentName
     */
    public boolean studentLogin(final String rollNumber, final String studentName) {
        return AUTHENTICATE_SERVICE.studentLogin(rollNumber, studentName);
    }
}
