package web.servlet.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.ICategoryDao;
import web.dao.IProductDao;
import web.dao.impl.CategoryDaoImpl;
import web.dao.impl.ProductDaoImpl;
import web.entity.Category;
import web.entity.Product;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/updateproduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private IProductDao productDao=new ProductDaoImpl();
	private ICategoryDao categoryDao=new CategoryDaoImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session=request.getSession();
		
		String productId=request.getParameter("productId");
		
		List<Category> listCategory = categoryDao.selectCategory();
		session.setAttribute("listCategory", listCategory);
		session.setAttribute("productId", productId);
		
		Product selectProduct = productDao.selectProduct(Integer.parseInt(productId));
		
		
		session.setAttribute("selectProduct", selectProduct);
		
		request.getRequestDispatcher("/admin/updateproduct1.jsp").forward(request, response);
		
		
	}
}
