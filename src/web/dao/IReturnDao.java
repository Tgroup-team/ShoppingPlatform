package web.dao;

import java.util.List;

import web.entity.Return;

public interface IReturnDao {
	/**
	 * 插入退货
	 */
	public int insertReturn(Return Return);

	/**
	 * 通过主键删除退货
	 */
	public int deleteReturn(Integer returnId);

	/**
	 * 执行更新退货
	 */
	public int updateReturn(Return Return);

	/**
	 * 查询所有退货
	 */
	public List<Return> selectReturn();

	/**
	 * 通过主键查询单个退货
	 */
	public Return selectReturn(Integer returnId);
	
	/**
	 * 通过vipId查询单个退货
	 */
	public List<Return> selectReturnByVipId(Integer vipId);

}
