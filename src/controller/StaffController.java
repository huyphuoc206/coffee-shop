package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Bill;
import model.Category;
import model.DrinkDetails;
import model.Drinks;
import model.LoginInfo;
import service.CategoryService;
import service.DrinkService;
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
	}

	private void loadData() {
		loadCategories();
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
					loadDrinkDetailsByDrinkId(key);
				}
			});
		});

	}

	private void loadCategories() {
		List<Category> categories = CategoryService.getInstance().findAll();
		staffView.showCategories(categories);
	}

	private void loadDrinksByCategoryId(long categoryId) {
		List<Drinks> drinks = DrinkService.getInstance().findByCategoryId(categoryId);
		staffView.showDrinks(drinks);
		drinkEvent();
	}

	private void loadDrinkDetailsByDrinkId(long drinkId) {
		List<DrinkDetails> drinkDetails = DrinkService.getInstance().getDrinkDetails(drinkId);
		// TODO: show drink details
		staffView.showDrinkDetails(drinkDetails);
	}
	
	public List<DrinkDetails> getDrinkDetails(long drinkId) {
		return null;
	}

	public void updateSize(DrinkDetails d) {

	}

	public void updateQuantity(int quantity) {

	}

	public void checkOut() {

	}

	public Bill saveBill(Bill bill) {
		return null;
	}
}
