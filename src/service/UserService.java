package service;

import dao.UserDao;
import model.User;

public class UserService {

	private static UserService instance;

	private UserService() {

	}

	public static UserService getInstance() {
		if (instance == null)
			instance = new UserService();
		return instance;
	}

	public User checkLogin(String username, String password) {
		return UserDao.getInstance().checkLogin(username, password);
	}
}
