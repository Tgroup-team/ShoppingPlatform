package web.dao;

import java.util.List;

import web.dao.util.SqlHelper;
import web.entity.Category;

public class CategoryDao {
	
	//增加类别
	public int insertCategory(Category category) {
		return  SqlHelper.executeInsert("T_Category", category); 
	}
	
	//删除类别
	public int deleteByCategoryId(Integer categoryId) {
		return SqlHelper.executeNoQuery("delete from T_Category where categoryId="+categoryId);
	}
	
	//修改类别
	public int updateByCategoryId(Category category) {
		return SqlHelper.executeUpdate("T_Category", category,"where categoryId="+category.getCategoryId());
	}
	
	//列表查询
	public List<Category> seleteCategory(){
		List<Category> executeQuery = SqlHelper.executeQuery(Category.class,"select * from T_Category");
		return executeQuery;
	}
	
	public static void main(String[] args) {
		CategoryDao categoryDao=new CategoryDao();
		Category category=new Category();
		category.setCategoryId(7);
		category.setCategoryName("冷饮");
		category.setCdescribe("冰霜可口,清凉一夏");
//		List<Category> seleteCategory = categoryDao.seleteCategory();
//		System.out.println(seleteCategory);
//		int s=categoryDao.insertCategory(category);
//		System.out.println(s);
//		System.out.println(categoryDao.deleteByCategoryId(6));
		System.out.println(categoryDao.updateByCategoryId(category));
	}
}
