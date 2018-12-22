using System;
using MySql.Data;
using MySql.Data.MySqlClient;
using System.Data;
using System.Text.RegularExpressions;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.IO;

namespace serv
{
	public class DataMgr
	{
		MySqlConnection sqlConn;

		public static DataMgr instance;

		public DataMgr ()
		{
			instance = this;//单例模式
			Connect ();
		}//单例模式,调用connect

		public void Connect(){
			string connStr = "server=localhost;Database=test_soft;UID=root;Password=1234;";
			sqlConn = new MySqlConnection (connStr);
			try{
				sqlConn.Open();
			}catch(Exception e){
				Console.Write ("[DataMgr]Connect " + e.Message);
				return;
			}
		}//连接数据库

		public bool IsSafeStr (string str){
			return !Regex.IsMatch (str, @"[-|;|,|\/|\(|\)|\[|\]|\{|\}|%|@|\*|!|\']");
		}//检测非法字符

		private bool CanRegister(string id){
			if (!IsSafeStr(id)) {
				return false;
			}

			string cmdStr = string.Format ("select * from user where id = '{0}';", id);
			MySqlCommand cmd = new MySqlCommand (cmdStr, sqlConn);
			try{
				MySqlDataReader dataReader = cmd.ExecuteReader ();
				bool hasRows = dataReader.HasRows;//datareader.HasRows 只是检则库中是否有记录,如果有则返回true
				dataReader.Close();
				return !hasRows;
			}catch(Exception e){
				Console.WriteLine ("[DataMgr]CanRegister fail " + e.Message);
				return false;
			}
		}//检测这个账号是否能注册

		public bool Register(string id, string pw){
			if (!IsSafeStr (id) || !IsSafeStr (pw)) {
				Console.WriteLine ("[DataMgr]Register 使用非法字符");
				return false;
			}
			if (!CanRegister(id)) {
				Console.WriteLine ("[DataMgr]Register !CanRegister");
				return false;
			}
			string cmdStr = string.Format ("insert into user set id = '{0}' , pw = '{1}';", id, pw);
			MySqlCommand cmd = new MySqlCommand (cmdStr, sqlConn);
			try{
				cmd.ExecuteNonQuery();
				return true;
			}catch(Exception e){
				Console.WriteLine ("[DataMgr]Register " + e.Message);
				return false;
			}
		}//插入sql语句并运行

		public bool CreateUser(string id){
			if (!IsSafeStr (id)) {
				return false;
			}
			IFormatter formatter = new BinaryFormatter ();
			MemoryStream stream = new MemoryStream ();
			UserData userData = new UserData ();
			try{
				formatter.Serialize(stream,userData);//将playerData转化成stream字节流
			}catch(Exception e){
				Console.WriteLine ("[DataMgr]CreateUser 序列化 " + e.Message);
				return false;
			}
			byte[] byteArr = stream.ToArray();//将字节流转换成byte
			string cmdStr = string.Format ("insert into data set id = '{0}' , data = @data;" ,id);//sql语句
			MySqlCommand cmd = new MySqlCommand (cmdStr, sqlConn);
			cmd.Parameters.Add ("@data", MySqlDbType.Blob);//给cmd添加一个名为@data的二进制数据（Blod）参数
			cmd.Parameters[0].Value = byteArr;//给cmd赋值
			try{
				cmd.ExecuteNonQuery();
				return true;
			}catch(Exception e){
				Console.WriteLine("[DataMgr]CreateUser 写入 " + e.Message);
				return false;
			}
		}//将playerData转化成stream字节流，将字节流转换成byte，给cmd添加一个名为@data的二进制数据（Blod）参数，给cmd赋值

		public bool CheckPassWord(string id, string pw){
			if(!IsSafeStr(id) || !IsSafeStr(pw)){
				return false;
			}
			string cmdStr = string.Format ("select * from user where id = '{0}' and pw = '{1}';", id, pw);
			MySqlCommand cmd = new MySqlCommand (cmdStr, sqlConn);
			try{
				MySqlDataReader dataReader = cmd.ExecuteReader();
				bool hasRows = dataReader.HasRows;
				dataReader.Close();
				return hasRows;
			}catch(Exception e){
				Console.WriteLine ("[DataMgr]CheckPassWord " + e.Message);
				return false;
			}
		}//检查密码是否能通过

		public UserData GetUserData(string id){
			UserData userData = null;
			if (!IsSafeStr (id)) {
				return userData;
			}
			string cmdStr = string.Format ("select * from data where id = '{0}';", id);//寻找玩家id的sql语句
			MySqlCommand cmd = new MySqlCommand (cmdStr, sqlConn);
			byte[] buffer = new byte[1];
			try{
				MySqlDataReader dataReader = cmd.ExecuteReader();
				if(!dataReader.HasRows){
					dataReader.Close();
					return userData;
				}//datareader.HasRows只是检则库中是否有记录,如果有则返回true
				dataReader.Read();
				long len = dataReader.GetBytes(1,0,null,0,0);//将缓冲区设置为null，1代表第二段字符
				//五个参数分别代表：从零开始列序号，在下述语句中0代表id，1代表data；字段中的索引，从其开始读作操作
				//要将字节流读入的缓冲区；buffer中写入操作	开始的索引；要复制到缓冲区中的最大长度
				//返回值读取的实际字节数
				buffer = new byte[len];//len长度的缓冲区
				dataReader.GetBytes(1, 0, buffer, 0, (int)len);//将数据保存到buffer缓存区
				dataReader.Close();
			}catch(Exception e){
				Console.WriteLine ("[DataMgr]GetUserData 查询 " + e.Message);
				return userData;
			}

			MemoryStream stream = new MemoryStream (buffer);//将buffer转换成stream
			try{
				BinaryFormatter formatter = new BinaryFormatter();
				userData = (UserData)formatter.Deserialize(stream);//将stream反序列化成playerdata对象
				return userData;
			}catch(Exception e){
				Console.WriteLine ("[DataMgr]GetUserData 反序列化 " + e.Message);
				return userData;
			}
		}//获得玩家数据

		public bool SaveUser(User user){
			string id = user.id;
			UserData userData = user.data;
			IFormatter formatter = new BinaryFormatter ();
			MemoryStream stream = new MemoryStream ();
			try{
				formatter.Serialize(stream, userData);//将playerData转化成字节
			}catch(Exception e){
				Console.WriteLine ("[DataMgr]SaveUser 序列化 " + e.Message);
				return false;
			}
			byte[] byteArr = stream.ToArray ();//将stream转换成byte

			string formatStr = "update data set data = @data where id = '{0}';";
			string cmdStr = string.Format(formatStr ,user.id);
			MySqlCommand cmd = new MySqlCommand (cmdStr, sqlConn);
			cmd.Parameters.Add("@data", MySqlDbType.Blob);
			cmd.Parameters[0].Value = byteArr;
			try{
				cmd.ExecuteNonQuery();
				return true;
			}catch(Exception e){
				Console.WriteLine("[DataMgr]SaveUser 写入 " + e.Message);
				return false;
			}
		}
	}
}