package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.ICategoryDao;
import web.dao.IProductDao;
import web.dao.impl.CategoryDaoImpl;
import web.dao.impl.ProductDaoImpl;
import web.entity.Category;
import web.entity.Product;

/**
 * Servlet implementation class IntroductionServletList
 */
@WebServlet("/IntroductionServletList")
public class IntroductionServletList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICategoryDao categoryDao = new CategoryDaoImpl();
	private IProductDao productDao = new ProductDaoImpl();
	private static final Integer pageItemSize = 12;// 一页几个数据

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> list = null;
		Integer categoryId = null;
		String keywords = request.getParameter("keywords");// 关键词或分类名
		try {
			categoryId = Integer.parseInt(request.getParameter("categoryId"));
		} catch (Exception e) {
		}
		if (categoryId != null) {// 获取该分类
			Category category = categoryDao.selectByCategoryId(categoryId);
			if (category != null) {
				keywords = category.getCategoryName();
				// 获取该分类下的商品
				Integer productsCount = productDao.selectOnlineProductsCountByCategoryId(categoryId);
				Integer pageIndex = 1;
				try {
					pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
				} catch (Exception e) {
				}
				list = productDao.selectOnlineProductsByCategoryId(categoryId, (pageIndex - 1) * pageItemSize,
						pageItemSize);
				request.setAttribute("keywords", keywords);
				request.setAttribute("categoryId", categoryId);
				// 传到前台结果列表
				request.setAttribute("list", list);
				// 当前页
				request.setAttribute("pagesIndex", pageIndex);
				// 获取页数量
				request.setAttribute("pagesCount", (productsCount % pageItemSize == 0 ? (productsCount / pageItemSize)
						: ((productsCount / pageItemSize) + 1)));
			}
		} else {// 按关键字查询
			if (keywords != null) {
				// 获取相关的商品
				Integer productsCount = productDao.selectOnlineProductsCountByProductName(keywords);
				Integer pageIndex = 1;
				try {
					pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
				} catch (Exception e) {
				}
				list = productDao.selectOnlineProductsByProductName(keywords, (pageIndex - 1) * pageItemSize,
						pageItemSize);
				if (list != null && list.isEmpty()) {
					list = null;
				} else {
					request.setAttribute("keywords", keywords);
					// 传到前台结果列表
					request.setAttribute("list", list);
					// 当前页
					request.setAttribute("pagesIndex", pageIndex);
					// 获取页数量
					request.setAttribute("pagesCount",
							(productsCount % pageItemSize == 0 ? (productsCount / pageItemSize)
									: ((productsCount / pageItemSize) + 1)));
				}
			}
		}

		if (list == null) {// 说明没有相关商品
			request.setAttribute("keywords", keywords);
			request.setAttribute("msg", "未找到相关商品");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/WEB-INF/introductionList.jsp").forward(request, response);
	}

}
