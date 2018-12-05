package web.dao;

import java.util.List;

import web.entity.Order;

public interface IOrderDao {
	
	/*
	 * 增加订单
	 */
	public int insertOrder(Order order);
	
	/*
	 * 通过orderId删除订单
	 */
	public int deleteByOrderId(Integer orderId); 
	
	/*
	 * 通过orderId修改订单
	 */
	public int updateByOrderId(Order order); 
	
	/*
	 * 列表查询订单
	 */
    public List<Order> selectOrder();
    
    /*
	 * 通过orderId查询
	 */
	public Order selectByOrderId(Integer orderId);
}
