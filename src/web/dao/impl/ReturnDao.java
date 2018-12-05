package web.dao.impl;

import java.util.List;

import web.dao.util.SqlHelper;
import web.entity.Return;

/**
 * 	退货	数据层
 */
public class ReturnDao {
	private static final String TABLENAME = "T_Return";

	/**
	 * 插入退货
	 */
	public int insertReturn(Return Return) {
		return SqlHelper.executeInsert(TABLENAME, Return);
	}

	/**
	 * 通过主键删除退货
	 */
	public int deleteReturn(Integer returnId) {
		return SqlHelper.executeNoQuery("delete from " + TABLENAME + " where returnId=" + returnId);
	}

	/**
	 * 执行更新退货
	 */
	public int updateReturn(Return Return) {
		return SqlHelper.executeUpdate(TABLENAME, Return, "where returnId=" + Return.getReturnId());
	}

	/**
	 * 查询所有退货
	 */
	public List<Return> selectReturn() {
		return SqlHelper.executeQuery(Return.class, "select * from " + TABLENAME);
	}

	/**
	 * 通过主键查询单个退货
	 */
	public Return selectReturn(Integer returnId) {
		return SqlHelper.executeQueryOne(Return.class,
				"select * from " + TABLENAME + " where returnId=" + returnId);
	}

}
