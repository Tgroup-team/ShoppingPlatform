package web.servlet.Leader;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.IOrderDao;
import web.dao.impl.OrderDaoImpl;
import web.entity.Order;

/**
 * Servlet implementation class ConfirmGoodsServlet
 */
@WebServlet("/confirmGoodsServlet")
public class ConfirmGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id=Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		IOrderDao orderDao=new OrderDaoImpl();
		Order order=orderDao.selectByOrderId(id);
		order.setOrderstate("已收货");
		System.out.println(order);
		int i=orderDao.updateByOrderId(order);
		System.out.println(i);
		request.getRequestDispatcher("/takeGoodServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
