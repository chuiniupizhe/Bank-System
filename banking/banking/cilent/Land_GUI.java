package banking.cilent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import banking.information.*;
import banking.server.*;
public class Land_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public Land_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X  X  \u94F6\u884C");
		lblNewLabel.setFont(new Font("ø¨ÃÂ", Font.PLAIN, 34));
		lblNewLabel.setBounds(426, 66, 186, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("ø¨ÃÂ", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(278, 192, 111, 54);
		contentPane.add(lblNewLabel_1);
		
		//’À∫≈text
		textField = new JTextField();
		textField.setBounds(413, 192, 330, 54);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//√‹¬Îtext
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(413, 268, 330, 54);
		contentPane.add(textField_1);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setFont(new Font("ø¨ÃÂ", Font.PLAIN, 36));
		label.setBounds(278, 268, 111, 54);
		contentPane.add(label);
		
		//≤ª¥Ê‘⁄∏√’Àªß
		JLabel lblNewLabel_2 = new JLabel("\u4E0D\u5B58\u5728\u8BE5\u8D26\u6237\uFF01");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("ø¨ÃÂ", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(753, 199, 162, 37);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		//√‹¬Î¥ÌŒÛ
		JLabel label_1 = new JLabel("\u5BC6\u7801\u9519\u8BEF\uFF01");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("ø¨ÃÂ", Font.PLAIN, 20));
		label_1.setBounds(750, 275, 162, 37);
		contentPane.add(label_1);
		label_1.setVisible(false);
		
		//µ«»Î∞¥≈•
		JButton btnNewButton = new JButton("\u767B\u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setVisible(false);
				label_1.setVisible(false);
				String text=textField.getText();
				if(text.equals("admin")) {
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
				else {
					int b;//◊˜Œ™¥ÌŒÛ–Ú∫≈
					int a=Integer.parseInt(textField.getText());
					for ( i = 0; i < Bank.getBank().getNumOfCustomers(); i++) {
						if(Bank.getBank().getCustomer(i).getAccount().getID()==a) {
							break;
						}
					}
					if(i==Bank.getBank().getNumOfCustomers()) {
						b=0;//∏√’À∫≈≤ª¥Ê‘⁄
					}
					else if(Integer.parseInt(textField_1.getText())==Bank.getBank().getCustomer(i).getAccount().getpassword()) {
						b=2;//√ª”–¥ÌŒÛ
					}
					else {
						b=1;//√‹¬Î¥ÌŒÛ
					}
						
					
					//≈–∂œ’À∫≈º∞√‹¬Î
					if(b==2) {
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
					else if(b==0) {//≈–∂œ’Àªß «∑Ò¥Ê‘⁄
						lblNewLabel_2.setVisible(true);
						
					}
					else {
						label_1.setVisible(true);
						
					}
				}
			}
		});
		btnNewButton.setFont(new Font("ø¨ÃÂ", Font.PLAIN, 29));
		btnNewButton.setBounds(682, 407, 124, 55);
		contentPane.add(btnNewButton);
		
	}
}
