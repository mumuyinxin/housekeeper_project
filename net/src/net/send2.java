package net;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class send2 {
	public static void main(String[] args) throws IOException {
		String host = "localhost"; 
		int port = 6000;
		// 与服务端建立连接
		Socket socket = new Socket(host, port);
		//socket.connect(new InetSocketAddress(host, port));
		String str = "1234";
        PrintStream out = new PrintStream(socket.getOutputStream());
        System.out.println("ready send info to server!!");
        out.println(str);
        System.out.println("send info to server: "+ str);
        //发送后断掉连接
        out.close();
	}
}
