
public class App {
	private int AppId;
	private String AppName;
	private String AppIcon;//应用图标地址
	private App() {
	}
	private App(int appId, String appName, String appIcon) {
		AppId = appId;
		AppName = appName;
		AppIcon = appIcon;
	}
	/**
	 * @return appId
	 */
	public int getAppId() {
		return AppId;
	}
	/**
	 * @param appId 要设置的 appId
	 */
	public void setAppId(int appId) {
		AppId = appId;
	}
	/**
	 * @return appName
	 */
	public String getAppName() {
		return AppName;
	}
	/**
	 * @param appName 要设置的 appName
	 */
	public void setAppName(String appName) {
		AppName = appName;
	}
	/**
	 * @return appIcon
	 */
	public String getAppIcon() {
		return AppIcon;
	}
	/**
	 * @param appIcon 要设置的 appIcon
	 */
	public void setAppIcon(String appIcon) {
		AppIcon = appIcon;
	}
	
}
