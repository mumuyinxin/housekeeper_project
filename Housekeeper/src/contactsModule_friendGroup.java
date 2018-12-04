public class contactsModule_friendGroup {
	private int friendGroupId;//所有联系人群组Id
	private int friendGroupName;//联系人群组名称
	private contactsModule_friendGroup() {
	}
	private contactsModule_friendGroup(int friendGroupId, int friendGroupName) {
		this.friendGroupId = friendGroupId;
		this.friendGroupName = friendGroupName;
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
	 * @return friendGroupName
	 */
	public int getFriendGroupName() {
		return friendGroupName;
	}
	/**
	 * @param friendGroupName 要设置的 friendGroupName
	 */
	public void setFriendGroupName(int friendGroupName) {
		this.friendGroupName = friendGroupName;
	}
	
	
}
