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

import web.dao.IProductDao;
import web.dao.impl.ProductDaoImpl;
import web.entity.Product;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/updateproduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private IProductDao productDao=new ProductDaoImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session=request.getSession();
		
		String productId=request.getParameter("productId");
		session.setAttribute("productId", productId);
		
		Product selectProduct = productDao.selectProduct(Integer.parseInt(productId));
		
//		Product product=new Product();
//		product.setCategoryId(1);
//		product.setCategoryId(2);
//		product.setProductName("");
//		product.setProductPrice(new BigDecimal(100));
//		product.setProductImages("");
//		product.setProductDescriptionImages("");
//		product.setInventory(1);
//		product.setProductState("");
//		product.setSuppliers("");
//		
//		productDao.updateProduct(product);
		
		session.setAttribute("selectProduct", selectProduct);
		
		request.getRequestDispatcher("/admin/updateproduct1.jsp").forward(request, response);
		
		
	}
}
