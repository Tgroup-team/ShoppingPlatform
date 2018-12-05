package web.dao;

import java.util.List;

import web.entity.Category;

public interface ICategoryDao {

	/**
	 * 增加类别
	 */
	public int insertCategory(Category category);
	/*
	 * 删除类别
	 */
	public int deleteByCategoryId(Integer categoryId);
	/*
	 * 修改类别
	 */
	public int updateByCategoryId(Category category);
	/*
	 * 列表查询
	 */
	public List<Category> selectCategory();
	/*
	 * 通过categoryId查询
	 */
	public Category selectByCategoryId(Integer categoryId);
}
