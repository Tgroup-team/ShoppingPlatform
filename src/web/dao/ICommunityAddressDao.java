package web.dao;

import java.util.List;

import web.entity.CommunityAddress;

public interface ICommunityAddressDao {

	/*
	 * 查询社团成员地址信息
	 */
	public List<CommunityAddress> selectCommunityAddressByCommunityId(Integer communityId);

	/*
	 * 分页查询社团成员地址信息
	 */
	public List<CommunityAddress> selectCommunityAddressPage(int pageSize, int pageNow, Integer communityId);
	
	

}
