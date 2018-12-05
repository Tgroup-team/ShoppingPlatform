package web.dao;

import java.util.List;

import web.dao.util.SqlHelper;
import web.entity.Category;

public class CategoryDao {
	
	/**
	 * 增加类别
	 */
	public int insertCategory(Category category) {
		return  SqlHelper.executeInsert("T_Category", category); 
	}
	/*
	 * 删除类别
	 */
	public int deleteByCategoryId(Integer categoryId) {
		return SqlHelper.executeNoQuery("delete from T_Category where categoryId="+categoryId);
	}
	/*
	 * 修改类别
	 */
	public int updateByCategoryId(Category category) {
		return SqlHelper.executeUpdate("T_Category", category,"where categoryId="+category.getCategoryId());
	}
	/*
	 * 列表查询
	 */
	public List<Category> selectCategory(){
		List<Category> executeQuery = SqlHelper.executeQuery(Category.class,"select * from T_Category");
		return executeQuery;
	}
	/*
	 * 通过categoryId查询
	 */
	public Category selectByCategoryId(Integer categoryId) {
		return SqlHelper.executeQueryOne(Category.class,"select * from T_Category where categoryId="+categoryId);
	}
	
}
