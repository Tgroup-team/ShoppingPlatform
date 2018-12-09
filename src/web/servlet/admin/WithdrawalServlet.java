package web.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.IManagerDao;
import web.dao.impl.ManagerDaoImpl;
import web.entity.Managers;

/**
 * 金额显示
 */
@WebServlet("/withdrawal")
public class WithdrawalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IManagerDao managerDao=new ManagerDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		Managers manage=(Managers) session.getAttribute("admin");
		
		Managers seleteByManagerName = managerDao.seleteByManagerName(manage.getManagerName());
		session.setAttribute("seleteByManagerName", seleteByManagerName);
		System.out.println(seleteByManagerName);
		
		request.getRequestDispatcher("/admin/withdrawal1.jsp").forward(request, response);
		
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}

}
