package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import model.Bill;
import model.BillDetails;
import model.Category;
import model.DrinkDetails;
import model.Drinks;
import model.LoginInfo;
import model.Payment;
import utils.CurrencyFormat;

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
	private JPanel panelDrinkSelected;
	private JLabel lblDrinkSelected;
	private JSpinner quantity;
	private Map<Long, JButton> mapCategories;
	private Map<Long, JButton> mapDrinks = new HashMap<Long, JButton>();
	private List<DrinkDetails> listDrinkDetails = new ArrayList<DrinkDetails>();
	private Map<Long, JRadioButton> mapPayments = new HashMap<Long, JRadioButton>();
	private JTable tableBill;
	private DefaultTableModel defaultTableModel;
	private Bill bill;

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
		ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo.png"));
		frame.setIconImage(logo.getImage());
		
		JPanel panelStaffName = new JPanel();
		panelStaffName.setBounds(12, -13, 318, 42);
		frame.getContentPane().add(panelStaffName);
		panelStaffName.setLayout(null);

		lblStaffName = new JLabel("Huy Phước");
		lblStaffName.setBounds(12, 21, 147, 18);
		panelStaffName.add(lblStaffName);

		btnExit = new JButton();
		btnExit.setBounds(177, 18, 129, 24);
		ImageIcon image = new ImageIcon(getClass().getResource("/images/logout.png"));
		btnExit.setIcon(new ImageIcon(getScaledImage(image.getImage(), 39, 20)));
		btnExit.setText("Thoát");
		btnExit.setFocusPainted(false);
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

		btnAddToBill = new JButton();
		btnAddToBill.setBounds(87, 457, 108, 38);
		btnAddToBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
		btnAddToBill.setText("Thêm");
		btnAddToBill.setFocusPainted(false);
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

		quantity = new JSpinner();
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

		btnCheckout = new JButton();
		btnCheckout.setBounds(229, 461, 151, 38);
		btnCheckout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pay-per-click.png"))); // NOI18N
		btnCheckout.setText("Thanh toán");
		btnCheckout.setFocusPainted(false);
		panelBill.add(btnCheckout);

		btnRemoveDrink = new JButton();
		btnRemoveDrink.setBounds(154, 331, 98, 38);
		btnRemoveDrink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rubbish-bin.png"))); // NOI18N
		btnRemoveDrink.setText("Xóa");
		btnRemoveDrink.setFocusPainted(false);
		panelBill.add(btnRemoveDrink);

		JLabel lbl1212 = new JLabel("Tổng tiền:");
		lbl1212.setBounds(16, 469, 91, 23);
		panelBill.add(lbl1212);

		lblTotalPrice = new JLabel("0");
		lblTotalPrice.setForeground(Color.RED);
		lblTotalPrice.setBounds(95, 473, 144, 15);
		panelBill.add(lblTotalPrice);

		panelPayment = new JPanel();
		panelPayment.setBackground(Color.WHITE);
		panelPayment.setBounds(14, 411, 366, 38);
		panelBill.add(panelPayment);

		JPanel panelTable = new JPanel();
		panelTable.setBounds(2, 12, 385, 294);
		panelBill.add(panelTable);
		String[] columnNames = { "STT", "Tên", "Size", "Giá", "SL", "Tổng" };
		tableBill = new JTable();
		tableBill.setBounds(16, 12, 362, 294);
		defaultTableModel = new DefaultTableModel(null, columnNames);
		tableBill.setModel(defaultTableModel);
		ListSelectionModel listSelectionModel = tableBill.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		TableColumnModel columnModel = tableBill.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(35);
		columnModel.getColumn(0).setCellRenderer(centerRenderer);
		columnModel.getColumn(1).setPreferredWidth(110);
		columnModel.getColumn(2).setPreferredWidth(40);
		columnModel.getColumn(2).setCellRenderer(centerRenderer);
		columnModel.getColumn(3).setPreferredWidth(70);
		columnModel.getColumn(3).setCellRenderer(rightRenderer);
		columnModel.getColumn(4).setPreferredWidth(30);
		columnModel.getColumn(4).setCellRenderer(centerRenderer);
		columnModel.getColumn(5).setPreferredWidth(90);
		columnModel.getColumn(5).setCellRenderer(rightRenderer);
		panelTable.add(tableBill.getTableHeader());
		panelTable.add(tableBill);
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
			drink.setFocusPainted(false);
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
			button.setFocusPainted(false);
			mapCategories.put(categories.get(i).getId(), button);
			panelCategory.add(button);
		}
	}

	@SuppressWarnings("deprecation")
	public void showDrinkDetails(List<DrinkDetails> drinkDetails) {
		listDrinkDetails.clear();
		if (drinkDetails.size() > 0) {
			panelDrinkSelected.show();
			DrinkDetails d = drinkDetails.get(0);
			ImageIcon image = new ImageIcon(getClass().getResource(d.getDrink().getImage()));
			lblDrinkSelected.setIcon(new ImageIcon(getScaledImage(image.getImage(), 249, 208)));
			lblDrinkName.setText(d.getDrink().getName());
			lblDrinkPrice.setText(CurrencyFormat.format(d.getPrice()));
			comboBoxSize.removeAllItems();
			for (int i = 0; i < drinkDetails.size(); i++) {
				comboBoxSize.addItem(drinkDetails.get(i).getSize().getName());
				listDrinkDetails.add(drinkDetails.get(i));
			}
		}
	}

	public void resetComboBox() {
		comboBoxSize.setSelectedIndex(0);
	}

	public void updateSize(DrinkDetails d) {
		lblDrinkPrice.setText(CurrencyFormat.format(d.getPrice()));
		quantity.setValue(1);
	}

	public void showPayments(List<Payment> payments) {
		ButtonGroup paymentGroup = new ButtonGroup();
		for (int i = 0; i < payments.size(); i++) {
			Payment model = payments.get(i);
			JRadioButton payment = new JRadioButton(model.getName());
			payment.setBackground(Color.WHITE);
			if (i == 0)
				payment.setSelected(true);
			mapPayments.put(model.getId(), payment);
			paymentGroup.add(payment);
			panelPayment.add(payment);
		}
	}

	public void showBill(DrinkDetails drinkDetails) {
		if (bill == null) {
			initBill();
		}
		BillDetails billDetails = new BillDetails();
		billDetails.setDrinkDetails(drinkDetails);
		billDetails.setQuantity((int) quantity.getValue());
		bill.addBillDetails(billDetails);
		loadBill();
	}

	private void loadBill() {
		defaultTableModel.setRowCount(0);
		int index = 1;
		for (BillDetails item : bill.getBillDetails()) {
			DrinkDetails d = item.getDrinkDetails();
			defaultTableModel.addRow(new Object[] { index, d.getDrink().getName(), d.getSize().getName(),
					CurrencyFormat.format(d.getPrice()), item.getQuantity(),
					CurrencyFormat.format(item.getQuantity() * d.getPrice()) });
			index++;
		}
		lblTotalPrice.setText(CurrencyFormat.format(bill.calTotalPrice()));
	}

	public void removeDrink(int index) {
		bill.removeBillDetail(index);
		loadBill();
	}

	private void initBill() {
		bill = new Bill();
		bill.setStaffId(LoginInfo.USER_ID);
		bill.setStatus("0");
	}

	@SuppressWarnings("deprecation")
	public void clearAfterCheckout() {
		panelDrinkSelected.hide();
		defaultTableModel.setRowCount(0);
		bill = null;
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

	public Map<Long, JRadioButton> getMapPayments() {
		return mapPayments;
	}

	public List<DrinkDetails> getListDrinkDetails() {
		return listDrinkDetails;
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

	public JTable getTableBill() {
		return tableBill;
	}

	public JLabel getLblStaffName() {
		return lblStaffName;
	}

	public JComboBox<String> getComboBoxSize() {
		return comboBoxSize;
	}

	public JSpinner getQuantity() {
		return quantity;
	}

	public Bill getBill() {
		return bill;
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
