package com.theatmo.authenticatecontroller;

import com.theatmo.authenticateservice.AuthenticationService;
import org.osgi.service.component.annotations.Reference;

public class AuthenticationController {

    @Reference
    static AuthenticationService authenticateService;

    /**
     * Check admin signup.
     *
     * @param adminName
     * @param adminEmail
     * @param password
     */
    public boolean adminSignup(final String adminName, final String adminEmail, final String password) {
        return authenticateService.insertAdminDetail(adminName, adminEmail, password);
    }

    /**
     * Check admin login.
     *
     * @param adminEmail
     * @param password
     */
    public boolean adminLogin(final String adminEmail, final String password) {
        return authenticateService.validateAdminDetail(adminEmail, password);
    }

    /**
     * Check student login.
     *
     * @param rollNumber
     * @param studentName
     */
    public boolean studentLogin(final String rollNumber, final String studentName) {
        return authenticateService.studentLogin(rollNumber, studentName);
    }
}
