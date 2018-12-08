package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class sendMessage {
	public static void main(String[] args) throws IOException {
		String host = "localhost"; 
		String host1 = "172.23.29.15"; 
		int port = 6000;
		// 与服务端建立连接
		Socket socket = new Socket(host1, port);
		//socket.connect(new InetSocketAddress(host, port));
		while(true){
	        try {
	            // 读Sock里面的数据
	            InputStream s = socket.getInputStream();
	            byte[] buf = new byte[1024];
	            int len = 0;
	            while ((len = s.read(buf)) != -1) {
	                System.out.println(new String(buf, 0, len));
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}
	
	public void Send(Socket socket) throws IOException {
		String str = "123";
        PrintStream out = new PrintStream(socket.getOutputStream());
        System.out.println("ready send info to server!!");
        out.println(str);
        System.out.println("send info to server: "+ str);
        out.close();
	}
}
