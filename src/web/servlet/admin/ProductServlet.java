package web.servlet.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.IProductDao;
import web.dao.impl.ProductDaoImpl;
import web.entity.Address;
import web.entity.Community;
import web.entity.Page;
import web.entity.Product;

/**
 * 产品管理
 */
@WebServlet("/productservlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IProductDao productDao=new ProductDaoImpl();
       

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		List<Product> pro = new ArrayList<Product>();
		
		String pageNow = request.getParameter("pageNow"); 
		System.out.println("pageNow:"+pageNow);
		
        Page page = null; 
		
		
		List<Product> listProduct = productDao.selectProduct();
		
		 int totalCount=listProduct.size();
		
		 if (pageNow != null) { 
	            page = new Page(totalCount, Integer.parseInt(pageNow),10);  
	            pro=productDao.selectProductByPage(page.getPageSize(), page.getStartPos());
	        } else { 
	            page = new Page(totalCount, 1,10); 
	            pro=productDao.selectProductByPage(page.getPageSize(), page.getStartPos());
	        } 
		 
		session.setAttribute("page", page);
		session.setAttribute("pro", pro);
		request.getRequestDispatcher("/admin/product1.jsp").forward(request, response);
	}

}
