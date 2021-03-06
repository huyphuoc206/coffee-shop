package service;

import dao.BillDao;
import model.Bill;

public class BillService {
	private static BillService instance;

	private BillService() {

	}

	public static BillService getInstance() {
		if (instance == null)
			instance = new BillService();
		return instance;
	}

	public Bill saveBill(Bill bill) {
		return BillDao.getInstance().saveBill(bill);
	}

}
