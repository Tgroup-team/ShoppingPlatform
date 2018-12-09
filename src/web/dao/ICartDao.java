package web.dao;

import java.util.List;

import web.entity.Cart;

/**
 * 购物车
 */
public interface ICartDao {
	public int insertCart(Cart cart);
	
	 /*
	 * 删除购物车
	 */
	public int deleteByCartId(Integer carId);
	
	/*
	 * 更新购物车
	 */
	public int updateByCartId(Cart cart);
	
	/*
	 * 遍历所有购物车
	 */
	public List<Cart> selectCart();
	/*
	 * 根据id查找购物车
	 */
	public Cart selectCartById(Integer carId);
	/*
	 * 根据vipId查找购物车
	 */
	public List<Cart> selectCartByVipId(Integer vipId);
}
