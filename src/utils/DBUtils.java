package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;

	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://ec2-176-34-116-203.eu-west-1.compute.amazonaws.com:5432/d9s6ko6knsel02";
				String user = "kxfbocboggydsq";
				String password = "64af842003f2c949b636a5f0f7456a077eeff6bd069e1c547f051dfa6e65374f";
				connection = DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
