package banking.server;

import banking.information.*;
import banking.cilent.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RecouversDamo {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		Socket s = ss.accept();
		OutputStream p = s.getOutputStream();
		String pathname = "test.txt";
		String txt = "";
		try (FileReader reader = new FileReader(pathname); BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				line += "\n";
				txt += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.write(txt.getBytes());
		// ��������������
		s = ss.accept();
		InputStream is = s.getInputStream();
		// ��ȡ����
		byte[] bys = new byte[1024];
		int len = is.read(bys);
		try {
			File writeName = new File("test.txt");
			writeName.createNewFile();
			try (FileWriter writer = new FileWriter(writeName); BufferedWriter out = new BufferedWriter(writer)) {
				out.write(new String(bys, 0, len));
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		s.close();
		ss.close();
		is.close();
	}
}
