package banking.cilent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import banking.information.Bank;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cus_Transfer_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cus_Transfer_GUI frame = new Cus_Transfer_GUI();
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
	public Cus_Transfer_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8F6C  \u8D26");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 80));
		lblNewLabel.setBounds(358, 44, 296, 97);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("\u4E0D\u5B58\u5728\u8BE5\u8D26\u6237\uFF01");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(726, 183, 211, 54);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);

		JLabel lblNewLabel_1 = new JLabel("\u8F6C\u8D26\uFF1A");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(177, 261, 145, 54);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(313, 261, 323, 54);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("\u5143");
		label.setFont(new Font("楷体", Font.PLAIN, 40));
		label.setBounds(645, 261, 71, 54);
		contentPane.add(label);

		JLabel lblNewLabel_2 = new JLabel("\u4F59\u989D\u4E0D\u8DB3\uFF01");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(726, 261, 220, 54);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);

		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setVisible(false);
				lblNewLabel_3.setVisible(false);
				int i;
				for (i = 0; i < Bank.getBank().getNumOfCustomers(); i++) {
					if (Bank.getBank().getCustomer(i).getAccount().getID() == Integer.parseInt(textField_1.getText())) {
						break;
					}
				}
				if (i == Bank.getBank().getNumOfCustomers()) {
					lblNewLabel_3.setVisible(true);
				} 
				else {
				if (Bank.getBank().getCustomer(Land_GUI.i).getAccount()
						.transfer(Integer.parseInt(textField_1.getText()), Double.parseDouble(textField.getText()))) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Cus_TransSuccess_GUI frame = new Cus_TransSuccess_GUI();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else {
					lblNewLabel_2.setVisible(true);
				}
				}
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 50));
		btnNewButton.setBounds(626, 338, 220, 97);
		contentPane.add(btnNewButton);

		JLabel label_1 = new JLabel("\u5361\u53F7\uFF1A");
		label_1.setFont(new Font("楷体", Font.PLAIN, 40));
		label_1.setBounds(177, 183, 145, 54);
		contentPane.add(label_1);

		//卡号
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(313, 183, 323, 54);
		contentPane.add(textField_1);
		


	
	}

}
