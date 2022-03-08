package com.atmo.authenticateservice;

public interface AuthenticationService {

    boolean insertAdminDetail(String adminName, String adminEmail, String password);

    boolean validateAdminDetail(String adminEmail, String password);

    boolean studentLogin(String rollNumber, String studentName);
}
