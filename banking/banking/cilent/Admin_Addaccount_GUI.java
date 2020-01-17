package banking.cilent;

import java.awt.BorderLayout;
import banking.information.*;
import banking.server.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Admin_Addaccount_GUI extends JFrame {

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
					Admin_Addaccount_GUI frame = new Admin_Addaccount_GUI();
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
	public Admin_Addaccount_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u60A8\u8981\u6DFB\u52A0\u7684\u8D26\u6237\u4FE1\u606F\uFF1A");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 30));
		lblNewLabel.setBounds(32, 75, 426, 54);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("\u8BE5\u8D26\u6237\u5DF2\u5B58\u5728\uFF01");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 27));
		lblNewLabel_2.setBounds(720, 196, 218, 60);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);

		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 43));
		lblNewLabel_1.setBounds(172, 293, 139, 60);
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("\u5361\u53F7\uFF1A");
		label.setFont(new Font("楷体", Font.PLAIN, 43));
		label.setBounds(172, 196, 139, 60);
		contentPane.add(label);

		// 账号
		textField = new JTextField();
		textField.setBounds(321, 196, 373, 60);
		contentPane.add(textField);
		textField.setColumns(10);

		// 姓名
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(321, 293, 373, 60);
		contentPane.add(textField_1);

		// 添加账户
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setVisible(false);
				int ID = Integer.parseInt(textField.getText());
				int i;
				for (i = 0; i < Bank.getBank().getNumOfCustomers(); i++) {
					if (Bank.getBank().getCustomer(i).getAccount().getID() == ID) {
						break;
					}
				}
				if (i < Bank.getBank().getNumOfCustomers()) {
					lblNewLabel_2.setVisible(true);
				} else {
					String name = textField_1.getText();
					int thisCustomerNum = Bank.getBank().getNumOfCustomers();
					Bank.getBank().addCustomer(name);
					Customer customer;
					customer = Bank.getBank().getCustomer(thisCustomerNum);
					customer.addAccount(new Account(0, ID, 123456));
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Admin_AddSuccess_GUI frame = new Admin_AddSuccess_GUI();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 60));
		btnNewButton.setBounds(683, 411, 180, 66);
		contentPane.add(btnNewButton);

	}
}
