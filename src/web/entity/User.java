package web.entity;

public class User {
	private int vipId;
	private String vipName;
	private String password;

	private int communityId;
	private Community community;

	private String vipPhone;
	private String aBalance;
	private String isLead;
	private String address;

	public int getVipId() {
		return vipId;
	}

	public void setVipId(int vipId) {
		this.vipId = vipId;
	}

	public String getVipName() {
		return vipName;
	}

	public void setVipName(String vipName) {
		this.vipName = vipName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public String getVipPhone() {
		return vipPhone;
	}

	public void setVipPhone(String vipPhone) {
		this.vipPhone = vipPhone;
	}

	public String getaBalance() {
		return aBalance;
	}

	public void setaBalance(String aBalance) {
		this.aBalance = aBalance;
	}

	public String getIsLead() {
		return isLead;
	}

	public void setIsLead(String isLead) {
		this.isLead = isLead;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [vipId=" + vipId + ", vipName=" + vipName + ", password=" + password + ", communityId="
				+ communityId + ", community=" + community + ", vipPhone=" + vipPhone + ", aBalance=" + aBalance
				+ ", isLead=" + isLead + ", address=" + address + "]";
	}

}
