package web.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.IReturnDao;
import web.dao.impl.ReturnDaoImpl;
import web.entity.Return;

/**
 * 退款操作
 */
@WebServlet("/refund")
public class ReturnRefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IReturnDao returnDao=new ReturnDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String returnId=request.getParameter("returnId");
		HttpSession session=request.getSession();
		
		Return return1=new Return();
		return1.setReturnId(Integer.parseInt(returnId));
		return1.setReturnstate("已退款");
		returnDao.updateReturn(return1);
		
		List<Return> listReturn = returnDao.selectReturn();
		session.setAttribute("listReturn", listReturn);
		
		request.getRequestDispatcher("/admin/return1.jsp").forward(request, response);
		
		
		
		
	}

}
