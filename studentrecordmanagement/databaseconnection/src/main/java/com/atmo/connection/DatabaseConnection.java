package com.atmo.connection;

import com.atmo.exception.ConnectionFailedException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DatabaseConnection.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class DatabaseConnection {

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/admin";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "Thalai@2000@";

	/**
	 * Create MySQL Database Connection
	 */
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
		} catch (Exception exception) {
			throw new ConnectionFailedException("Connection Failed");
		}
		return connection;
	}
}