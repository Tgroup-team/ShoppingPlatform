package web.servlet.user;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.IOrderDao;
import web.dao.IOrderdetailsDao;
import web.dao.IReturnDao;
import web.dao.impl.OrderDaoImpl;
import web.dao.impl.OrderdetailsDaoImpl;
import web.dao.impl.ReturnDaoImpl;
import web.entity.Order;
import web.entity.Orderdetails;
import web.entity.Return;
import web.entity.User;

/**
 * Servlet implementation class ShowUserOrders
 */
@WebServlet("/ShowUserOrders")
public class ShowUserOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IOrderDao orderDao=new OrderDaoImpl();
    private IOrderdetailsDao orderdetailsDao=new OrderdetailsDaoImpl();
    private IReturnDao returnDao=new ReturnDaoImpl();
    
    //查看订单管理
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("user");
		if(user==null) {
			request.setAttribute("msg", "登陆已失效，请重新<a href='userlogin.jsp'>登陆</a>");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		List<Orderdetails> selectOrderdetails_all = orderdetailsDao.selectOrderdetailsByVipIdAndOrderState(user.getVipId(), null);
		List<Orderdetails> selectOrderdetails_waitSend = orderdetailsDao.selectOrderdetailsByVipIdAndOrderState(user.getVipId(), "待发货");
		List<Orderdetails> selectOrderdetails_sended = orderdetailsDao.selectOrderdetailsByVipIdAndOrderState(user.getVipId(), "发货");
		List<Orderdetails> selectOrderdetails_received = orderdetailsDao.selectOrderdetailsByVipIdAndOrderState(user.getVipId(), "已收货");
		List<Return> selectRetrun_return = returnDao.selectReturnByVipId(user.getVipId());
		request.setAttribute("selectOrderdetails_all", selectOrderdetails_all);
		request.setAttribute("selectOrderdetails_waitSend", selectOrderdetails_waitSend);
		request.setAttribute("selectOrderdetails_sended", selectOrderdetails_sended);
		request.setAttribute("selectOrderdetails_received", selectOrderdetails_received);
		request.setAttribute("selectRetrun_return", selectRetrun_return);
		request.getRequestDispatcher("/shopcar1.jsp").forward(request, response);
	}

	//执行退货操作
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer orderId=null;
		try {
			orderId=Integer.parseInt(request.getParameter("orderId"));
		} catch (Exception e) {}
		System.out.println("orderId="+orderId);
		if(orderId==null) {
			request.setAttribute("msg", "参数错误");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		//获取这个订单
		Order order = orderDao.selectByOrderId(orderId);
		if(order==null) {
			request.setAttribute("msg", "订单不存在");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		User user=(User)request.getSession().getAttribute("user");
		if(user.getVipId().compareTo(order.getUser().getVipId())!=0) {
			request.setAttribute("msg", "不能操作非个人的订单");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		//开始退货
		//获取这个订单详情
		Orderdetails orderdetails=orderdetailsDao.selectOrderdetailsByOrderId(orderId);
		if(orderdetails==null) {
			request.setAttribute("msg", "订单不存在");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		//构建退货信息
		Return returnOrder=new Return();
		returnOrder.setProductId(orderdetails.getProductId());
		returnOrder.setVipId(user.getVipId());
		returnOrder.setTotal(null);
		returnOrder.setReturnstate("待退款");
		Date nowDate=new Date();
		returnOrder.setApplytime(nowDate);
		returnOrder.setAmount(orderdetails.getAmount());
		returnOrder.setProcessingstate("未退货");
		returnOrder.setProductprice(orderdetails.getPrice());
		returnOrder.setReturnTime(nowDate);
		int result=returnDao.insertReturn(returnOrder);
		if(result>0) {
			order.setOrderstate("退货");
			orderDao.updateByOrderId(order);
			request.setAttribute("msg", "申请退货成功");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		request.setAttribute("msg", "申请退货失败");
		request.getRequestDispatcher("/404").forward(request, response);
		return;
	}
	
	//执行删除历史订单操作
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer orderId=null;
		try {
			orderId=Integer.parseInt(request.getParameter("orderId"));
		} catch (Exception e) {}
		if(orderId==null) {
			request.setAttribute("msg", "参数错误");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		//获取订单
		Orderdetails orderdetails=orderdetailsDao.selectOrderdetailsByOrderId(orderId);
		if(orderdetails==null) {
			request.setAttribute("msg", "订单不存在");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		User user=(User)request.getSession().getAttribute("user");
		if(user.getVipId()!=orderdetails.getOrder().getVipId()) {
			request.setAttribute("msg", "不能操作非个人的订单");
			request.getRequestDispatcher("/404").forward(request, response);
			return;
		}
		//开始删除
		if("已收货".equals(orderdetails.getOrder().getOrderstate())) {
			orderdetailsDao.deleteOrderdetails(orderdetails.getDetailsId());
			orderDao.deleteByOrderId(orderdetails.getOrderId());
		}
	}

}
