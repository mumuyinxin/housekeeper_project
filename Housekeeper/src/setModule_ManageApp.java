import java.util.ArrayList;
import java.util.List;

public class setModule_ManageApp {
	private int manageAppId;//管理应用Id
	private List<Integer> addAppId = new ArrayList<Integer>();//添加应用Id
	private List<Integer> manageAppGroupId = new ArrayList<Integer>();//管理应用数组Id
	private int msgManageId;//关联消息管理表Id
	
	public setModule_ManageApp() {
	}
	
	public setModule_ManageApp(int manageAppId) {
		this.manageAppId = manageAppId;
	}
	
	public setModule_ManageApp(int manageAppId, List<Integer> addAppId, List<Integer> manageAppGroupId, int msgManageId) {
		this.manageAppId = manageAppId;
		this.addAppId = addAppId;
		this.manageAppGroupId = manageAppGroupId;
		this.msgManageId = msgManageId;
	}
	/**
	 * @return manageAppId
	 */
	public int getmanageAppId() {
		return manageAppId;
	}
	/**
	 * @param manageAppId 要设置的 manageAppId
	 */
	public void setmanageAppId(int manageAppId) {
		this.manageAppId = manageAppId;
	}
	/**
	 * @return addAppId
	 */
	public List<Integer> getaddAppId() {
		return addAppId;
	}
	/**
	 * @param addAppId 要设置的 addAppId
	 */
	public void addaddAppId(Integer addAppId) {
		this.addAppId.add(addAppId);
	}
	/**
	 * @return manageAppGroupId
	 */
	public List<Integer> getmanageAppGroupId() {
		return manageAppGroupId;
	}
	/**
	 * @param manageAppGroupId 要设置的 manageAppGroupId
	 */
	public void addmanageAppGroupId(Integer manageAppGroupId) {
		this.manageAppGroupId.add(manageAppGroupId);
	}
	/**
	 * @return msgManageId
	 */
	public int getmsgManageId() {
		return msgManageId;
	}
	/**
	 * @param msgManageId 要设置的 msgManageId
	 */
	public void setmsgManageId(int msgManageId) {
		this.msgManageId = msgManageId;
	}
	
}
