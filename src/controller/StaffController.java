package controller;

import java.util.List;

import model.Bill;
import model.DrinkDetails;
import view.StafffView;

public class StaffController {
	private StafffView stafffView;
	
	public StaffController() {
		this.stafffView = new StafffView();
		this.stafffView.getFrame().setVisible(true);
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
