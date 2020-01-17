package banking.cilent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import banking.information.*;
import banking.server.*;
public class Admin_DelSuccess_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public Admin_DelSuccess_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5220\u9664\u6210\u529F\uFF01");
		label.setFont(new Font("楷体", Font.PLAIN, 99));
		label.setBounds(261, 149, 496, 120);
		contentPane.add(label);
		
		//返回首页
		JButton button = new JButton("\u8FD4\u56DE\u9996\u9875");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		button.setFont(new Font("楷体", Font.PLAIN, 43));
		button.setBounds(648, 384, 222, 64);
		contentPane.add(button);
	}

}
