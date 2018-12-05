//每个联系人模块
public class contactsModule {
	private int userId;
	private int contactsId;
	private int friendId;
	private int friendGroupId;//联系人群组Id
	private String friendName;
	private contactsModule_friendGroup contactsModule_friendGroup;
	private contactsModule_friend contactsModule_friend;
	public contactsModule() {

	}
	
	public contactsModule(int userId, int contactsId) {
		this.userId = userId;
		this.contactsId = contactsId;
	}
	
	public contactsModule(int userId, int friendId, int friendGroupId, String friendName) {
		this.userId = userId;
		this.friendId = friendId;
		this.friendGroupId = friendGroupId;
		this.friendName = friendName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getContactsId() {
		return contactsId;
	}

	public void setContactsId(int contactsId) {
		this.contactsId = contactsId;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public int getFriendGroupId() {
		return friendGroupId;
	}

	public void setFriendGroupId(int friendGroupId) {
		this.friendGroupId = friendGroupId;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public contactsModule_friendGroup getContactsModule_friendGroup() {
		return contactsModule_friendGroup;
	}

	public void setContactsModule_friendGroup() {
		this.contactsModule_friendGroup = new contactsModule_friendGroup(this.friendGroupId);
	}

	public contactsModule_friend getContactsModule_friend() {
		return contactsModule_friend;
	}

	public void setContactsModule_friend() {
		this.contactsModule_friend = new contactsModule_friend(this.friendId);
	}

	
}
