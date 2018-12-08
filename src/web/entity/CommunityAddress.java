package web.entity;

public class CommunityAddress {
	private Integer vipId;
	private String vipName;
	private Community community;
	
	private Integer aId;
	private String aName;
	private String aTel;
	private String aProvince;
	private String aCity;
	private String aArea;
	private String aDetailAddr;
	@Override
	public String toString() {
		return "CommunityAddress [vipId=" + vipId + ", vipName=" + vipName + ", community=" + community + ", aId=" + aId
				+ ", aName=" + aName + ", aTel=" + aTel + ", aProvince=" + aProvince + ", aCity=" + aCity + ", aArea="
				+ aArea + ", aDetailAddr=" + aDetailAddr + "]";
	}
	public CommunityAddress(Integer vipId, String vipName, Community community, Integer aId, String aName, String aTel,
			String aProvince, String aCity, String aArea, String aDetailAddr) {
		super();
		this.vipId = vipId;
		this.vipName = vipName;
		this.community = community;
		this.aId = aId;
		this.aName = aName;
		this.aTel = aTel;
		this.aProvince = aProvince;
		this.aCity = aCity;
		this.aArea = aArea;
		this.aDetailAddr = aDetailAddr;
	}
	public CommunityAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getVipId() {
		return vipId;
	}
	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}
	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public Community getCommunity() {
		return community;
	}
	public void setCommunity(Community community) {
		this.community = community;
	}
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaTel() {
		return aTel;
	}
	public void setaTel(String aTel) {
		this.aTel = aTel;
	}
	public String getaProvince() {
		return aProvince;
	}
	public void setaProvince(String aProvince) {
		this.aProvince = aProvince;
	}
	public String getaCity() {
		return aCity;
	}
	public void setaCity(String aCity) {
		this.aCity = aCity;
	}
	public String getaArea() {
		return aArea;
	}
	public void setaArea(String aArea) {
		this.aArea = aArea;
	}
	public String getaDetailAddr() {
		return aDetailAddr;
	}
	public void setaDetailAddr(String aDetailAddr) {
		this.aDetailAddr = aDetailAddr;
	}

}
