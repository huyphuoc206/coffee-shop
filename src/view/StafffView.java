package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import java.util.Locale.Category;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

import model.Drinks;
import model.Payment;

public class StafffView {

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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StafffView window = new StafffView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StafffView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1126, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelStaffName = new JPanel();
		panelStaffName.setBounds(12, -13, 271, 42);
		frame.getContentPane().add(panelStaffName);
		panelStaffName.setLayout(null);

		lblStaffName = new JLabel("Huy Phước");
		lblStaffName.setBounds(12, 21, 73, 18);
		panelStaffName.add(lblStaffName);

		btnExit = new JButton();
		btnExit.setBounds(103, 18, 82, 24);
		btnExit.setText("Thoát");
		panelStaffName.add(btnExit);

		panelDrinks = new JPanel();
		panelDrinks.setBackground(Color.WHITE);
		panelDrinks.setPreferredSize(new Dimension(415,428));
		panelDrinks.setBounds(12, 35, 415, 428);
		frame.getContentPane().add(panelDrinks);
		
		panelCategory = new JPanel();
		panelCategory.setBackground(Color.WHITE);
		panelCategory.setBounds(12, 475, 415, 79);
		frame.getContentPane().add(panelCategory);
		panelCategory.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));

		JPanel panelDrinkSelected = new JPanel();
		panelDrinkSelected.setBackground(Color.WHITE);
		panelDrinkSelected.setBounds(439, 35, 273, 519);
		frame.getContentPane().add(panelDrinkSelected);
		panelDrinkSelected.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("image");
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setBounds(12, 12, 249, 208);
		panelDrinkSelected.add(lblNewLabel);
		
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
		
		lblDrinkName = new JLabel("Cafe sữa");
		lblDrinkName.setForeground(Color.RED);
		lblDrinkName.setBounds(131, 256, 130, 27);
		panelDrinkSelected.add(lblDrinkName);
		
		lblDrinkPrice = new JLabel("25.000 VND");
		lblDrinkPrice.setForeground(Color.RED);
		lblDrinkPrice.setBounds(131, 304, 142, 27);
		panelDrinkSelected.add(lblDrinkPrice);
		
		comboBoxSize = new JComboBox<String>();
		comboBoxSize.setBounds(131, 352, 104, 24);
		panelDrinkSelected.add(comboBoxSize);
		
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
		
		showDrinks(null);
		showCategories(null);
		showPayments(null);
	}

	public void showDrinks(List<Drinks> drinks) {
		for (int i = 0; i < 15; i++) {
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(120, 135));
			panel.setBackground(Color.WHITE);
			JButton drink = new JButton();
			drink.setPreferredSize(new Dimension(130, 100));
			drink.setBackground(Color.BLACK);

			JLabel name = new JLabel("Cafe trứng");
			panel.add(drink);
			panel.add(name);
			panelDrinks.add(panel);
		}
	}
	
	public void showCategories(List<Category> categories) {
		for (int i = 0; i < 6; i++) {
			JButton button = new JButton("Trà đào");
			button.setPreferredSize(new Dimension(100, 30));
			panelCategory.add(button);
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
}
