package service;

import java.util.List;

import dao.PaymentDao;
import model.Payment;

public class PaymentService {
	private static PaymentService instance;

	private PaymentService() {

	}

	public static PaymentService getInstance() {
		if (instance == null)
			instance = new PaymentService();
		return instance;
	}

	public List<Payment> findAll() {
		return PaymentDao.getInstance().findAll();
	}
}
