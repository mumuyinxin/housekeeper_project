using System;

namespace serv
{
	public class User
	{
		public string id;
		public Conn conn;
		public UserData data;
		public UserTempData tempData;
		public static User instance;

		public User (string id, Conn conn){
			instance = this;
			this.id = id;
			this.conn = conn;
			tempData = new UserTempData ();
		}

		public void Send(ProtocolBase proto){
			if (conn == null)
				return;
			ServNet.instance.Send (conn, proto);
		}

		public static bool kickOff(string id, ProtocolBase proto){
			Conn[] conns = ServNet.instance.conns;
			for (int i = 0; i < conns.Length; i++) {
				if (conns [i] == null)
					continue;
				if (!conns [i].isUse)
					continue;
				if (conns [i].user == null)
					continue;
				if (conns [i].user.id == id) {
					lock (conns[i].user) {
						if (proto != null)
							conns [i].user.Send (proto);
						return conns [i].user.Logout ();
					}
				}
			}
			return true;
		}

		public bool Logout(){
			if (!DataMgr.instance.SaveUser (this)) {
				return false;
			}
			conn.user = null;
			conn.Close ();
			return true;
		}

		public bool IsUser(string id){
			Conn[] conns = ServNet.instance.conns;
			for (int i = 0; i < conns.Length; i++) {
				if (conns [i] == null)
					continue;
				if (!conns [i].isUse)
					continue;
				if (conns [i].user == null)
					continue;
				if (conns [i].user.id == id) {
					return true;
				}
			}
			return false;
		}

		public Conn SearchUser(string id){
			Conn[] conns = ServNet.instance.conns;
			for (int i = 0; i < conns.Length; i++) {
				if (conns [i] == null)
					continue;
				if (!conns [i].isUse)
					continue;
				if (conns [i].user == null)
					continue;
				if (conns [i].user.id == id) {
					lock (conns[i].user) {
						return conns[i];
					}
				}	
			}
			return conns [0];
		}
	}
}

