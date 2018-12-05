package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.impl.CategoryDaoImpl;
import web.dao.impl.OrderdetailsDao;
import web.dao.impl.ProductDao;
import web.entity.Category;
import web.entity.Product;

/**
 * Servlet implementation class IntroductionServlet
 */
@WebServlet("/IntroductionServlet")
public class IntroductionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao=new ProductDao();
	private OrderdetailsDao orderdetailsDao=new OrderdetailsDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer productId=null;
		try {
			productId=Integer.parseInt(request.getParameter("productId"));
		} catch (Exception e) {}
		if(productId==null||productId<1) {
			request.setAttribute("msg", "商品不存在");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		Product product=productDao.selectProduct(productId);
		if(product==null) {
			request.setAttribute("msg", "商品不存在");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		request.setAttribute("product", product);
		request.setAttribute("productMonthSellCount", orderdetailsDao.selectMonthSellCountByProductId(productId));
		request.setAttribute("productAllSellCount", orderdetailsDao.selectAllSellCountByProductId(productId));
		request.getRequestDispatcher("/WEB-INF/introduction.jsp").forward(request, response);
	}

}
