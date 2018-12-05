
public class setModule_UserData {
	private int userId;
	private int userNum;//”√ªß’À∫≈
	private String userName;
	private String userSex;
	private String userPhone;
	private int userAge;
	public setModule_UserData() {
	}
	
	public setModule_UserData(int userId) {
		this.userId = userId;
	}
	
	public setModule_UserData(int userId, int userNum, String userName, String userSex, String userPhone, int userAge) {
		super();
		this.userId = userId;
		this.userNum = userNum;
		this.userName = userName;
		this.userSex = userSex;
		this.userPhone = userPhone;
		this.userAge = userAge;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	
	
}