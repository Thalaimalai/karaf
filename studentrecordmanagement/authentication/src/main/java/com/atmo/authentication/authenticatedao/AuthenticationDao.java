package com.atmo.authentication.authenticatedao;

import com.atmo.database.connection.DatabaseConnection;
import com.atmo.database.exception.ConnectionFailedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationDao {

    /**
     * Insert the Admin information.
     *
     * @param adminName
     * @param adminEmail
     * @param password
     */
    public boolean insertAdminDetails(final String adminName, final String adminEmail, final String password) {
        final String insertQuery = "insert into admin_records values(?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery);) {
            statement.setString(1, adminName);
            statement.setString(2, adminEmail);
            statement.setString(3, password);

            return statement.executeUpdate() > 0;
        } catch (SQLException exception) {
            throw new ConnectionFailedException("Database Access Denied-Check SQL Syntax");
        }
    }

    /**
     * Admin login.
     *
     * @param adminEmail
     * @param password
     */
    public boolean loginAdmin(final String adminEmail, final String password) {
        final String adminLogin = "select adminemail, password from admin_records where BINARY adminemail = ? and BINARY password = ? ";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparestatement = connection.prepareStatement(adminLogin);) {
            preparestatement.setString(1, adminEmail);
            preparestatement.setString(2, password);

            try (ResultSet resultset = preparestatement.executeQuery();) {

                while (resultset.next()) {
                    return true;
                }
            }
        } catch (SQLException exception) {
            throw new ConnectionFailedException("Database Access Denied-Check SQL Syntax");
        }
        return false;
    }

    /**
     * Student login.
     *
     * @param rollNumber
     * @param studentName
     */
    public boolean studentLogin(final String rollNumber, final String studentName) {
        final String studentLogin = "select rollnumber, name from student_records where rollnumber = ? and name = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparestatement = connection.prepareStatement(studentLogin);) {
            preparestatement.setString(1, rollNumber);
            preparestatement.setString(2, studentName);

            try (ResultSet resultset = preparestatement.executeQuery();) {

                while (resultset.next()) {
                    return true;
                }
            }
        } catch (SQLException exception) {
            throw new ConnectionFailedException("Database Access Denied-Check SQL Syntax");
        }
        return false;
    }

    /**
     * List to add all admin emails.
     */
    public List<String> getAdminEmail() {
        final List<String> emailList = new ArrayList<String>();
        final String getEmail = "select adminemail from admin_records";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery(getEmail);) {

            while (resultset.next()) {
                String email = resultset.getString(1);
                emailList.add(email);
            }
        } catch (SQLException exception) {
            throw new ConnectionFailedException("Database Access Denied");
        }
        return emailList;
    }
}
