package web.dao;

import java.util.List;

import web.entity.Apply;
import web.entity.Order;

public interface IApplyDao{
	/*
	 * 审核功能添加
	 */
	public int insertApply(Apply apply);
	
	/*
	 * 通过applyId删除审核记录
	 */
	public int deleteByApplyId(Integer applyId);
	
	/*
	 * 通过applyId修改审核记录
	 */
	public int updateByApplyId(Apply apply) ;
	
	/*
	 * 列表查询审核记录情况
	 */
    public List<Apply> selectApply();
    
    /*
	 * 通过applyId查询
	 */
	public Order selectByApplyId(Integer applyId);

}
