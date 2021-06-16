package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import model.Bill;
import model.BillDetails;
import utils.DBUtils;

public class BillDao {
	private static BillDao instance;

	private BillDao() {

	}

	public static BillDao getInstance() {
		if (instance == null)
			instance = new BillDao();
		return instance;
	}

	public Bill saveBill(Bill bill) {
		String sql = "INSERT INTO bill (totalprice, status, createddate, userid, paymentid) VALUES (?, ?::bit, ?, ?, ?);";
		Long id = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, bill.getTotalPrice());
			statement.setString(2, bill.getStatus());
			statement.setTimestamp(3, Timestamp.valueOf(bill.getCreatedDate()));
			statement.setLong(4, bill.getStaffId());
			statement.setLong(5, bill.getPayment().getId());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next())
				id = resultSet.getLong(1);
			connection.commit();
			for (BillDetails billDetail : bill.getBillDetails()) {
				saveBillDetails(id, billDetail);
			}
			bill.setId(id);
			return bill;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
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

	private void saveBillDetails(Long billId, BillDetails billDetail) {
		String sql = "INSERT INTO billdetails (billid, drinkdetailsid, quantity) VALUES (?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, billId);
			statement.setLong(2, billDetail.getDrinkDetails().getId());
			statement.setInt(3, billDetail.getQuantity());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException throwables) {
			return;
		} finally {
			try {
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
