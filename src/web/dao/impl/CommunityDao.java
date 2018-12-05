package web.dao.impl;

import java.util.List;

import web.dao.util.SqlHelper;
import web.entity.Community;

public class CommunityDao {
	
	/*
	 * 增加小区
	 */
	public int insertCommunity(Community community) {
		return SqlHelper.executeInsert("T_Community", community);
	}
	
	/*
	 * 通过communityId删除小区
	 */
	public int deleteByCommunityId(Integer communityId) {
		return SqlHelper.executeNoQuery("delete from T_Community where communityId="+communityId);
	}
	
	/*
	 * 通过communityId修改小区
	 */
	public int updateByCommunityId(Community community) {
		return SqlHelper.executeUpdate("T_Community", community, "where communityId="+community.getCommunityId());
	}
	
	/*
	 * 列表查询小区
	 */
    public List<Community> selectCommunity(){
    	List<Community> list=SqlHelper.executeQuery(Community.class, "select * from T_Community");
    	return list;
    }
    
    /*
	 * 通过communityId查询
	 */
	public Community selectByCommunityId(Integer communityId) {
		return SqlHelper.executeQueryOne(Community.class,"select * from T_Community where communityId="+communityId);
	}
}
