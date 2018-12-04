package web.dao;

import java.util.List;

import web.dao.util.SqlHelper;
import web.entity.Orderdetails;

/**
 * 	订单详情	数据层
 */
public class OrderdetailsDao {
	private static final String TABLENAME = "T_Orderdetails";

	/**
	 * 插入订单详情
	 */
	public int insertOrderdetails(Orderdetails orderdetails) {
		return SqlHelper.executeInsert(TABLENAME, orderdetails);
	}

	/**
	 * 通过主键删除订单详情
	 */
	public int deleteOrderdetails(Integer detailsId) {
		return SqlHelper.executeNoQuery("delete from " + TABLENAME + " where detailsId=" + detailsId);
	}

	/**
	 * 执行更新订单详情
	 */
	public int updateOrderdetails(Orderdetails orderdetails) {
		return SqlHelper.executeUpdate(TABLENAME, orderdetails, "where detailsId=" + orderdetails.getDetailsId());
	}

	/**
	 * 查询所有订单详情
	 */
	public List<Orderdetails> selectOrderdetails() {
		return SqlHelper.executeQuery(Orderdetails.class, "select * from " + TABLENAME);
	}

	/**
	 * 通过主键查询单个订单详情
	 */
	public Orderdetails selectOrderdetails(Integer detailsId) {
		return SqlHelper.executeQueryOne(Orderdetails.class,
				"select * from " + TABLENAME + " where detailsId=" + detailsId);
	}

}
