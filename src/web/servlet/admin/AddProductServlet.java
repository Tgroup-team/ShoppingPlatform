package web.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 增加商品
 */
@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
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
		
		System.out.println(productState);
		System.out.println(categoryId);
		System.out.println(productName);
		
		request.getRequestDispatcher("/admin/product1.jsp").forward(request, response);
		
	}

}
