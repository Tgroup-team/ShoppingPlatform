package web.servlet.admin;

import java.io.IOException;
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
 * 跳转到修改产品页面
 */
@WebServlet("/admin/updatecategory")
public class UpdateCategoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ICategoryDao categoryDao=new CategoryDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
			
		HttpSession session=request.getSession();
		
		String categoryId=request.getParameter("categoryId");
		System.out.println(categoryId);
		Category selectByCategory= categoryDao.selectByCategoryId(Integer.parseInt(categoryId));
		session.setAttribute("selectByCategory", selectByCategory);	
		session.setAttribute("categoryId", categoryId);
		
		request.getRequestDispatcher("/admin/updatecatagory1.jsp").forward(request, response);
		
	}

}
