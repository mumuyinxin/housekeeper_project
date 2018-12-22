using System;

namespace serv
{
	class MainClass
	{
		public static void Main (string[] args)
		{
		/*	DataMgr dataMgr = new DataMgr ();

			bool ret = dataMgr.Register ("Lpy", "123");
			if (ret) {
				Console.WriteLine ("注册成功");
			} else {
				Console.WriteLine ("注册失败");
			}
			ret = dataMgr.CreatePlayer ("Lpy");
			if (ret) {
				Console.WriteLine ("创建玩家成功");
			} else {
				Console.WriteLine ("创建玩家失败");
			}

			PlayerData pd = dataMgr.GetPlayerData ("Lpy");

			if (pd != null) {
				Console.WriteLine ("获得玩家成功的分数是 " + pd.score);
			} else {
				Console.WriteLine ("获得玩家数据失败");
			}
			pd.score += 10;
			Player p = new Player ();
			p.id = "Lpy";
			p.data = pd;
			dataMgr.SavePlayer (p);
			pd = dataMgr.GetPlayerData ("Lpy");
			if (pd != null) {
				Console.WriteLine ("获得玩家成功的分数是 " + pd.score);
			} else {
				Console.WriteLine ("重新获得玩家数据失败");
			}*/

		//	Scene scene = new Scene ();
			DataMgr dataMgr = new DataMgr ();
			ServNet servNet = new ServNet ();
			servNet.proto = new ProtocolBytes ();
			servNet.Start("127.0.0.1", 1234);
			while (true) {
				string str = Console.ReadLine ();
				switch(str){
				case "quit":
					servNet.Close();
					return;
				case "print":
					servNet.Print ();
					break;
				}
			}
		}
	}		
}
