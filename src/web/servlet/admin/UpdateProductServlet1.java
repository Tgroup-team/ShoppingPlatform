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
@WebServlet("/updateproduct1")
public class UpdateProductServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private IProductDao productDao=new ProductDaoImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
        HttpSession session=request.getSession();
       String productId=(String) session.getAttribute("productId");
		
        String categoryId=request.getParameter("categoryId");
		String productName=request.getParameter("productName");
		String productPrice=request.getParameter("productPrice");
		String inventory=request.getParameter("inventory");
		String suppliers=request.getParameter("suppliers");
		String[] productImges=request.getParameterValues("productImages");
		String[] productDescriptionImagess=request.getParameterValues("productDescriptionImages");
		String productImge="";
		for (String string : productImges) {
			if(string==null||"".equals(string)) {
				continue;
			}
			productImge=productImge+";"+string;
		}
		productImge=productImge.length()>0?productImge.substring(1):"";
		
		String productDescriptionImages="";
		for (String string : productDescriptionImagess) {
			if(string==null||"".equals(string)) {
				continue;
			}
			productDescriptionImages=productDescriptionImages+";"+string;
		}
		productDescriptionImages=productDescriptionImages.length()>0?productDescriptionImages.substring(1):"";
		
		System.out.println(productId);
		Product product=new Product();
		product.setCategoryId(Integer.parseInt(categoryId));
		product.setProductId(Integer.parseInt(productId));
		product.setProductName(productName);
		product.setProductPrice(new BigDecimal(Float.parseFloat(productPrice)));
		product.setInventory(Integer.parseInt(inventory));
		product.setSuppliers(suppliers);
		product.setProductImages(productImge);
		product.setProductDescriptionImages(productDescriptionImages);
		
		productDao.updateProduct(product);
	
		request.getRequestDispatcher("/productservlet").forward(request, response);	
	}
}
