package banking.cilent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banking.information.Bank;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cus_Password_GUI extends JFrame {

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
					Cus_Password_GUI frame = new Cus_Password_GUI();
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
	public Cus_Password_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		label.setFont(new Font("楷体", Font.PLAIN, 50));
		label.setBounds(362, 77, 300, 55);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u60A8\u7684\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 25));
		lblNewLabel.setBounds(159, 198, 204, 55);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\u518D\u6B21\u8F93\u5165\u60A8\u7684\u65B0\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("楷体", Font.PLAIN, 25));
		label_1.setBounds(109, 283, 250, 55);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u4E24\u6B21\u5BC6\u7801\u4E0D\u4E00\u81F4\uFF0C\u8BF7\u91CD\u65B0\u6838\u5BF9\uFF01");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 20));
		label_2.setBounds(711, 206, 286, 42);
		contentPane.add(label_2);
		label_2.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(385, 198, 327, 55);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(385, 283, 327, 55);
		contentPane.add(textField_1);
		
		//重新登入
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_2.setVisible(false);
				if(textField.getText().equals(textField_1.getText())) {
					int password=Integer.parseInt(textField.getText());
					Bank.getBank().getCustomer(Land_GUI.i).getAccount().setpassword(password);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Land_GUI frame = new Land_GUI();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				else {
					label_2.setVisible(true);
				}
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 29));
		button.setBounds(708, 406, 124, 55);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("\uFF08\u4FEE\u6539\u540E\uFF0C\u60A8\u9700\u8981\u91CD\u65B0\u767B\u5165\uFF09");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(708, 291, 268, 42);
		contentPane.add(lblNewLabel_1);
		

	}
}
