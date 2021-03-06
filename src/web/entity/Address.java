package web.entity;

public class Address {
	private Integer aId;
	private String aName;
	private String aTel;
	private String aProvince;
	private String aCity;
	private String aArea;
	private String aDetailAddr;
	private Integer vipId;
	public Address(Integer aId, String aName, String aTel, String aProvince, String aCity, String aArea,
			String aDetailAddr) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aTel = aTel;
		this.aProvince = aProvince;
		this.aCity = aCity;
		this.aArea = aArea;
		this.aDetailAddr = aDetailAddr;
	}
	@Override
	public String toString() {
		return "Address [aId=" + aId + ", aName=" + aName + ", aTel=" + aTel + ", aProvince=" + aProvince + ", aCity="
				+ aCity + ", aArea=" + aArea + ", aDetailAddr=" + aDetailAddr + ", vipId=" + vipId + "]";
	}
	public Address(String aName, String aTel, String aProvince, String aCity, String aArea, String aDetailAddr,
			Integer vipId) {
		super();
		this.aName = aName;
		this.aTel = aTel;
		this.aProvince = aProvince;
		this.aCity = aCity;
		this.aArea = aArea;
		this.aDetailAddr = aDetailAddr;
		this.vipId = vipId;
	}
	public Address(Integer aId, String aName, String aTel, String aProvince, String aCity, String aArea,
			String aDetailAddr, int vipId) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aTel = aTel;
		this.aProvince = aProvince;
		this.aCity = aCity;
		this.aArea = aArea;
		this.aDetailAddr = aDetailAddr;
		this.vipId = vipId;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getVipId() {
		return vipId;
	}
	public void setVipId(int vipId) {
		this.vipId = vipId;
	}
}
