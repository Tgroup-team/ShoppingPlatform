package web.entity;

public class Community {
	private int communityId;
	private String communityName;

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
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
