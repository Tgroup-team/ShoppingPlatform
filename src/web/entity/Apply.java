package web.entity;

import java.util.Date;

public class Apply {
	private Integer applyId;
	private Integer communityId;
	private Integer vipId;
	private Date rappl;
	private String deal;
	private Date dealtime;

	private Community community;
	private User user;

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public Integer getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}

	public Integer getVipId() {
		return vipId;
	}

	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}

	public Date getRappl() {
		return rappl;
	}

	public void setRappl(Date rappl) {
		this.rappl = rappl;
	}

	public String getDeal() {
		return deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}

	public Date getDealtime() {
		return dealtime;
	}

	public void setDealtime(Date dealtime) {
		this.dealtime = dealtime;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Apply [applyId=" + applyId + ", communityId=" + communityId + ", vipId=" + vipId + ", rappl=" + rappl
				+ ", deal=" + deal + ", dealtime=" + dealtime + ", community=" + community + ", user=" + user + "]";
	}
	
	

}
