package web.dao.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import web.dao.IOrderdetailsDao;
import web.dao.util.SqlHelper;
import web.entity.Orderdetails;

/**
 * 	订单详情	数据层
 */
public class OrderdetailsDaoImpl implements IOrderdetailsDao {
	private static final String TABLENAME = "T_Orderdetails";

	/**
	 * 插入订单详情
	 */
	@Override
	public int insertOrderdetails(Orderdetails orderdetails) {
		return SqlHelper.executeInsert(TABLENAME, orderdetails);
	}

	/**
	 * 通过主键删除订单详情
	 */
	@Override
	public int deleteOrderdetails(Integer detailsId) {
		return SqlHelper.executeNoQuery("delete from " + TABLENAME + " where detailsId=" + detailsId);
	}

	/**
	 * 执行更新订单详情
	 */
	@Override
	public int updateOrderdetails(Orderdetails orderdetails) {
		return SqlHelper.executeUpdate(TABLENAME, orderdetails, "where detailsId=" + orderdetails.getDetailsId());
	}

	/**
	 * 查询所有订单详情
	 */
	@Override
	public List<Orderdetails> selectOrderdetails() {
		return SqlHelper.executeQuery(Orderdetails.class, "select * from " + TABLENAME);
	}

	/**
	 * 通过主键查询单个订单详情
	 */
	@Override
	public Orderdetails selectOrderdetails(Integer detailsId) {
		return SqlHelper.executeQueryOne(Orderdetails.class,//三表联查
				"select od.*,o.*,p.* from T_Orderdetails od,T_Order o,T_Product p where o.orderId=od.orderId and p.productId=od.productId and od.detailsId=" + detailsId);
	}
	
	/**
	 * 通过用户id和订单状态查询单个订单详情
	 */
	@Override
	public List<Orderdetails> selectOrderdetailsByVipIdAndOrderState(Integer vipId,String orderState) {
		return SqlHelper.executeQuery(Orderdetails.class,//三表联查
				"select od.*,o.*,p.* from T_Orderdetails od,T_Order o,T_Product p where o.orderId=od.orderId and p.productId=od.productId and o.vipId=" + vipId+(orderState==null?"":(orderState.contains("%")?" and o.orderstate like '"+orderState+"'":" and o.orderstate='"+orderState+"'")));
	}
	
	/**
	 * 通过orderId查询单个订单详情
	 */
	@Override
	public Orderdetails selectOrderdetailsByOrderId(Integer orderId) {
		return SqlHelper.executeQueryOne(Orderdetails.class,//三表联查
				"select od.*,o.*,p.* from T_Orderdetails od,T_Order o,T_Product p where o.orderId=od.orderId and p.productId=od.productId and od.orderId=" + orderId);
	}
	
	/**
	 * 获取商品月销量
	 */
	@Override
	public Integer selectMonthSellCountByProductId(Integer productId) {
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		ResultSet rs=SqlHelper.executeQuery("select count(*) from " + TABLENAME + " where productId="+productId+" and CONVERT(varchar(100), ordertime, 112)>'"+sdf.format(calendar.getTime())+"'");
		Integer count=0;
		try {
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {}
		return count;
	}
	
	/**
	 * 获取商品总销量
	 */
	@Override
	public Integer selectAllSellCountByProductId(Integer productId) {
		ResultSet rs=SqlHelper.executeQuery("select count(*) from " + TABLENAME + " where productId="+productId);
		Integer count=0;
		try {
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {}
		return count;
	}
	/**
	 * 根据orderId查询productId
	 */
	@Override
	public List<Orderdetails> selectOrderdetailsByorderId(Integer orderId) {
		return SqlHelper.executeQuery(Orderdetails.class, "select * from " + TABLENAME +" where orderId="+orderId);
	}

}
