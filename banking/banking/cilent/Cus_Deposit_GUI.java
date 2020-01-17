package banking.cilent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import banking.information.Bank;

public class Cus_Deposit_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cus_Deposit_GUI frame = new Cus_Deposit_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cus_Deposit_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5B58  \u6B3E");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 80));
		lblNewLabel.setBounds(358, 44, 296, 97);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5B58\u6B3E\uFF1A");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(177, 218, 145, 54);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(313, 218, 323, 54);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("\u5143");
		label.setFont(new Font("楷体", Font.PLAIN, 40));
		label.setBounds(646, 218, 71, 54);
		contentPane.add(label);

		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Bank.getBank().getCustomer(Land_GUI.i).getAccount()
						.deposit(Double.parseDouble(textField.getText()))) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Cus_DeposSuccess_GUI frame = new Cus_DeposSuccess_GUI();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 50));
		btnNewButton.setBounds(626, 338, 220, 97);
		contentPane.add(btnNewButton);

	}
}
