package banking.cilent;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Cus_DeposSuccess_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public Cus_DeposSuccess_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u5B58\u6B3E\u6210\u529F\uFF01");
		label.setFont(new Font("楷体", Font.PLAIN, 99));
		label.setBounds(261, 149, 496, 120);
		contentPane.add(label);

		// 返回首页
		JButton button = new JButton("\u8FD4\u56DE\u9996\u9875");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		button.setFont(new Font("楷体", Font.PLAIN, 43));
		button.setBounds(648, 384, 222, 64);
		contentPane.add(button);
	}

}
