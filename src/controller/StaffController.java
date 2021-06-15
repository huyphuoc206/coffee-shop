package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import model.Bill;
import model.Category;
import model.DrinkDetails;
import model.Drinks;
import model.LoginInfo;
import model.Payment;
import service.BillService;
import service.CategoryService;
import service.DrinkService;
import service.PaymentService;
import view.StaffView;

public class StaffController {
	private StaffView staffView;

	public StaffController() {
		staffView = new StaffView();
		staffView.getLblStaffName().setText(LoginInfo.FULLNAME);
		staffView.getFrame().setVisible(true);
		loadData();
		loadEvent();
	}

	private void loadEvent() {
		exitEvent();
		categoryEvent();
		addToBillEvent();
		removeDrinkEvent();
		checkOutEvent();
	}

	private void loadData() {
		loadCategories();
		loadPayment();
	}

	private void exitEvent() {
		staffView.getBtnExit().addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int choice = JOptionPane.showConfirmDialog(staffView.getFrame(), "Bạn có thật sự thoát chương trình?",
						"Exit", JOptionPane.OK_CANCEL_OPTION);
				if (choice == 0) {
					LoginInfo.USER_ID = null;
					LoginInfo.FULLNAME = null;
					staffView.getFrame().dispose();
					new LoginController();
				} else {
					staffView.getFrame().setDefaultCloseOperation(staffView.getFrame().DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}

	private void categoryEvent() {
		Map<Long, JButton> mapCategories = staffView.getMapCategories();
		mapCategories.forEach((key, value) -> {
			value.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					loadDrinksByCategoryId(key);
				}
			});
		});
		Map.Entry<Long, JButton> firstButton = mapCategories.entrySet().iterator().next();
		firstButton.getValue().doClick();
	}

	private void drinkEvent() {
		Map<Long, JButton> mapDrinks = staffView.getMapDrinks();
		mapDrinks.forEach((key, value) -> {
			value.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					getDrinkDetails(key);
				}
			});
		});

	}

	private void cbSizeEvent() {
		staffView.getComboBoxSize().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = staffView.getComboBoxSize().getSelectedIndex();
				if (index >= 0 && staffView.getListDrinkDetails().size() > 0)
					updateSize(staffView.getListDrinkDetails().get(index));
			}
		});
	}

	private void addToBillEvent() {
		staffView.getBtnAddToBill().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = staffView.getComboBoxSize().getSelectedIndex();
				addToBill(staffView.getListDrinkDetails().get(index));
			}
		});
	}

	private void checkOutEvent() {
		staffView.getBtnCheckout().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (staffView.getBill() != null && staffView.getBill().getBillDetails().size() > 0)
					checkOut();
			}
		});
	}

	private void removeDrinkEvent() {
		staffView.getBtnRemoveDrink().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[] rows = staffView.getTableBill().getSelectedRows();
				if (rows.length > 0) {
					int index = Integer.parseInt(staffView.getTableBill().getValueAt(rows[0], 0) + "");
					removeDrink(index);
				}
			}
		});
	}

	private void removeDrink(int index) {
		staffView.removeDrink(index);
	}

	private void loadCategories() {
		List<Category> categories = CategoryService.getInstance().findAll();
		staffView.showCategories(categories);
	}

	private void loadPayment() {
		List<Payment> payments = PaymentService.getInstance().findAll();
		staffView.showPayments(payments);
	}

	private void loadDrinksByCategoryId(long categoryId) {
		List<Drinks> drinks = DrinkService.getInstance().findByCategoryId(categoryId);
		staffView.showDrinks(drinks);
		drinkEvent();
	}

	public void getDrinkDetails(long drinkId) {
		List<DrinkDetails> drinkDetails = DrinkService.getInstance().getDrinkDetails(drinkId);
		staffView.showDrinkDetails(drinkDetails);
		staffView.resetComboBox();
		cbSizeEvent();
	}

	public void updateSize(DrinkDetails d) {
		staffView.updateSize(d);
	}

	private void addToBill(DrinkDetails drinkDetails) {
		staffView.showBill(drinkDetails);
	}

	@SuppressWarnings("static-access")
	public void checkOut() {
		int choice = JOptionPane.showConfirmDialog(staffView.getFrame(), "Bạn muốn thanh toán và in hóa đơn này?",
				"Checkout", JOptionPane.OK_CANCEL_OPTION);
		if (choice == 0) {
			// TODO: print bill

			Bill bill = staffView.getBill();
			bill.setStatus("1");
			bill.setCreatedDate(LocalDateTime.now());
			bill.setTotalPrice(bill.calTotalPrice());
			for (Map.Entry<Long, JRadioButton> entry : staffView.getMapPayments().entrySet()) {
				if (entry.getValue().isSelected()) {
					Payment payment = new Payment();
					payment.setId(entry.getKey());
					bill.setPayment(payment);
					break;
				}
			}
			if (saveBill(bill) != null) {
				JOptionPane.showMessageDialog(null, "Thanh toán thành công");
				staffView.clearAfterCheckout();
			}

		} else {
			staffView.getFrame().setDefaultCloseOperation(staffView.getFrame().DO_NOTHING_ON_CLOSE);
		}
	}

	public Bill saveBill(Bill bill) {
		return BillService.getInstance().saveBill(bill);
	}

	public void updateQuantity(int quantity) {

	}
}
