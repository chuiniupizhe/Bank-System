package banking.server;

import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import banking.information.*;
import banking.cilent.*;

public class 开始 {
	public static void main(String[] args) throws IOException {
		// 创建数据连接
		Socket s = new Socket("192.168.0.105", 8888);
		// 获取输出对象

		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];
		int len = is.read(bys);// 存取读取字节的个数
		String str = new String(bys, 0, len);

		String strnum[] = new String[1024];
		for (int i = 0; i < 1024; i++) {
			strnum[i] = "";

		}
		int numofcustomer = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ' || str.charAt(i) == '\n') {
				numofcustomer++;
			} else {
				strnum[numofcustomer] += str.charAt(i);
			}

		}

		Bank bank = Bank.getBank();
		Customer customer;

		int num = numofcustomer / 4;
		for (int i = 0; i < num; i++) {
			bank.addCustomer(strnum[i * 4 + 1]);
			customer = bank.getCustomer(i);
			customer.addAccount(new Account(Double.parseDouble(strnum[i * 4 + 3]), Integer.parseInt(strnum[i * 4]),
					Integer.parseInt(strnum[i * 4 + 2])));

		}

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
		s.close();
	}

}
