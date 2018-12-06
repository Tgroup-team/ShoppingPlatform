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

/*
 * 添加产品类别
 */
@WebServlet("/addcategory")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	private ICategoryDao categoryDao=new CategoryDaoImpl();
	
    public AddCategoryServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		
		String categoryName=request.getParameter("categoryName");
		String cdescribe=request.getParameter("cdescribe");
		
		Category category=new Category();
		category.setCategoryName(categoryName);
		category.setCdescribe(cdescribe);
		
		categoryDao.insertCategory(category);
		
		List<Category> listCategory = categoryDao.selectCategory();
		session.setAttribute("listCategory",listCategory);
		
		request.getRequestDispatcher("/admin/catagory1.jsp").forward(request, response);
	}

}
