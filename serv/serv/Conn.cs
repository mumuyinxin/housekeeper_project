using System;
using System.Net;
using System.Net.Sockets;
using System.Collections;
using System.Collections.Generic;
using MySql.Data;
using MySql.Data.MySqlClient;
using System.Linq;
using System.Reflection;
using System.Threading;

namespace serv
{
	public class Conn
	{
		public const int BUFFER_SIZE = 1024;
		public Socket socket;
		public bool isUse = false;
		public byte[] readBuff = new byte[BUFFER_SIZE];
		public int buffCount = 0;
		public byte[] lenBytes = new byte[sizeof(UInt32)];//https://www.cnblogs.com/0515offer/archive/2015/01/20/4236169.html  Uint32最小值为0
		public Int32 msgLength;
		public long lastTickTime = long.MinValue;
		public User user;

		public Conn ()
		{
			readBuff = new byte[BUFFER_SIZE];
		}

		public void Init(Socket socket){
			this.socket = socket;
			isUse = true;
			buffCount = 0;
			lastTickTime = Sys.GetTimeStamp();
		}

		public int BuffRemain(){
			return BUFFER_SIZE - buffCount;
		}

		public string GetAddress(){
			if(!isUse)
				return "无法获取地址";
			return socket.RemoteEndPoint.ToString ();
		}

		public void Close(){
			if (!isUse) {
				return;
			}
			if (user != null) {
				user.Logout();
				return;
			}
			Console.WriteLine ("[断开连接]" + GetAddress());
			socket.Shutdown (SocketShutdown.Both);
			socket.Close ();
			isUse = false;
		}

		public void Send(ProtocolBase protocol){
			ServNet.instance.Send (this, protocol);
		}
	}
}

