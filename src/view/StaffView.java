package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

import model.Category;
import model.DrinkDetails;
import model.Drinks;
import model.Payment;

public class StaffView {

	private JFrame frame;
	private JPanel panelDrinks;
	private JPanel panelCategory;
	private JPanel panelPayment;
	private JLabel lblDrinkPrice;
	private JLabel lblDrinkName;
	private JLabel lblTotalPrice;
	private JLabel lblStaffName;
	private JButton btnAddToBill;
	private JButton btnCheckout;
	private JButton btnRemoveDrink;
	private JButton btnExit;
	private JComboBox<String> comboBoxSize;
	private JTable tableBill;
	private JPanel panelDrinkSelected;
	private JLabel lblDrinkSelected;
	private Map<Long, JButton> mapCategories;
	private Map<Long, JButton> mapDrinks = new HashMap<Long, JButton>();

	/**
	 * Create the application.
	 */
	@SuppressWarnings("deprecation")
	public StaffView() {
		initialize();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		panelDrinkSelected.hide();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Nong Lam Coffee");
		frame.setBounds(100, 100, 1126, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		JPanel panelStaffName = new JPanel();
		panelStaffName.setBounds(12, -13, 271, 42);
		frame.getContentPane().add(panelStaffName);
		panelStaffName.setLayout(null);

		lblStaffName = new JLabel("Huy Phước");
		lblStaffName.setBounds(12, 21, 147, 18);
		panelStaffName.add(lblStaffName);

		btnExit = new JButton();
		btnExit.setBounds(177, 18, 82, 24);
		btnExit.setText("Thoát");
		panelStaffName.add(btnExit);

		panelDrinks = new JPanel();
		panelDrinks.setBackground(Color.WHITE);
		panelDrinks.setPreferredSize(new Dimension(415, 428));
		panelDrinks.setBounds(12, 35, 415, 428);
		frame.getContentPane().add(panelDrinks);

		panelCategory = new JPanel();
		panelCategory.setBackground(Color.WHITE);
		panelCategory.setBounds(12, 475, 415, 79);
		frame.getContentPane().add(panelCategory);
		panelCategory.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));

		panelDrinkSelected = new JPanel();

		panelDrinkSelected.setBackground(Color.WHITE);
		panelDrinkSelected.setBounds(439, 35, 273, 519);
		frame.getContentPane().add(panelDrinkSelected);
		panelDrinkSelected.setLayout(null);

		lblDrinkSelected = new JLabel();
		lblDrinkSelected.setBounds(12, 12, 249, 208);
		panelDrinkSelected.add(lblDrinkSelected);

		JLabel lblTe = new JLabel("Tên:");
		lblTe.setBounds(49, 262, 70, 15);
		panelDrinkSelected.add(lblTe);

		JLabel lblTe_1 = new JLabel("Giá:");
		lblTe_1.setBounds(49, 310, 70, 15);
		panelDrinkSelected.add(lblTe_1);

		JLabel lblTe_2 = new JLabel("Size:");
		lblTe_2.setBounds(49, 357, 70, 15);
		panelDrinkSelected.add(lblTe_2);

		JLabel lblTe_3 = new JLabel("Số lượng:");
		lblTe_3.setBounds(49, 398, 70, 15);
		panelDrinkSelected.add(lblTe_3);

		btnAddToBill = new JButton("Add");
		btnAddToBill.setBounds(89, 458, 104, 38);
		panelDrinkSelected.add(btnAddToBill);

		comboBoxSize = new JComboBox<String>();
		comboBoxSize.setBounds(131, 352, 104, 24);
		panelDrinkSelected.add(comboBoxSize);

		lblDrinkName = new JLabel("");
		lblDrinkName.setForeground(Color.RED);
		lblDrinkName.setBounds(131, 256, 130, 27);
		panelDrinkSelected.add(lblDrinkName);

		lblDrinkPrice = new JLabel("");
		lblDrinkPrice.setForeground(Color.RED);
		lblDrinkPrice.setBounds(131, 304, 142, 27);
		panelDrinkSelected.add(lblDrinkPrice);

		JSpinner quantity = new JSpinner();
		quantity.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		quantity.setMaximumSize(new Dimension(29, 20));
		quantity.setFont(new Font("Dialog", Font.BOLD, 14));
		quantity.setBounds(131, 395, 104, 22);
		panelDrinkSelected.add(quantity);

