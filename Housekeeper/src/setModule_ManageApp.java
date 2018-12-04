import java.util.ArrayList;
import java.util.List;

public class setModule_ManageApp {
	private int ManageAppId;//管理应用Id
	private List<Integer> AddAppId = new ArrayList<Integer>();//添加应用Id
	private List<Integer> ManageAppGroupId = new ArrayList<Integer>();//管理应用数组Id
	private int MsgManageId;//关联消息管理表Id
	
	private setModule_ManageApp() {
	}
	
	private setModule_ManageApp(int manageAppId, List<Integer> addAppId, List<Integer> manageAppGroupId, int msgManageId) {
		this.ManageAppId = manageAppId;
		this.AddAppId = addAppId;
		this.ManageAppGroupId = manageAppGroupId;
		this.MsgManageId = msgManageId;
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
	/**
	 * @return addAppId
	 */
	public List<Integer> getAddAppId() {
		return AddAppId;
	}
	/**
	 * @param addAppId 要设置的 addAppId
	 */
	public void addAddAppId(Integer addAppId) {
		AddAppId.add(addAppId);
	}
	/**
	 * @return manageAppGroupId
	 */
	public List<Integer> getManageAppGroupId() {
		return ManageAppGroupId;
	}
	/**
	 * @param manageAppGroupId 要设置的 manageAppGroupId
	 */
	public void addManageAppGroupId(Integer manageAppGroupId) {
		ManageAppGroupId.add(manageAppGroupId);
	}
	/**
	 * @return msgManageId
	 */
	public int getMsgManageId() {
		return MsgManageId;
	}
	/**
	 * @param msgManageId 要设置的 msgManageId
	 */
	public void setMsgManageId(int msgManageId) {
		MsgManageId = msgManageId;
	}
	
}
