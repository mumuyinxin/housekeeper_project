
public class app {
	private int appId;
	private String appName;
	private String appIcon;//应用图标地址
	private boolean ableApp;
	public app() {
		
	}
	
	public app(int appId, String appName, String appIcon) {
		super();
		this.appId = appId;
		this.appName = appName;
		this.appIcon = appIcon;
		this.ableApp = true;//默认应用是可以接受消息的，默认为true，设置黑名单时，将其设置为false，则不显示此应用消息
	}
		

	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppIcon() {
		return appIcon;
	}
	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon;
	}
	public boolean isAbleApp() {
		return ableApp;
	}
	public void setAbleApp(boolean ableApp) {
		this.ableApp = ableApp;
	}

}
