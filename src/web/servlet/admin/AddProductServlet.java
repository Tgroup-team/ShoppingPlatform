package web.servlet.admin;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.IProductDao;
import web.dao.impl.ProductDaoImpl;
import web.entity.Product;

/**
 * 增加商品
 */
@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IProductDao productDao=new ProductDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		
		
		String categoryId=request.getParameter("categoryId");
		String productName=request.getParameter("productName");
		String productPrice=request.getParameter("productPrice");
		String productImge=request.getParameter("productImge");
		String productDescriptionImages=request.getParameter("productDescriptionImages");
		String inventory=request.getParameter("inventory");
		String productState=request.getParameter("productState");
		String suppliers=request.getParameter("suppliers");
		System.out.println(categoryId);
		
		Product product=new Product();
		product.setCategoryId(Integer.parseInt(categoryId));
		product.setProductName(productName);
		product.setProductImages(productImge);
		product.setProductDescriptionImages(productDescriptionImages);
		product.setProductPrice(new BigDecimal(productPrice));
		product.setProductState(productState);
		product.setInventory(Integer.parseInt(inventory));
		product.setSuppliers(suppliers);

		
		productDao.insertProduct(product);
		
		request.getRequestDispatcher("/productservlet").forward(request, response);
		
	}

}
