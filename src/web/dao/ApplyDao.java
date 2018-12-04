package web.dao;

import java.util.List;

import web.dao.util.SqlHelper;
import web.entity.Apply;
import web.entity.Order;

public class ApplyDao {
	
	/*
	 * 审核功能添加
	 */
	public int insertApply(Apply apply) {
		return SqlHelper.executeInsert("T_Apply", apply);
	}
	
	/*
	 * 通过applyId删除审核记录
	 */
	public int deleteByApplyId(Integer applyId) {
		return SqlHelper.executeNoQuery("delete from T_Apply where applyId="+applyId);
	}
	
	/*
	 * 通过applyId修改审核记录
	 */
	public int updateByApplyId(Apply apply) {
		return SqlHelper.executeUpdate("T_Apply", apply, "where applyId="+apply.getApplyId());
	}
	
	/*
	 * 列表查询审核记录情况
	 */
    public List<Apply> selectApply(){
    	List<Apply> list=SqlHelper.executeQuery(Apply.class, "select applyId,communityId,vipId,rappl,deal,dealtime from T_Apply");
    	return list;
    }
    
    /*
	 * 通过applyId查询
	 */
	public Order selectByApplyId(Integer applyId) {
		return SqlHelper.executeQueryOne(Apply.class,"select applyId,communityId,vipId,rappl,deal,dealtime from T_Apply where applyId="+applyId);
	}


}
