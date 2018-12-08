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
import web.dao.IUserDao;
import web.dao.impl.ApplyDaoImpl;
import web.dao.impl.UserDaoImpl;
import web.entity.Apply;
import web.entity.User;

/**
 * 审核不通过
 */
@WebServlet("/applynpass")
public class ApplyNpassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private IApplyDao applyDao=new ApplyDaoImpl();
	private IUserDao userDao=new UserDaoImpl();
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		
		String applyId=request.getParameter("applyId");
		String vipId=request.getParameter("vipId");
		
		Apply apply=new Apply();
		apply.setApplyId(Integer.parseInt(applyId));
		apply.setDeal("不通过");
		
		applyDao.updateByApplyId(apply);
		
		
		User user=new User();
		user.setVipId(Integer.parseInt(vipId));
		user.setIsLead("0");
		userDao.updateUser(user);
		
		
		
		List<Apply> listApply = applyDao.selectApply();
		session.setAttribute("listApply", listApply);
		
		request.getRequestDispatcher("/admin/community1.jsp").forward(request, response);
		
	}

}
