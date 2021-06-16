package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import model.LoginInfo;
import model.Role;
import model.User;
import service.UserService;
import view.LoginView;

public class LoginController {
	private LoginView loginView;

	public LoginController() {
		loginView = new LoginView();
		loginView.setVisible(true);
		loginEvent();
	}

	private void loginEvent() {
		loginView.getBtnLogin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = loginView.getTxtUsername().getText();
				@SuppressWarnings("deprecation")
				String password = loginView.getTxtPassword().getText();
				checkLogin(username, password);
			}
		});

		loginView.getTxtUsername().addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				String username = loginView.getTxtUsername().getText();
				@SuppressWarnings("deprecation")
				String password = loginView.getTxtPassword().getText();
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					checkLogin(username, password);
				}
			}
		});

		loginView.getTxtPassword().addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				String username = loginView.getTxtUsername().getText();
				@SuppressWarnings("deprecation")
				String password = loginView.getTxtPassword().getText();
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					checkLogin(username, password);
				}
			}
		});
	}

	@SuppressWarnings("deprecation")
	public void checkLogin(String username, String password) {
		if (loginView.getTxtUsername().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên tài khoản!");
			return;
		}
		if (loginView.getTxtPassword().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập mật khẩu!");
			return;
		}
		User user = UserService.getInstance().checkLogin(username, password);
		if (user != null) {
			LoginInfo.USER_ID = user.getId();
			LoginInfo.FULLNAME = user.getFullname();
			if (Role.USER.name().equals(user.getRole())) {
				loginView.dispose();
				new StaffController();
			} else if (user.getRole() == Role.ADMIN.name()) {
				// forward admin view
			}
		} else {
			JOptionPane.showMessageDialog(null, "Tên đăng nhập và mật khẩu không hợp lệ.");
			loginView.clear();
		}
	}

}
