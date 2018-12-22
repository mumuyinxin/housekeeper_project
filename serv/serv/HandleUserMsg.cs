using System;

namespace serv
{
	public partial class HandleUserMsg
	{
		public void MsgSendMessage(User user, ProtocolBase protoBase){
			int start = 0;
			ProtocolBytes protocol = (ProtocolBytes)protoBase;
			string protoName = protocol.GetString (start, ref start);
			string userId = protocol.GetString (start, ref start);
			string message = protocol.GetString (start, ref start);
			ProtocolBytes protocolRet = new ProtocolBytes ();
			protocolRet.AddString ("SendMessage");
			protocolRet.AddString (user.id);
			protocolRet.AddString (message);
			if (user.IsUser (userId) == true) {
				Conn conn = user.SearchUser (userId);
				ServNet.instance.Send (conn, protocolRet);
			} else {
				return;
			}
		}
	}
}

