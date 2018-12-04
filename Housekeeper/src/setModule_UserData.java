
public class setModule_UserData {
	private int UserId;
	private int UserNum;//用户账号
	private String UserName;
	private String UserSex;
	private String UserPhone;
	private int UserAge;
	private setModule_UserData() {
	}
	private setModule_UserData(int userId, int userNum, String userName, String userSex, String userPhone,
			int userAge) {
		UserId = userId;
		UserNum = userNum;
		UserName = userName;
		UserSex = userSex;
		UserPhone = userPhone;
		UserAge = userAge;
	}
	/**
	 * @return userId
	 */
	public int getUserId() {
		return UserId;
	}
	/**
	 * @param userId 要设置的 userId
	 */
	public void setUserId(int userId) {
		UserId = userId;
	}
	/**
	 * @return userNum
	 */
	public int getUserNum() {
		return UserNum;
	}
	/**
	 * @param userNum 要设置的 userNum
	 */
	public void setUserNum(int userNum) {
		UserNum = userNum;
	}
	/**
	 * @return userName
	 */
	public String getUserName() {
		return UserName;
	}
	/**
	 * @param userName 要设置的 userName
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}
	/**
	 * @return userSex
	 */
	public String getUserSex() {
		return UserSex;
	}
	/**
	 * @param userSex 要设置的 userSex
	 */
	public void setUserSex(String userSex) {
		UserSex = userSex;
	}
	/**
	 * @return userPhone
	 */
	public String getUserPhone() {
		return UserPhone;
	}
	/**
	 * @param userPhone 要设置的 userPhone
	 */
	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}
	/**
	 * @return userAge
	 */
	public int getUserAge() {
		return UserAge;
	}
	/**
	 * @param userAge 要设置的 userAge
	 */
	public void setUserAge(int userAge) {
		UserAge = userAge;
	}
	
	
}