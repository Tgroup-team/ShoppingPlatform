package web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.IOrderdetailsDao;
import web.dao.IProductDao;
import web.dao.impl.OrderdetailsDaoImpl;
import web.dao.impl.ProductDaoImpl;
import web.entity.Product;

/**
 * Servlet implementation class IntroductionServlet
 */
@WebServlet("/IntroductionServlet")
public class IntroductionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductDao productDao=new ProductDaoImpl();
	private IOrderdetailsDao orderdetailsDao=new OrderdetailsDaoImpl();
	
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
		Integer productsCount=productDao.selectOnlineProductsCountByCategoryId(product.getCategoryId());
		Integer pageIndex=1;
		try {
			pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
		} catch (Exception e) {}
		Integer pageItemSize=8;
		List<Product> likeProducts=productDao.selectOnlineProductsByCategoryId(product.getCategoryId(), (pageIndex-1)*pageItemSize,pageItemSize);
		//跳转到猜你喜欢页
		String showlike=request.getParameter("showlike");
		if(showlike==null) {
			showlike="false";
		}
		request.setAttribute("showlike", showlike);
		request.setAttribute("likeProducts", likeProducts);
		//当前页
		request.setAttribute("pagesIndex",pageIndex);
		//获取页数量
		request.setAttribute("pagesCount",(productsCount%pageItemSize==0?(productsCount/pageItemSize):((productsCount/pageItemSize)+1)));
		request.setAttribute("product", product);
		request.setAttribute("productMonthSellCount", orderdetailsDao.selectMonthSellCountByProductId(productId));
		request.setAttribute("productAllSellCount", orderdetailsDao.selectAllSellCountByProductId(productId));
		request.getRequestDispatcher("/WEB-INF/introduction.jsp").forward(request, response);
	}

}
