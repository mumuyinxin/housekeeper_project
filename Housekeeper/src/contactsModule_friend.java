
public class contactsModule_friend {
	private int friendId;
	private String friendName;
	private contactsModule_friend() {
	}
	private contactsModule_friend(int friendId, String friendName) {
		this.friendId = friendId;
		this.friendName = friendName;
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
