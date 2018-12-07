package web.dao;

import java.util.List;

import web.entity.Product;

public interface IProductDao {
	
	/**
	 * 插入商品
	 */
	public int insertProduct(Product product);

	/**
	 * 通过主键删除商品
	 */
	public int deleteProduct(Integer productId);
	/**
	 * 执行更新商品
	 */
	public int updateProduct(Product product);

	/**
	 * 查询所有商品
	 */
	public List<Product> selectProduct();

	/**
	 * 通过主键查询单个商品
	 */
	public Product selectProduct(Integer productId);

	/**
	 * 通过商品类别id查询已上架的商品
	 * @param lineStartIndex 分页的开始索引值 
	 * @param size 单页内商品的数量
	 * @return
	 */
	public List<Product> selectOnlineProductsByCategoryId(Integer categoryId,Integer lineStartIndex,Integer lineSize);

	/**
	 * 获取该类商品已上架数量
	 */
	public Integer selectOnlineProductsCountByCategoryId(Integer categoryId);
	
	/**
	 * 通过关键字查询某商品
	 */
	public List<Product> selectOnlineProductsByProductName(String productName,Integer lineStartIndex,Integer lineSize);
	
	/**
	 * 通过关键字查询某商品已上架数量
	 */
	public Integer selectOnlineProductsCountByProductName(String productName);

	public List<Product> selectProductByPage(int pageSize, int pageNow);
}
