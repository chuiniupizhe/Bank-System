package banking.cilent;

import java.awt.BorderLayout;
import banking.information.*;
import banking.server.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class Admin_GUI extends JFrame {

	private JPanel contentPane;
	private static int visible=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_GUI frame = new Admin_GUI();
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
	public Admin_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String txt="ID             姓名       密码   余额   \n";
		for (int i = 0; i < Bank.getBank().getNumOfCustomers(); i++) {
			String name=Bank.getBank().getCustomer(i).getName();
			String ID=Bank.getBank().getCustomer(i).getAccount().getID()+"";
			String balance=Bank.getBank().getCustomer(i).getAccount().getBalance()+"";
			String password=Bank.getBank().getCustomer(i).getAccount().getpassword()+"";
			txt=txt+ID+" "+name+" "+password+" "+balance+"\n";
			
		}
		JTextArea textArea = new JTextArea(50,50);
		textArea.setBounds(10, 10, 775, 543);
		contentPane.add(textArea);
		textArea.setText(txt);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u8D26\u6237");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				visible=1;
			}
		});
		btnNewButton.setBounds(811, 107, 97, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u8D26\u6237");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnNewButton_1.setBounds(811, 180, 97, 34);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
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
		button.setBounds(811, 498, 97, 34);
		contentPane.add(button);
	}
}
