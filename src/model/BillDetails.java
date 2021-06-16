package model;

public class BillDetails {
	private Long billId;
	private DrinkDetails drinkDetails;
	private int quantity;

	public BillDetails() {
		super();
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public DrinkDetails getDrinkDetails() {
		return drinkDetails;
	}

	public void setDrinkDetails(DrinkDetails drinkDetails) {
		this.drinkDetails = drinkDetails;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
