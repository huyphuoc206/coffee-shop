package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;

	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				String url = "jdbc:postgresql://localhost/coffee-shop";
				String user = "postgres";
				String password = "php2006";
				connection = DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return connection;
	}
}
