package web.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.CategoryDao;
import web.entity.Category;

/**
 * 产品类别管理
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CategoryDao categoryDao=new CategoryDao();
    public CategoryServlet() {
        super();
    }

    /*
     * 查看
     */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listCategory = categoryDao.selectCategory();
		request.setAttribute("listCategory", listCategory);
	}

	/*
     * 创建
     */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("");
		category.setCdescribe("");
		int insertCategory = categoryDao.insertCategory(category);
	}

	/*
	 * 删除
	 */
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deleteByCategoryId = categoryDao.deleteByCategoryId(1);
	}
  
	/*
	 * 更新
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("");
		category.setCdescribe("");
		int updateByCategoryId = categoryDao.updateByCategoryId(category);
	}
	
	

}
