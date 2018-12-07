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
 * 审核不通过
 */
@WebServlet("/applynpass")
public class ApplyNpassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private IApplyDao applyDao=new ApplyDaoImpl();
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		String applyId=request.getParameter("applyId");
		
		Apply apply=new Apply();
		apply.setApplyId(Integer.parseInt(applyId));
		apply.setDeal("不通过");
		
		applyDao.updateByApplyId(apply);
		
		List<Apply> listApply = applyDao.selectApply();
		session.setAttribute("listApply", listApply);
		
		request.getRequestDispatcher("/admin/community1.jsp").forward(request, response);
		
	}

}
