//聊天模块
public class chatModule {
	private int UserId;//用户Id
	private int MsgId;//消息Id
	private int AppId;//应用Id
	private int MsgPeopleId;//消息管家的消息好友Id（消息不一定全来自外部应用，也有消息管家本身的好友消息）
	private String MsgSubject;//来自应用的消息主体，比如是QQ中好友分组的小林发来的消息
	private String MsgText;//消息内容
	private int MsgGradeId;//消息等级Id，消息重要程度，可通过设置等级，使用不同颜色和次序
	private String MsgIcon;//来自应用的图标，这里存放的是地址
	
	private chatModule() {
	}

	private chatModule(int userId, int msgId, int appId, int msgPeopleId, String msgSubject, String msgText, int msgGradeId, String msgIcon) {
		this.UserId = userId;
		this.MsgId = msgId;
		this.AppId = appId;
		this.MsgPeopleId = msgPeopleId;
		this.MsgSubject = msgSubject;
		this.MsgText = msgText;
		this.MsgGradeId = msgGradeId;
		this.MsgIcon = msgIcon;
	}
	
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getMsgId() {
		return MsgId;
	}

	public void setMsgId(int msgId) {
		MsgId = msgId;
	}

	public int getAppId() {
		return AppId;
	}

	public void setAppId(int appId) {
		AppId = appId;
	}

	public int getMsgPeopleId() {
		return MsgPeopleId;
	}

	public void setMsgPeopleId(int msgPeopleId) {
		MsgPeopleId = msgPeopleId;
	}

	public String getMsgSubject() {
		return MsgSubject;
	}

	public void setMsgSubject(String msgSubject) {
		MsgSubject = msgSubject;
	}

	public String getMsgText() {
		return MsgText;
	}

	public void setMsgText(String msgText) {
		MsgText = msgText;
	}

	public int getMsgGradeId() {
		return MsgGradeId;
	}

	public void setMsgGradeId(int msgGradeId) {
		MsgGradeId = msgGradeId;
	}

	public String getMsgIcon() {
		return MsgIcon;
	}

	public void setMsgIcon(String msgIcon) {
		MsgIcon = msgIcon;
	}
	
}
