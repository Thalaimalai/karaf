package com.atmo.database.connection;

import com.atmo.database.exception.ConnectionFailedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

/**
 * DatabaseConnection.
 *
 * @author ThalaimalaiPandiyanT
 *
 */
public class DatabaseConnection {

	private static Map<String, String> property;

	/**
	 * Create MySQL Database Connection
	 */
	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection	connection = DriverManager.getConnection(property.get("karaf.jdbc.url"), property.get("karaf.jdbc.username"), property.get("karaf.jdbc.password"));
			return connection;
		} catch (Exception exception) {
			throw new ConnectionFailedException("Connection Failed");
		}
	}

	/**
	 *Get the database connection url, password, name from property.
	 *
	 * @param properties
	 */
	public static void dataBaseProperty(Map<String, String> properties) {
		property = properties;
	}
}