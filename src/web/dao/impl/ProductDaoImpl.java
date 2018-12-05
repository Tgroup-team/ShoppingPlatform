package web.dao.impl;

import java.util.List;

import web.dao.IProductDao;
import web.dao.util.SqlHelper;
import web.entity.Product;

/**
 * 	商品	数据层
 */
public class ProductDaoImpl implements IProductDao {
	private static final String TABLENAME = "T_Product";

	/**
	 * 插入商品
	 */
	@Override
	public int insertProduct(Product product) {
		return SqlHelper.executeInsert(TABLENAME, product);
	}

	/**
	 * 通过主键删除商品
	 */
	@Override
	public int deleteProduct(Integer productId) {
		return SqlHelper.executeNoQuery("delete from " + TABLENAME + " where productId=" + productId);
	}

	/**
	 * 执行更新商品
	 */
	@Override
	public int updateProduct(Product product) {
		return SqlHelper.executeUpdate(TABLENAME, product, "where productId=" + product.getProductId());
	}

	/**
	 * 查询所有商品
	 */
	@Override
	public List<Product> selectProduct() {
		return SqlHelper.executeQuery(Product.class, "select p.*,c.* from " + TABLENAME + " p,T_Category c where p.categoryId=c.categoryId");
	}

	/**
	 * 通过主键查询单个商品
	 */
	@Override
	public Product selectProduct(Integer productId) {
		return SqlHelper.executeQueryOne(Product.class,
				"select p.*,c.* from " + TABLENAME + " p,T_Category c where p.categoryId=c.categoryId and p.productId=" + productId);
	}

	/**
	 * 通过商品类别id查询已上架的商品
	 * @param lineStartIndex 分页的开始索引值 
	 * @param size 单页内商品的数量
	 * @return
	 */
	@Override
	public List<Product> selectOnlineProductsByCategoryId(Integer categoryId,Integer lineStartIndex,Integer lineSize) {
		String limitString="";
		if(lineStartIndex!=null&&lineStartIndex>-1&&lineSize!=null&&lineSize>0) {
			limitString="and productId BETWEEN  "+lineStartIndex+" and "+lineSize;
		}
		return SqlHelper.executeQuery(Product.class, "select p.*,c.* from " + TABLENAME + " p,T_Category c where c.categoryId=p.categoryId and p.categoryId="+categoryId +" and p.productState='上架' "+limitString);
	}
}