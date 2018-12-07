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
 * 退货记录浏览
 */
@WebServlet("/returnservlet")
public class ScanReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private IReturnDao returnDao=new ReturnDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		List<Return> listReturn = returnDao.selectReturn();
		session.setAttribute("listReturn", listReturn);
		
		request.getRequestDispatcher("/admin/return1.jsp").forward(request, response);
		
	}

	
}
