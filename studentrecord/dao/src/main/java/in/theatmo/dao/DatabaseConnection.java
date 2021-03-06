package in.theatmo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.log4j.Logger;

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
		final Logger logger = Logger.getLogger(DatabaseConnection.class);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
		} catch (Exception exception) {
			logger.error(exception);
		}
		return connection;
	}
}