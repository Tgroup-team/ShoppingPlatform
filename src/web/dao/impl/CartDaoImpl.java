package web.dao.impl;

import java.util.List;

import web.dao.ICartDao;
import web.dao.util.SqlHelper;
import web.entity.Cart;

public class CartDaoImpl implements ICartDao {
	private static final String TABLENAME = "T_Cart";
	
	/**
	 * 插入购物车
	 */
	@Override
	public int insertCart(Cart Cart) {
		return SqlHelper.executeInsert(TABLENAME, Cart);
	}

	/**
	 * 通过主键删除购物车
	 */
	@Override
	public int deleteByCartId(Integer carId) {
		//System.out.println("delete from " + TABLENAME + " where carId=" + carId);
		return SqlHelper.executeNoQuery("delete from " + TABLENAME + " where carId=" + carId);
	}

	/**
	 * 执行更新购物车
	 */
	@Override
	public int updateByCartId(Cart cart) {
		return SqlHelper.executeUpdate(TABLENAME, cart, "where cartId=" + cart.getCarId());
	}

	/**
	 * 查询所有购物车
	 */
	@Override
	public List<Cart> selectCart() {
		return SqlHelper.executeQuery(Cart.class, "select c.*,p.*,u.* from " + TABLENAME+" c,T_User u,T_Product p where p.productId=c.productId and u.vipId=c.vipId");
	}

	/**
	 * 通过主键查询单个购物车
	 */
	@Override
	public Cart selectCartById(Integer cartId) {
		return SqlHelper.executeQueryOne(Cart.class,
				"select c.*,p.*,u.* from " + TABLENAME+" c,T_User u,T_Product p where p.productId=c.productId and u.vipId=c.vipId and c.carId=" + cartId);
	}

	@Override
	public List<Cart> selectCartByVipId(Integer vipId) {
		return SqlHelper.executeQuery(Cart.class,
				"select c.*,p.*,u.* from " + TABLENAME+" c,T_User u,T_Product p where p.productId=c.productId and u.vipId=c.vipId and c.vipId=" + vipId);
	}

}
