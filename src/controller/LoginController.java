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
		this.loginView = new LoginView();
		this.loginView.setVisible(true);
		loginEvent();
	}

	private void loginEvent() {
		this.loginView.getBtnLogin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = LoginController.this.loginView.getTxtUsername().getText();
				@SuppressWarnings("deprecation")
				String password = LoginController.this.loginView.getTxtPassword().getText();
				checkLogin(username, password);
			}
		});

		this.loginView.getTxtUsername().addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				String username = LoginController.this.loginView.getTxtUsername().getText();
				@SuppressWarnings("deprecation")
				String password = LoginController.this.loginView.getTxtPassword().getText();
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					checkLogin(username, password);
				}
			}
		});

		this.loginView.getTxtPassword().addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				String username = LoginController.this.loginView.getTxtUsername().getText();
				@SuppressWarnings("deprecation")
				String password = LoginController.this.loginView.getTxtPassword().getText();
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
				this.loginView.dispose();
				new StaffController();
			} else if (user.getRole() == Role.ADMIN.name()) {
				// forward admin view
			}
		} else {
			JOptionPane.showMessageDialog(null, "Tên đăng nhập và mật khẩu không hợp lệ.");
			this.loginView.clear();
		}
	}

}
