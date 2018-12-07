package web.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.IProductDao;
import web.dao.impl.ProductDaoImpl;
import web.entity.Product;

/**
 * 删除产品
 */
@WebServlet("/deleteproduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private IProductDao productDao=new ProductDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		
		String productId=request.getParameter("productId");
		
		productDao.deleteProduct(Integer.parseInt(productId));
		 
		
		request.getRequestDispatcher("/productservlet").forward(request, response);
		
	}

	

}