		JPanel panelBill = new JPanel();
		panelBill.setBackground(Color.WHITE);
		panelBill.setBounds(724, 35, 390, 519);
		frame.getContentPane().add(panelBill);
		panelBill.setLayout(null);

		btnCheckout = new JButton("Thanh toán");
		btnCheckout.setBounds(257, 461, 123, 38);
		panelBill.add(btnCheckout);

		tableBill = new JTable();
		tableBill.setBounds(12, 303, 366, -279);
		panelBill.add(tableBill);

		btnRemoveDrink = new JButton("Xóa");
		btnRemoveDrink.setBounds(155, 335, 80, 25);
		panelBill.add(btnRemoveDrink);

		JLabel lbl1212 = new JLabel("Tổng tiền:");
		lbl1212.setBounds(16, 469, 91, 23);
		panelBill.add(lbl1212);

		lblTotalPrice = new JLabel("1.000.000.000 VND");
		lblTotalPrice.setForeground(Color.RED);
		lblTotalPrice.setBounds(95, 473, 144, 15);
		panelBill.add(lblTotalPrice);

		panelPayment = new JPanel();
		panelPayment.setBackground(Color.WHITE);
		panelPayment.setBounds(14, 411, 366, 38);
		panelBill.add(panelPayment);

		showPayments(null);
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
		exitApplication();
	}

	private void exitApplication() {
		int choice = JOptionPane.showConfirmDialog(frame, "Bạn có thật sự thoát chương trình?", "Exit",
				JOptionPane.OK_CANCEL_OPTION);
		if (choice == 0) {
			System.exit(0);
		} else {
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}
	}

	public void showDrinks(List<Drinks> drinks) {
		panelDrinks.removeAll();
		panelDrinks.updateUI();
		mapDrinks.clear();
		for (int i = 0; i < drinks.size(); i++) {
			Drinks model = drinks.get(i);
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(120, 135));
			panel.setBackground(Color.WHITE);
			JButton drink = new JButton();
			drink.setPreferredSize(new Dimension(130, 100));
			ImageIcon image = new ImageIcon(getClass().getResource(model.getImage()));
			drink.setIcon(new ImageIcon(getScaledImage(image.getImage(), 130, 100)));

			JLabel name = new JLabel(model.getName());
			panel.add(drink);
			panel.add(name);

			mapDrinks.put(model.getId(), drink);
			panelDrinks.add(panel);
		}
	}

	public void showCategories(List<Category> categories) {
		mapCategories = new HashMap<Long, JButton>();
		for (int i = 0; i < categories.size(); i++) {
			JButton button = new JButton(categories.get(i).getName());
			button.setPreferredSize(new Dimension(100, 30));
			mapCategories.put(categories.get(i).getId(), button);
			panelCategory.add(button);
		}
	}

	@SuppressWarnings("deprecation")
	public void showDrinkDetails(List<DrinkDetails> drinkDetails) {
		if (drinkDetails.size() > 0) {
			panelDrinkSelected.show();
			DrinkDetails d = drinkDetails.get(0);
			ImageIcon image = new ImageIcon(getClass().getResource(d.getDrink().getImage()));
			lblDrinkSelected.setIcon(new ImageIcon(getScaledImage(image.getImage(), 249, 208)));
			lblDrinkName.setText(d.getDrink().getName());
			lblDrinkPrice.setText(d.getPrice() + "");
			comboBoxSize.removeAllItems();
			for (int i = 0; i < drinkDetails.size(); i++) {
				comboBoxSize.addItem(drinkDetails.get(i).getSize().getName());
			}
		}
	}

	public void showPayments(List<Payment> payments) {
		ButtonGroup paymentGroup = new ButtonGroup();
		for (int i = 0; i < 3; i++) {
			JRadioButton payment = new JRadioButton("Tiền mặt");
			payment.setBackground(Color.WHITE);
			paymentGroup.add(payment);
			panelPayment.add(payment);
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public Map<Long, JButton> getMapCategories() {
		return mapCategories;
	}

	public Map<Long, JButton> getMapDrinks() {
		return mapDrinks;
	}

	public JButton getBtnAddToBill() {
		return btnAddToBill;
	}

	public JButton getBtnCheckout() {
		return btnCheckout;
	}

	public JButton getBtnRemoveDrink() {
		return btnRemoveDrink;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public JLabel getLblStaffName() {
		return lblStaffName;
	}

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();
		return resizedImg;
	}
}
