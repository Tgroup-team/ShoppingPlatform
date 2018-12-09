package web.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.ICartDao;
import web.dao.IProductDao;
import web.dao.impl.CartDaoImpl;
import web.dao.impl.ProductDaoImpl;
import web.entity.Cart;
import web.entity.Product;
import web.entity.User;

@WebServlet("/ShowUserCart")
public class ShowUserCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICartDao cartDao=new CartDaoImpl();
	private IProductDao productDao=new ProductDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("delete")!=null&&request.getAttribute("NoDoDelete")==null) {
			doDelete(request, response);
			return;
		}
		User user=(User) request.getSession().getAttribute("user");
		if(user==null) {
			request.setAttribute("msg", "亲爱的用户，登陆后才能才看购物车哦！<a href='userlogin.jsp'>》》点我登陆《《</a>");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		List<Cart> selectCartById = cartDao.selectCartByVipId(user.getVipId());
		request.setAttribute("selectCartById", selectCartById);
		request.getRequestDispatcher("/shopcar2.jsp").forward(request, response);
	}

	//提交商品到购物车
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer productId=null;
		try {
			productId=Integer.parseInt(request.getParameter("productId"));
		} catch (Exception e) {}
		if(productId==null||productId<1) {
			request.setAttribute("msg", "参数错误-productId");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		Integer amount=null;
		try {
			amount=Integer.parseInt(request.getParameter("amount"));
		} catch (Exception e) {}
		if(productId==null||productId<1) {
			request.setAttribute("msg", "参数错误-amount");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		Product product=productDao.selectProduct(productId);
		if(product==null) {
			request.setAttribute("msg", "商品不存在");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		User user=(User) request.getSession().getAttribute("user");
		if(user==null) {
			request.setAttribute("loginMsg", "亲爱的用户，登陆后才能添加到购物车哦！");
			request.setAttribute("redirectUrl", "IntroductionServlet?productId="+productId);
			request.getRequestDispatcher("/userlogin.jsp").forward(request, response);
			return;
		}
		//开始加入购物车
		Cart cart=new Cart();
		cart.setVipId(user.getVipId());
		cart.setProductId(productId);
		cart.setPrice(product.getProductPrice());
		cart.setAmount(amount);
		cart.setTotal(null);
		int result=cartDao.insertCart(cart);
		if(result>0) {
			request.setAttribute("iframeUrl", "ShowUserCart");
			request.getRequestDispatcher("/personalcenter2.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "添加到购物车失败");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
		}
	}
	
	
	//从购物车删除商品
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("执行删除");
		String[] cartIds_str = null;
		try {
			cartIds_str = request.getParameterValues("item");
		} catch (Exception e) {
		}
		if (cartIds_str == null || cartIds_str.length < 1) {
			request.setAttribute("msg", "参数错误-items");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "登陆已失效，请重新登陆！<a href='userlogin.jsp'>》》点我登陆《《</a>");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		for (String cartId_str : cartIds_str) {
			Integer cartId = null;
			try {
				cartId = Integer.valueOf(cartId_str);
			} catch (Exception e) {
			}
			if (cartId == null || cartId == 0) {
				request.setAttribute("msg", "参数中有错误-items");
				request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
				return;
			}
			cartDao.deleteByCartId(cartId);
		}
		request.setAttribute("NoDoDelete","true");
		this.doGet(request, response);
	}

}
