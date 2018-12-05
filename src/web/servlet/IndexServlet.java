package web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.CategoryDao;
import web.dao.ProductDao;
import web.entity.Category;
import web.entity.Product;

@WebServlet("")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductDao productDao=new ProductDao();
	private static CategoryDao categoryDao=new CategoryDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//商品类别->该类商品列表
		List<List<Product>> productMap=new ArrayList<List<Product>>();
		//查询类别
		List<Category> categories=categoryDao.seleteCategory();
		//分页查询：当前页开始值，页内商品数量
		int lineStartIndex=0,lineSize=11;
		Category category=null;
		for(int i=0;i<categories.size();i++) {
			category=categories.get(i);
			//查询所有的商品
			List<Product> products=productDao.selectOnlineProductsByCategoryId(category.getCategoryId(),null , null);
			if(products!=null&&!products.isEmpty()) {
				int endindex=lineStartIndex+lineSize;
				productMap.add(products.subList(lineStartIndex, products.size()<endindex?products.size():endindex));
			}
		}
		request.setAttribute("productMap", productMap);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
