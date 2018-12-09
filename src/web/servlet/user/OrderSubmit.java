package web.servlet.user;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.ICartDao;
import web.dao.IManagerDao;
import web.dao.IOrderDao;
import web.dao.IOrderdetailsDao;
import web.dao.IProductDao;
import web.dao.IRecordDao;
import web.dao.IUserDao;
import web.dao.impl.CartDaoImpl;
import web.dao.impl.ManagerDaoImpl;
import web.dao.impl.OrderDaoImpl;
import web.dao.impl.OrderdetailsDaoImpl;
import web.dao.impl.ProductDaoImpl;
import web.dao.impl.RecordDaoImpl;
import web.dao.impl.UserDaoImpl;
import web.entity.Cart;
import web.entity.Managers;
import web.entity.Order;
import web.entity.Orderdetails;
import web.entity.Product;
import web.entity.Record;
import web.entity.User;

/**
 * Servlet implementation class OrderSubmit
 */
@WebServlet("/OrderSubmit")
public class OrderSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICartDao cartDao = new CartDaoImpl();
	private IProductDao productDao = new ProductDaoImpl();
	private IOrderDao orderDao = new OrderDaoImpl();
	private IOrderdetailsDao orderdetailsDao = new OrderdetailsDaoImpl();
	private IManagerDao managerDao = new ManagerDaoImpl();
	private IRecordDao recordDao = new RecordDaoImpl();
	private IUserDao userDao = new UserDaoImpl();

	// 直接购买
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("post")!=null) {
			doPost(request, response);
			return;
		}
		Integer productId = null;
		try {
			productId = Integer.parseInt(request.getParameter("productId"));
		} catch (Exception e) {
		}
		if (productId == null || productId < 1) {
			request.setAttribute("msg", "参数错误-productId");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		Integer amount = null;
		try {
			amount = Integer.parseInt(request.getParameter("amount"));
		} catch (Exception e) {
		}
		if (productId == null || productId < 1) {
			request.setAttribute("msg", "参数错误-amount");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		Product product = productDao.selectProduct(productId);
		if (product == null) {
			request.setAttribute("msg", "商品不存在");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		User user = (User) request.getSession().getAttribute("user");
		user=userDao.selectUser(user.getVipId());
		if (user == null) {
			request.setAttribute("loginMsg", "亲爱的用户，登陆后才能购买哦！");
			request.setAttribute("redirectUrl", "IntroductionServlet?productId=" + productId);
			request.getRequestDispatcher("/userlogin.jsp").forward(request, response);
			return;
		}
		// 开始购买
		// 计算金额
		BigDecimal total = product.getProductPrice().multiply(new BigDecimal(amount));
		BigDecimal userBalance = new BigDecimal(user.getaBalance());
		// 先判断用户钱够不够
		if (userBalance.compareTo(total) < 0) {
			request.setAttribute("msg", "账户余额不足，请充值");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		// 够就开始生成订单
		// 先生成Order
		Order order = new Order();
		order.setVipId(user.getVipId());
		order.setOrderstate("待发货");
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String delivery = sdf.format(nowDate);
		order.setDelivery(nowDate);
		order.setAcceptance(nowDate);
		int insertOrderResult = orderDao.insertOrder(order);
		if (insertOrderResult < 1) {
			request.setAttribute("msg", "生成订单失败");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		// 再查出来这个Order的id以便下一步
		order = orderDao.selectByVipIdAndDelivery(order.getVipId(), delivery);
		// 生成orderetails
		Orderdetails orderdetails = new Orderdetails();
		orderdetails.setOrderId(order.getOrderId());
		orderdetails.setProductId(productId);
		orderdetails.setAmount(amount);
		orderdetails.setPrice(product.getProductPrice());
		orderdetails.setTotal(null);// 数据库自动生成
		orderdetails.setOrdertime(nowDate);
		int insertOrderDetailsResult = orderdetailsDao.insertOrderdetails(orderdetails);
		if (insertOrderDetailsResult < 1) {
			// 回滚
			orderDao.deleteByOrderId(order.getOrderId());
			request.setAttribute("msg", "生成订单详情失败");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		// 开始生成记录
		Record record = new Record();
		record.setRecordTime(nowDate);
		record.setRecordtype("收入");
		total = total.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		record.setRecordAmount(total.toString());
		recordDao.insertRecord(record);
		// 开始计算账户余额
		userBalance = userBalance.subtract(total);
		user.setaBalance(userBalance.intValue());
		System.out.println("更新用户信息：" + userDao.updateUser(user));
		// 开始计算管理员（商家）的账户余额
		Managers managers = managerDao.selectByManagerId(1);
		managers.setMoney(managers.getMoney().add(total));
		managerDao.updateManager(managers);
		// 购买成功
		request.setAttribute("msg", "购买成功");
		request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);

	}

	// 购物车结算
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		user=userDao.selectUser(user.getVipId());
		if (user == null) {
			request.setAttribute("msg", "登陆已失效，请重新登陆！<a href='userlogin.jsp'>》》点我登陆《《</a>");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		BigDecimal total = new BigDecimal(0);
		List<Cart> carts = new ArrayList<Cart>();
		for (String cartId_str : cartIds_str) {
			Cart cart = null;
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
			// 开始获取这个购物车
			cart = cartDao.selectCartById(cartId);
			if (cart == null) {
				request.setAttribute("msg", "购物车条目不存在");
				request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
				return;
			}
			// 看是不是用户自己的购物车
			if (cart.getVipId().compareTo(user.getVipId())!=0) {
				request.setAttribute("msg", "只能结算自己的购物车哦！");
				request.getRequestDispatcher("/404").forward(request, response);
				return;
			}
			// 存在就添加，并记录该订单号
			total=total.add(cart.getTotal());
			carts.add(cart);
		}
		// 开始购买
		// 计算金额
		BigDecimal userBalance = new BigDecimal(user.getaBalance());
		// 先判断用户钱够不够
		if (userBalance.compareTo(total) < 0) {
			request.setAttribute("msg", "账户余额不足，请充值");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		// 够就开始逐个生成订单
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String delivery = sdf.format(nowDate);
		for (Cart cart : carts) {
			// 先生成Order
			Order order = new Order();
			order.setVipId(user.getVipId());
			order.setOrderstate("待发货");
			order.setDelivery(nowDate);
			order.setAcceptance(nowDate);
			int insertOrderResult = orderDao.insertOrder(order);
			if (insertOrderResult < 1) {
				request.setAttribute("msg", "生成订单失败-购物车id="+cart.getCarId());
				request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
				return;
			}
			// 再查出来这个Order的id以便下一步
			order = orderDao.selectByVipIdAndDelivery(order.getVipId(), delivery);
			// 生成orderetails
			Orderdetails orderdetails = new Orderdetails();
			orderdetails.setOrderId(order.getOrderId());
			orderdetails.setProductId(cart.getProductId());
			orderdetails.setAmount(cart.getAmount());
			orderdetails.setPrice(cart.getPrice());
			orderdetails.setTotal(null);// 数据库自动生成
			orderdetails.setOrdertime(nowDate);
			int insertOrderDetailsResult = orderdetailsDao.insertOrderdetails(orderdetails);
			if (insertOrderDetailsResult < 1) {
				// 回滚
				orderDao.deleteByOrderId(order.getOrderId());
				request.setAttribute("msg", "生成订单详情失败-购物车id="+cart.getCarId());
				request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
				return;
			}
		}
		// 开始生成记录
		Record record = new Record();
		record.setRecordTime(nowDate);
		record.setRecordtype("收入");
		total = total.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		record.setRecordAmount(total.toString());
		recordDao.insertRecord(record);
		// 开始计算账户余额
		userBalance = userBalance.subtract(total);
		user.setaBalance(userBalance.intValue());
		System.out.println("更新用户信息：" + userDao.updateUser(user));
		// 开始计算管理员（商家）的账户余额
		Managers managers = managerDao.selectByManagerId(1);
		managers.setMoney(managers.getMoney().add(total));
		managerDao.updateManager(managers);
		// 购买成功
		//删除购物车
		for(Cart dCart:carts) {
			cartDao.deleteByCartId(dCart.getCarId());
		}
		
		request.setAttribute("msg", "结算成功");
		request.getRequestDispatcher("/404").forward(request, response);
	}
	
	public static void main(String[] args) {
		System.out.println(new Date());
	}

}
