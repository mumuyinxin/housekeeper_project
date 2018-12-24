using System;

namespace serv
{
	public class HandleConnMsg
	{
		public void MsgHeatBeat(Conn conn, ProtocolBase protoBase)
		{
			conn.lastTickTime = Sys.GetTimeStamp();
			Console.WriteLine("[更新心跳时间]" + conn.GetAddress());
		}
			
		public void MsgRegister(Conn conn, ProtocolBase protoBase)
		{
			int start = 0;
			ProtocolBytes protocol = (ProtocolBytes)protoBase;
			string protoName = protocol.GetString (start, ref start);
			string id = protocol.GetString (start, ref start);
			string pw = protocol.GetString (start, ref start);
			string strFormat = "[收到注册协议]" + conn.GetAddress();
			Console.WriteLine ( strFormat  + " 用户名：" + id + " 密码：" + pw);
			protocol = new ProtocolBytes ();
			protocol.AddString ("Register");
			if(DataMgr.instance.Register (id, pw))
			{
				protocol.AddInt(0);
			}
			else
			{
				protocol.AddInt(-1);
			}
			DataMgr.instance.CreateUser (id);
			conn.Send (protocol);
		}

		public void MsgLogin(Conn conn, ProtocolBase protoBase)
		{
			//获取数值
			int start = 0;
			ProtocolBytes protocol = (ProtocolBytes)protoBase;
			string protoName = protocol.GetString (start, ref start);
			string id = protocol.GetString (start, ref start);
			string pw = protocol.GetString (start, ref start);
			string strFormat = "[收到登录协议]" + conn.GetAddress();
			Console.WriteLine (strFormat  + " 用户名：" + id + " 密码：" + pw);
			//构建返回协议
			ProtocolBytes protocolRet = new ProtocolBytes ();
			protocolRet.AddString ("Login");
			//验证
			if (!DataMgr.instance.CheckPassWord (id, pw)) 
			{
				protocolRet.AddInt(-1);
				conn.Send (protocolRet);
				return;
			}
			//是否已经登录
			ProtocolBytes protocolLogout = new ProtocolBytes ();
			protocolLogout.AddString ("Logout");
			if (!User.kickOff (id, protocolLogout)) 
			{
				protocolRet.AddInt(-1);
				conn.Send (protocolRet);
				return;
			}

			//获取数据
			UserData userData = DataMgr.instance.GetUserData (id);
			if (userData == null)
			{
				protocolRet.AddInt(-1);
				conn.Send (protocolRet);
				return;
			}
			conn.user = new User (id, conn);
			conn.user.data = userData;


			protocolRet.AddInt(0);
			conn.Send (protocolRet);
			return;
		}

		public void MsgLogout(Conn conn, ProtocolBase protoBase)
		{
			ProtocolBytes protocol = new ProtocolBytes ();
			protocol.AddString ("Logout");
			protocol.AddInt (0);
			if (conn.user == null) 
			{
				conn.Send (protocol);
				conn.Close ();
			}
			else 
			{
				conn.Send (protocol);
				conn.user.Logout();
			}
		}
	}
}

