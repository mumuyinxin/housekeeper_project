
public class setModule_Purse {
	private int moneyId;//钱袋子Id
	private int serviceNum;//服务范围用数字表示，限制服务应用个数，初始值为3
	
	private setModule_Purse() {
	}

	private setModule_Purse(int moneyId) {
		this.moneyId = moneyId;
		this.serviceNum = 3;
	}
	
	private setModule_Purse(int moneyId, int serviceNum) {
		this.moneyId = moneyId;
		this.serviceNum = serviceNum;
	}

	/**
	 * @return moneyId
	 */
	public int getMoneyId() {
		return moneyId;
	}

	/**
	 * @param moneyId 要设置的 moneyId
	 */
	public void setMoneyId(int moneyId) {
		this.moneyId = moneyId;
	}

	/**
	 * @return serviceNum
	 */
	public int getServiceNum() {
		return serviceNum;
	}

	/**
	 * @param serviceNum 要设置的 serviceNum
	 */
	public void setServiceNum(int serviceNum) {
		this.serviceNum = serviceNum;
	}
	
}
