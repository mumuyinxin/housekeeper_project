//设置模块
public class setModule {
	private int userId;
	private int setId;
	private int userDataId;//设置-用户详细资料Id
	private int manageAppId;//设置-管理应用Id
	private setModule_UserData setModule_UserData;
	private setModule_ManageApp setModule_ManageApp;
	
	public setModule() {
	}
	
	public setModule(int userId, int setId) {
		this.userId = userId;
		this.setId = setId;
	}

	public setModule(int userId, int setId, int userDataId, int manageAppId) {
		this.userId = userId;
		this.setId = setId;
		this.userDataId = userDataId;
		this.manageAppId = manageAppId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSetId() {
		return setId;
	}

	public void setSetId(int setId) {
		this.setId = setId;
	}

	public int getUserDataId() {
		return userDataId;
	}

	public void setUserDataId(int userDataId) {
		this.userDataId = userDataId;
	}

	public int getManageAppId() {
		return manageAppId;
	}

	public void setManageAppId(int manageAppId) {
		this.manageAppId = manageAppId;
	}

	public setModule_UserData getSetModule_UserData() {
		return setModule_UserData;
	}

	public void setSetModule_UserData() {
		this.setModule_UserData = new setModule_UserData(this.userDataId);
	}

	public setModule_ManageApp getSetModule_ManageApp() {
		return setModule_ManageApp;
	}

	public void setSetModule_ManageApp() {
		this.setModule_ManageApp = new setModule_ManageApp(this.manageAppId);
	}
	
}
