package com.atmo.database.connection;

import com.atmo.database.exception.ConnectionFailedException;

import java.io.FileInputStream;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Properties;

/**
 * DatabaseConnection.
 *
 * @author ThalaimalaiPandiyanT
 *
 */
public class DatabaseConnection {

	/**
	 * Create MySQL Database Connection
	 */
	public static Connection getConnection() {

		try {
            Properties properties = new Properties();
			InputStream in = new FileInputStream("C:/karaf/etc/system.properties");
            properties.load(in);
			String url = properties.getProperty("karaf.jdbc.url");
			String username = properties.getProperty("karaf.jdbc.username");
			String password = properties.getProperty("karaf.jdbc.password");

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection	connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (Exception exception) {
			throw new ConnectionFailedException("Connection Failed");
		}
	}
}