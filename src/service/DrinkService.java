package service;

import java.util.List;

import model.DrinkDetails;

public class DrinkService {
	private static DrinkService instance;

	private DrinkService() {

	}

	public static DrinkService getInstance() {
		if (instance == null)
			instance = new DrinkService();
		return instance;
	}

	public List<DrinkDetails> getDrinkDetails(long drinkId) {
		return null;
	}
}
