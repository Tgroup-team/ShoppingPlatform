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
 * 查看订单
 */
@WebServlet("/porderservlet")
public class PorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IOrderDao orderDao=new OrderDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		
		List<Order> listOrder = orderDao.selectOrder();
		session.setAttribute("listOrder", listOrder);
		
		request.getRequestDispatcher("/admin/porder1.jsp").forward(request, response);
		
		
	}
	
	

}
