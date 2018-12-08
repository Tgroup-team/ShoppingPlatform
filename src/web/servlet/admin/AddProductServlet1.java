package web.servlet.admin;

import java.io.IOException;
import java.security.KeyStore.PrivateKeyEntry;
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
 * Servlet implementation class AddProductServlet1
 */
@WebServlet("/addproduct1")
public class AddProductServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ICategoryDao categoryDao=new CategoryDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		List<Category> listCategory = categoryDao.selectCategory();
		session.setAttribute("listCategory", listCategory);
		
		request.getRequestDispatcher("/admin/addproduct1.jsp").forward(request, response);
		
	}


}
