package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utils.DBUtils;

public class UserDao {
	private static UserDao instance;

	private UserDao() {

	}

	public static UserDao getInstance() {
		if (instance == null)
			instance = new UserDao();
		return instance;
	}

	public User checkLogin(String username, String password) {
		String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND status = '1'";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getLong("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setFullname(resultSet.getString("fullname"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setAddress(resultSet.getString("address"));
				user.setStatus(resultSet.getString("status"));
				user.setRole(resultSet.getString("role"));
				user.setGender(resultSet.getString("gender"));
				user.setBirthday(resultSet.getTimestamp("birthday").toLocalDateTime());
				user.setCreatedDate(resultSet.getTimestamp("createddate").toLocalDateTime());
				return user;
			}
		} catch (SQLException throwables) {
			return null;
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return null;
	}

}
