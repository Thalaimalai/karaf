package com.atmo.authentication.authenticateservice;

import com.atmo.authentication.authenticatedao.AuthenticationDao;
import com.atmo.authentication.exception.DetailsAlreadyFoundException;
import com.atmo.authentication.exception.RecordNotFoundException;

public class AuthenticationServiceImpl implements AuthenticationService {

    private static final AuthenticationDao STUDENTRECORD_DAO = new AuthenticationDao();

    /**
     * Check the existing admin emails.
     *
     * @param adminName
     * @param adminEmail
     * @param password
     */
    public boolean insertAdminDetail(final String adminName, final String adminEmail, final String password) {

        if (!STUDENTRECORD_DAO.getAdminEmail().contains(adminEmail)) {

            if (STUDENTRECORD_DAO.insertAdminDetails(adminName, adminEmail, password)) {
                return true;
            }
        }
        throw new DetailsAlreadyFoundException("Admin Details Already Exist");
    }

    /**
     * Validate admin details for signin.
     *
     * @param adminEmail
     * @param password
     */
    public boolean validateAdminDetail(final String adminEmail, final String password) {

        if (STUDENTRECORD_DAO.loginAdmin(adminEmail, password)) {
            return true;
        } else {
            throw new RecordNotFoundException("Record Not Found");
        }
    }

    /**
     * Validate student details for login.
     *
     * @param rollNumber
     * @param studentName
     */
    public boolean studentLogin(final String rollNumber, final String studentName) {

        if (STUDENTRECORD_DAO.studentLogin(rollNumber, studentName)) {
            return true;
        } else {
            throw new RecordNotFoundException("Record Not Found");
        }
    }
}
