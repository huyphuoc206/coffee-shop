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
				String url = "jdbc:postgresql://ec2-54-155-87-214.eu-west-1.compute.amazonaws.com:5432/d6du86ba1ppihr";
				String user = "oaansujdhqtvrr";
				String password = "aac90239b01151e3f8b0a624249c23248c72422e2d1508da76338debb2bca6a0";
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
