package Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conn {
	//缓冲区长度
	public final int BUFFER_SIZE = 1024;
	//储存套接字
	public Socket socket;
	//这个conn是否被使用了
	public boolean isUse = false;
	//读缓冲区
	public byte[] readBuffer = new byte[BUFFER_SIZE];
	//缓冲区已使用长度标记
	public int buffCount = 0;
	//沾包处理，计算信息占用缓冲区的长度
	public byte[] lenBytes = new byte[4];
	//public User user;
	public int msgLength;
	
	public Conn(){
		//初始化缓冲区;
		readBuffer = new byte[BUFFER_SIZE];
	}
	//初始化
	public void Init(Socket socket) {
		this.socket = socket;
		isUse = true;
		buffCount = 0;
	}
	//缓冲区剩余空间
	public int BuffRemain() {
		return BUFFER_SIZE - buffCount;
	}
	
	public String GetAdress() {
		if(!isUse)
			return "无法获取地址";
		return socket.getInetAddress().toString();
	}
	
	public void Close() throws IOException {
		if(!isUse)
			return;
		//if(user != null){}
		System.out.println("[断开连接]:"+ GetAdress());
		socket.close();
		isUse = false;
	}
}
