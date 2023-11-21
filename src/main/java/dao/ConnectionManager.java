package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static ConnectionManager connectionManager;

	private ConnectionManager() {
	}

	public static ConnectionManager getInstance() {
		if (connectionManager == null) {
			connectionManager = new ConnectionManager();
		}
		return connectionManager;
	}

	public Connection getConnection() {

		final String URL = "jdbc:oracle:thin:@YOUR_URL";
		final String USER = "YOUR_USER";
		final String PSWD = "YOUR_PASSWORD";

		Connection connection = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(URL, USER, PSWD);
		} catch (Exception e) {
			throw new RuntimeException("ERROR: ", e);
		}
		return connection;
	}
}
