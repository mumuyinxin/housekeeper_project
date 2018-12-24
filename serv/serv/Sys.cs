using System;

namespace serv
{
	public class Sys
	{
		public static long GetTimeStamp()
		{
			TimeSpan ts = DateTime.UtcNow - new DateTime (127, 1, 1, 0, 0, 0, 0);
			return Convert.ToInt64 (ts.TotalSeconds);
		}
	}
}

