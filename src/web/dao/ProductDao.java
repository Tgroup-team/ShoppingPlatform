package web.dao;

import java.util.List;

import web.dao.util.SqlHelper;
import web.entity.Product;

/**
 * 	商品	数据层
 */
public class ProductDao {
	private static final String TABLENAME = "T_Product";

	/**
	 * 插入商品
	 */
	public int insertProduct(Product product) {
		return SqlHelper.executeInsert(TABLENAME, product);
	}

	/**
	 * 通过主键删除商品
	 */
	public int deleteProduct(Integer productId) {
		return SqlHelper.executeNoQuery("delete from " + TABLENAME + " where productId=" + productId);
	}

	/**
	 * 执行更新商品
	 */
	public int updateProduct(Product product) {
		return SqlHelper.executeUpdate(TABLENAME, product, "where productId=" + product.getProductId());
	}

	/**
	 * 查询所有商品
	 */
	public List<Product> selectProduct() {
		return SqlHelper.executeQuery(Product.class, "select * from " + TABLENAME);
	}

	/**
	 * 通过主键查询单个商品
	 */
	public Product selectProduct(Integer productId) {
		return SqlHelper.executeQueryOne(Product.class,
				"select * from " + TABLENAME + " where productId=" + productId);
	}

}
