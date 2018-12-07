package web.dao.impl;

import java.util.List;

import web.dao.IApplyDao;
import web.dao.util.SqlHelper;
import web.entity.Apply;
import web.entity.Order;

public class ApplyDaoImpl implements IApplyDao{
	
	/*
	 * 审核功能添加
	 */
	@Override
	public int insertApply(Apply apply) {
		return SqlHelper.executeInsert("T_Apply", apply);
	}
	
	/*
	 * 通过applyId删除审核记录
	 */
	@Override
	public int deleteByApplyId(Integer applyId) {
		return SqlHelper.executeNoQuery("delete from T_Apply where applyId="+applyId);
	}
	
	/*
	 * 通过applyId修改审核记录
	 */
	@Override
	public int updateByApplyId(Apply apply) {
		return SqlHelper.executeUpdate("T_Apply", apply, "where applyId="+apply.getApplyId());
	}
	
	/*
	 * 列表查询审核记录情况
	 */
	@Override
    public List<Apply> selectApply(){
    	List<Apply> list=SqlHelper.executeQuery(Apply.class, "select applyId,communityName,vipName,rappl,deal,dealtime from T_Apply,T_Community,T_User where T_Apply.communityId=T_Community.communityId and T_Apply.vipId=T_User.vipId");
    	return list;
    }
    
    /*
	 * 通过applyId查询
	 */
	@Override
	public Order selectByApplyId(Integer applyId) {
		return SqlHelper.executeQueryOne(Apply.class,"select applyId,communityId,vipId,rappl,deal,dealtime from T_Apply where applyId="+applyId);
	}


}
