package web.dao;

import java.util.List;

import web.entity.Community;

public interface ICommunityDao {
	/*
	 * 增加小区
	 */
	public int insertCommunity(Community community);
	
	/*
	 * 通过communityId删除小区
	 */
	public int deleteByCommunityId(Integer communityId);
	
	/*
	 * 通过communityId修改小区
	 */
	public int updateByCommunityId(Community community);
	
	/*
	 * 列表查询小区
	 */
    public List<Community> selectCommunity();
    
    /*
	 * 通过communityId查询
	 */
	public Community selectByCommunityId(Integer communityId);
}
