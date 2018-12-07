package web.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.IOrderDao;
import web.dao.impl.OrderDaoImpl;
import web.entity.Order;

/**
 * 通过id删除订单
 */
@WebServlet("/deleteorder")
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IOrderDao orderDao=new OrderDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String orderId=request.getParameter("orderId");
		
		orderDao.deleteByOrderId(Integer.parseInt(orderId));
		List<Order> listOrder = orderDao.selectOrder();
		session.setAttribute("listOrder", listOrder);
		
		request.getRequestDispatcher("/admin/porder1.jsp").forward(request, response);
	}

}
