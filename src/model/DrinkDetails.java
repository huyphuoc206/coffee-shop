package model;

public class DrinkDetails {
	private Long id;
	private Drinks drink;
	private Size size;
	private long price;

	public DrinkDetails() {
		super();
	}

	public Drinks getDrink() {
		return drink;
	}

	public void setDrink(Drinks drink) {
		this.drink = drink;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}