package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Payment;
import utils.DBUtils;

public class PaymentDao {
	private static PaymentDao instance;

	private PaymentDao() {

	}

	public static PaymentDao getInstance() {
		if (instance == null)
			instance = new PaymentDao();
		return instance;
	}

	public List<Payment> findAll() {
		String sql = "SELECT * FROM payment WHERE status = '1'";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Payment> payments = new ArrayList<Payment>();
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Payment payment = new Payment();
				payment.setId(resultSet.getLong("id"));
				payment.setName(resultSet.getString("name"));
				payment.setStatus(resultSet.getString("status"));
				payments.add(payment);
			}
			return payments;
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
