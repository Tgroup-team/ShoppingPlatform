package web.dao;

import java.util.List;

import web.entity.Orderdetails;

public interface IOrderdetailsDao {
	

	/**
	 * 插入订单详情
	 */
	public int insertOrderdetails(Orderdetails orderdetails); 

	/**
	 * 通过主键删除订单详情
	 */
	public int deleteOrderdetails(Integer detailsId);

	/**
	 * 执行更新订单详情
	 */
	public int updateOrderdetails(Orderdetails orderdetails); 

	/**
	 * 查询所有订单详情
	 */
	public List<Orderdetails> selectOrderdetails();

	/**
	 * 通过主键查询单个订单详情
	 */
	public Orderdetails selectOrderdetails(Integer detailsId);
	
	/**
	 * 获取商品月销量
	 */
	public Integer selectMonthSellCountByProductId(Integer productId);
	
	/**
	 * 获取商品总销量
	 */
	public Integer selectAllSellCountByProductId(Integer productId);

	public List<Orderdetails> selectOrderdetailsByorderId(Integer orderId);
}
