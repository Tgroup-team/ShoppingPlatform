package web.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.IApplyDao;
import web.dao.impl.ApplyDaoImpl;
import web.entity.Apply;

/**
 * 审核实现
 */
@WebServlet("/applyservlet")
public class ScanApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private IApplyDao applyDao=new ApplyDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		List<Apply> listApply = applyDao.selectApply();
		session.setAttribute("listApply", listApply);
		
		request.getRequestDispatcher("/admin/community1.jsp").forward(request, response);
		
		
	}

}
