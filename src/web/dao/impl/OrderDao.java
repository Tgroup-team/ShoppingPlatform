package web.dao.impl;

import java.util.List;

import web.dao.util.SqlHelper;
import web.entity.Order;

public class OrderDao {
	
	/*
	 * 增加订单
	 */
	public int insertOrder(Order order) {
		return SqlHelper.executeInsert("T_Order", order);
	}
	
	/*
	 * 通过orderId删除订单
	 */
	public int deleteByOrderId(Integer orderId) {
		return SqlHelper.executeNoQuery("delete from T_Order where orderId="+orderId);
	}
	
	/*
	 * 通过orderId修改订单
	 */
	public int updateByOrderId(Order order) {
		return SqlHelper.executeUpdate("T_Order", order, "where orderId="+order.getOrderId());
	}
	
	/*
	 * 列表查询订单
	 */
    public List<Order> selectOrder(){
    	List<Order> list=SqlHelper.executeQuery(Order.class, "select orderId,vipName,orderstate,delivery,acceptance from T_Order,T_User where orderId=T_User.vipId");
    	return list;
    }
    
    /*
	 * 通过orderId查询
	 */
	public Order selectByOrderId(Integer orderId) {
		return SqlHelper.executeQueryOne(Order.class,"select T_Order.*,T_User.* from T_Order,T_User where T_Order.orderId=T_User.vipId and orderId="+orderId);
	}

}
