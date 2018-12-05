package web.dao.impl;

import java.util.List;

import web.dao.IReturnDao;
import web.dao.util.SqlHelper;
import web.entity.Return;

/**
 * 	退货	数据层
 */
public class ReturnDaoImpl implements IReturnDao{
	private static final String TABLENAME = "T_Return";

	/**
	 * 插入退货
	 */
	@Override
	public int insertReturn(Return Return) {
		return SqlHelper.executeInsert(TABLENAME, Return);
	}

	/**
	 * 通过主键删除退货
	 */
	@Override
	public int deleteReturn(Integer returnId) {
		return SqlHelper.executeNoQuery("delete from " + TABLENAME + " where returnId=" + returnId);
	}

	/**
	 * 执行更新退货
	 */
	@Override
	public int updateReturn(Return Return) {
		return SqlHelper.executeUpdate(TABLENAME, Return, "where returnId=" + Return.getReturnId());
	}

	/**
	 * 查询所有退货
	 */
	@Override
	public List<Return> selectReturn() {
		return SqlHelper.executeQuery(Return.class, "select * from " + TABLENAME);
	}

	/**
	 * 通过主键查询单个退货
	 */
	@Override
	public Return selectReturn(Integer returnId) {
		return SqlHelper.executeQueryOne(Return.class,
				"select * from " + TABLENAME + " where returnId=" + returnId);
	}

}
