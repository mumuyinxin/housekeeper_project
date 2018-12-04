//每个联系人模块
public class contactsModule {
	private int UserId;
	private int friendId;
	private int friendGroupId;//联系人群组Id
	private String friendName;
	
	private contactsModule() {

	}

	private contactsModule(int userId, int friendId, int friendGroupId, String friendName) {
		this.UserId = userId;
		this.friendId = friendId;
		this.friendGroupId = friendGroupId;
		this.friendName = friendName;
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
	 * @return friendId
	 */
	public int getFriendId() {
		return friendId;
	}

	/**
	 * @param friendId 要设置的 friendId
	 */
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	/**
	 * @return friendGroupId
	 */
	public int getFriendGroupId() {
		return friendGroupId;
	}

	/**
	 * @param friendGroupId 要设置的 friendGroupId
	 */
	public void setFriendGroupId(int friendGroupId) {
		this.friendGroupId = friendGroupId;
	}

	/**
	 * @return friendName
	 */
	public String getFriendName() {
		return friendName;
	}

	/**
	 * @param friendName 要设置的 friendName
	 */
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	
}
