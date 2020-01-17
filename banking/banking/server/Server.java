package banking.server;

import java.io.IOException;
import java.net.InetAddress;
import banking.information.*;
import banking.cilent.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int count = 0; //用来保存有多少个客户端
        Socket socket = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(8888);
            System.out.println("***服务器即将启动，等待客户端的连接***");
            //循环监听等待客户端的请求
            while (true) {
                try {
                    //监听客户端的请求，接收成功得到一个socket对象
                    socket = server.accept();
                    //创建一个新线程
                    ServerThread thread = new ServerThread(socket,server);
                    //启动线程
                    thread.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println("客户端进程个数： " + count);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("客户端的IP地址是： " + inetAddress.getHostAddress());
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally { //关闭资源
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   
    }

}
