package web.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.ICategoryDao;
import web.dao.impl.CategoryDaoImpl;
import web.entity.Category;

/**
 * 产品类别管理
 */
@WebServlet("/categoryservlet")
public class ScanCategoryServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ICategoryDao categoryDao=new CategoryDaoImpl();
  
    /*
     * 查看
     */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listCategory = categoryDao.selectCategory();
		request.setAttribute("listCategory", listCategory);
		request.getRequestDispatcher("/admin/catagory1.jsp").forward(request, response);
	}


}
