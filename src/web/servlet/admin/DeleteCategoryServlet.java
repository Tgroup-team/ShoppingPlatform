package web.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.ICategoryDao;
import web.dao.impl.CategoryDaoImpl;
import web.entity.Category;

/**
 * 通过id删除产品类别
 */
@WebServlet("/admin/deletecategory")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ICategoryDao categoryDao=new CategoryDaoImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoryId=request.getParameter("categoryId");
		
		categoryDao.deleteByCategoryId(Integer.parseInt(categoryId));
		
		HttpSession session=request.getSession();
		List<Category> listCategory = categoryDao.selectCategory();
		session.setAttribute("listCategory",listCategory);
		
		request.getRequestDispatcher("/admin/catagory1.jsp").forward(request, response);
		
	}

}
