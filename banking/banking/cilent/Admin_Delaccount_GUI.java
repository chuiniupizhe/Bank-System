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

public class Admin_Delaccount_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Delaccount_GUI frame = new Admin_Delaccount_GUI();
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
	public Admin_Delaccount_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u8F93\u5165\u60A8\u8981\u5220\u9664\u7684\u8D26\u6237\u5361\u53F7\uFF1A");
		label.setFont(new Font("楷体", Font.PLAIN, 30));
		label.setBounds(50, 100, 426, 54);
		contentPane.add(label);

		// 提示标签
		JLabel lblNewLabel = new JLabel("\u4E0D\u5B58\u5728\u8BE5\u8D26\u6237\uFF01");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 27));
		lblNewLabel.setBounds(715, 241, 235, 60);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);

		JLabel label_1 = new JLabel("\u5361\u53F7\uFF1A");
		label_1.setFont(new Font("楷体", Font.PLAIN, 43));
		label_1.setBounds(183, 241, 139, 60);
		contentPane.add(label_1);

		// 卡号
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(332, 241, 373, 60);
		contentPane.add(textField);

		// 删除按钮
		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(false);
				int i;
				int ID = Integer.parseInt(textField.getText());
				for (i = 0; i < Bank.getBank().getNumOfCustomers(); i++) {
					if (Bank.getBank().getCustomer(i).getAccount().getID() == ID) {
						break;
					}
				}
				if (i == Bank.getBank().getNumOfCustomers()) {
					lblNewLabel.setVisible(true);
				} else {
					Bank.getBank().delCustomer(i);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Admin_DelSuccess_GUI frame = new Admin_DelSuccess_GUI();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});

		button.setFont(new Font("楷体", Font.PLAIN, 60));
		button.setBounds(680, 390, 180, 66);
		contentPane.add(button);

	}
}
