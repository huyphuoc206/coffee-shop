package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import utils.DBUtils;

public class CategoryDao {
	private static CategoryDao instance;

	private CategoryDao() {

	}

	public static CategoryDao getInstance() {
		if (instance == null)
			instance = new CategoryDao();
		return instance;
	}

	public List<Category> findAll() {
		String sql = "SELECT * FROM category WHERE status = '1'";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Category> categories = new ArrayList<Category>();
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getLong("id"));
				category.setName(resultSet.getString("name"));
				category.setStatus(resultSet.getString("status"));
				categories.add(category);
			}
			return categories;
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
	}
}
