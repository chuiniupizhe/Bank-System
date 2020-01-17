package banking.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import banking.information.*;
import banking.cilent.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{
    //和本线程相关的socket
    private Socket s;
    ServerSocket ss;

    public ServerThread(Socket socket,ServerSocket ss) {
        this.s = socket;
        this.ss=ss;
    }
    @Override
    public void run() {
        try {
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
    		s = ss.accept();
    		InputStream is = s.getInputStream();
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
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
}
