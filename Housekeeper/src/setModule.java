//设置模块
public class setModule {
	private int UserId;
	private int setId;
	private int userDataId;//设置-用户详细资料Id
	private int moneyId;//钱袋子Id
	private int ManageAppId;//设置-管理应用Id
	private setModule() {
	}

	private setModule(int userId, int setId, int userDataId, int moneyId, int manageAppId) {
		this.UserId = userId;
		this.setId = setId;
		this.userDataId = userDataId;
		this.moneyId = moneyId;
		this.ManageAppId = manageAppId;
	}

	/**
	 * @return setId
	 */
	public int getSetId() {
		return setId;
	}
	/**
	 * @param setId 要设置的 setId
	 */
	public void setSetId(int setId) {
		this.setId = setId;
	}
	/**
	 * @return userDataId
	 */
	public int getUserDataId() {
		return userDataId;
	}
	/**
	 * @param userDataId 要设置的 userDataId
	 */
	public void setUserDataId(int userDataId) {
		this.userDataId = userDataId;
	}
	/**
	 * @return moneyId
	 */
	public int getMoneyId() {
		return moneyId;
	}
	/**
	 * @param moneyId 要设置的 moneyId
	 */
	public void setMoneyId(int moneyId) {
		this.moneyId = moneyId;
	}
	/**
	 * @return manageAppId
	 */
	public int getManageAppId() {
		return ManageAppId;
	}
	/**
	 * @param manageAppId 要设置的 manageAppId
	 */
	public void setManageAppId(int manageAppId) {
		ManageAppId = manageAppId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	
}
