package service;

import java.util.List;

import dao.DrinkDao;
import model.DrinkDetails;
import model.Drinks;

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
		return DrinkDao.getInstance().getDrinkDetails(drinkId);
	}

	public List<Drinks> findByCategoryId(long categoryId) {
		return DrinkDao.getInstance().findByCategoryId(categoryId);
	}
}
