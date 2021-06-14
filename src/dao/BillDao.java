package dao;

import model.Bill;
import service.UserService;

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
		return null;
	}
}
