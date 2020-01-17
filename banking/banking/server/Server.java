package banking.server;

import java.io.IOException;
import java.net.InetAddress;
import banking.information.*;
import banking.cilent.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int count = 0; //���������ж��ٸ��ͻ���
        Socket socket = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(8888);
            System.out.println("***�����������������ȴ��ͻ��˵�����***");
            //ѭ�������ȴ��ͻ��˵�����
            while (true) {
                try {
                    //�����ͻ��˵����󣬽��ճɹ��õ�һ��socket����
                    socket = server.accept();
                    //����һ�����߳�
                    ServerThread thread = new ServerThread(socket,server);
                    //�����߳�
                    thread.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println("�ͻ��˽��̸����� " + count);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("�ͻ��˵�IP��ַ�ǣ� " + inetAddress.getHostAddress());
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally { //�ر���Դ
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   
    }

}
