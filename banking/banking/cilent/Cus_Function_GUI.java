package banking.cilent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banking.information.Bank;
import banking.server.开始;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class Cus_Function_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cus_Function_GUI frame = new Cus_Function_GUI();
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
	public Cus_Function_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uFF1A\u60A8\u597D\uFF01");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 50));
		lblNewLabel.setBounds(219, 148, 217, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(Bank.getBank().getCustomer(Land_GUI.i).getName());
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(58, 148, 164, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u4F59\u989D\uFF1A");
		label.setFont(new Font("楷体", Font.PLAIN, 50));
		label.setBounds(216, 245, 235, 55);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8D26\u6237\u4FE1\u606F");
		label_1.setFont(new Font("楷体", Font.PLAIN, 50));
		label_1.setBounds(380, 37, 300, 55);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(Bank.getBank().getCustomer(Land_GUI.i).getAccount().getBalance()+""+" 元");
		label_2.setFont(new Font("楷体", Font.PLAIN, 50));
		label_2.setBounds(405, 245, 286, 55);
		contentPane.add(label_2);
		
		//修改密码
		JButton btnNewButton = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 35));
		btnNewButton.setBounds(24, 369, 198, 74);
		contentPane.add(btnNewButton);
		
		//存款
		JButton button = new JButton("\u5B58\u6B3E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		button.setFont(new Font("楷体", Font.PLAIN, 35));
		button.setBounds(253, 369, 198, 74);
		contentPane.add(button);
		
		//取款
		JButton button_1 = new JButton("\u53D6\u6B3E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Cus_Withdraw_GUI frame = new Cus_Withdraw_GUI();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 35));
		button_1.setBounds(493, 369, 198, 74);
		contentPane.add(button_1);
		
		//转账
		JButton button_2 = new JButton("\u8F6C\u8D26");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 35));
		button_2.setBounds(735, 369, 198, 74);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Socket s = new Socket("192.168.0.105", 8888);
					String txt = "";
					for (int i = 0; i < Bank.getBank().getNumOfCustomers(); i++) {
						String name = Bank.getBank().getCustomer(i).getName();
						String ID = Bank.getBank().getCustomer(i).getAccount().getID() + "";
						String balance = Bank.getBank().getCustomer(i).getAccount().getBalance() + "";
						String password = Bank.getBank().getCustomer(i).getAccount().getpassword() + "";
						txt = txt + ID + " " + name + " " + password + " " + balance + "\n";

					}

					// 发送数据
					OutputStream os = s.getOutputStream();
					os.write(txt.getBytes());
					s.close();
					os.close();
				} catch (UnknownHostException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		button_3.setFont(new Font("楷体", Font.PLAIN, 35));
		button_3.setBounds(380, 464, 198, 74);
		contentPane.add(button_3);
	}
}
