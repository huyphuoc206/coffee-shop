package service;

import java.util.List;

import dao.CategoryDao;
import model.Category;

public class CategoryService {
	private static CategoryService instance;

	private CategoryService() {

	}

	public static CategoryService getInstance() {
		if (instance == null)
			instance = new CategoryService();
		return instance;
	}

	public List<Category> findAll() {
		return CategoryDao.getInstance().findAll();
	}
}
