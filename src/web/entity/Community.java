package web.entity;

public class Community {
	private Integer communityId;
	private String communityName;

	public Integer getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	@Override
	public String toString() {
		return "Community [communityId=" + communityId + ", communityName=" + communityName + "]";
	}

}
