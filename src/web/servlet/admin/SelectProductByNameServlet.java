package web.servlet.admin;

import java.io.IOException;
import java.security.KeyStore.PrivateKeyEntry;
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
 * 通过产品名字查找
 */
@WebServlet("/selectproductbyname")
public class SelectProductByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IProductDao productDao=new ProductDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		
		String txtPname=request.getParameter("txtPname");
		
		session.setAttribute("txtPname",txtPname);
		System.out.println(txtPname);
		
		List<Product> selectProductByName = productDao.selectProductByName(txtPname);
		session.setAttribute("pro", selectProductByName);
		
		request.getRequestDispatcher("/admin/product.jsp").forward(request, response);
		
	}

}
