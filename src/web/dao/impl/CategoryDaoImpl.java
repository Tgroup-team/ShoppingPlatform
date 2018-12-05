package web.dao.impl;

import java.util.List;

import web.dao.ICategoryDao;
import web.dao.util.SqlHelper;
import web.entity.Category;

public class CategoryDaoImpl implements ICategoryDao{
	
	/**
	 * 增加类别
	 */
	@Override
	public int insertCategory(Category category) {
		return  SqlHelper.executeInsert("T_Category", category); 
	}
	/*
	 * 删除类别
	 */
	@Override
	public int deleteByCategoryId(Integer categoryId) {
		return SqlHelper.executeNoQuery("delete from T_Category where categoryId="+categoryId);
	}
	/*
	 * 修改类别
	 */
	@Override
	public int updateByCategoryId(Category category) {
		return SqlHelper.executeUpdate("T_Category", category,"where categoryId="+category.getCategoryId());
	}
	/*
	 * 列表查询
	 */
	@Override
	public List<Category> selectCategory(){
		List<Category> executeQuery = SqlHelper.executeQuery(Category.class,"select * from T_Category");
		return executeQuery;
	}
	/*
	 * 通过categoryId查询
	 */
	@Override
	public Category selectByCategoryId(Integer categoryId) {
		return SqlHelper.executeQueryOne(Category.class,"select * from T_Category where categoryId="+categoryId);
	}
	
}
