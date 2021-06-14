package dao;

import java.util.List;

import model.DrinkDetails;

public class DrinkDao {
	private static DrinkDao instance;
	
	private DrinkDao() {
		
	}
	
	public static DrinkDao getInstance() {
		if (instance == null)
			instance = new DrinkDao();
		return instance;
	}
	public List<DrinkDetails> getDrinkDetails(long drinkId) {
		return null;
	}
}
