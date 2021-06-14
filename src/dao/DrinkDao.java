package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DrinkDetails;
import model.Drinks;
import model.Size;
import utils.DBUtils;

public class DrinkDao {
	private static DrinkDao instance;

	private DrinkDao() {

	}

	public static DrinkDao getInstance() {
		if (instance == null)
			instance = new DrinkDao();
		return instance;
	}

	public List<DrinkDetails> getDrinkDetails(long drinkId) {
		String sql = "SELECT dd.*, d.name AS dname, d.image, s.name as sname  FROM drinks d JOIN drinkdetails dd ON d.id = dd.drinkid JOIN size s on dd.sizeid = s.id WHERE d.id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<DrinkDetails> drinkDetails = new ArrayList<DrinkDetails>();
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, drinkId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				DrinkDetails model = new DrinkDetails();
				model.setId(resultSet.getLong("id"));
				model.setPrice(resultSet.getLong("price"));
				
				Drinks drink = new Drinks();
				drink.setId(resultSet.getLong("drinkid"));
				drink.setName(resultSet.getString("dname"));
				drink.setImage(resultSet.getString("image"));
				Size size = new Size();
				size.setId(resultSet.getLong("sizeid"));
				size.setName(resultSet.getString("sname"));
				
				model.setDrink(drink);
				model.setSize(size);
				drinkDetails.add(model);
			}
			return drinkDetails;
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

	public List<Drinks> findByCategoryId(long categoryId) {
		String sql = "SELECT * FROM drinks WHERE categoryid = ? AND status = '1'";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Drinks> drinks = new ArrayList<Drinks>();
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, categoryId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Drinks drink = new Drinks();
				drink.setId(resultSet.getLong("id"));
				drink.setName(resultSet.getString("name"));
				drink.setImage(resultSet.getString("image"));
				drink.setStatus(resultSet.getString("status"));
				// set category for drink
				drink.setCreatedDate(resultSet.getTimestamp("createddate").toLocalDateTime());
				drinks.add(drink);
			}
			return drinks;
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
