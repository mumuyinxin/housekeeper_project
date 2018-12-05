//聊天模块
public class chatModule {
	private int userId;//用户Id
	private int msgId;//消息Id
	private int appId;//应用Id(来自外部消息应用的消息)
	private int msgPeopleId;//消息管家的消息好友Id（消息不一定全来自外部应用，也有消息管家本身的好友消息）
	private String msgSubject;//来自应用的消息主体，比如是QQ中好友分组的小林发来的消息，这里的主体就是QQ中好友分组的小林
	private String msgText;//消息内容
	private int msgGradeId;//消息等级Id，消息重要程度，可通过设置等级，使用不同颜色和次序
	private String msgIcon;//来自应用的图标，这里存放的是地址
	
	public chatModule() {
	}
	
	public chatModule(int userId,int msgId) {
		this.userId = userId;
		this.msgId = msgId;
	}
	
	public chatModule(int userId, int msgId, int appId, int msgPeopleId, String msgSubject, String msgText, int msgGradeId, String msgIcon) {
		this.userId = userId;
		this.msgId = msgId;
		this.appId = appId;
		this.msgPeopleId = msgPeopleId;
		this.msgSubject = msgSubject;
		this.msgText = msgText;
		this.msgGradeId = msgGradeId;
		this.msgIcon = msgIcon;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public int getMsgPeopleId() {
		return msgPeopleId;
	}

	public void setMsgPeopleId(int msgPeopleId) {
		this.msgPeopleId = msgPeopleId;
	}

	public String getMsgSubject() {
		return msgSubject;
	}

	public void setMsgSubject(String msgSubject) {
		this.msgSubject = msgSubject;
	}

	public String getMsgText() {
		return msgText;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}

	public int getMsgGradeId() {
		return msgGradeId;
	}

	public void setMsgGradeId(int msgGradeId) {
		this.msgGradeId = msgGradeId;
	}

	public String getMsgIcon() {
		return msgIcon;
	}

	public void setMsgIcon(String msgIcon) {
		this.msgIcon = msgIcon;
	}
	

}
