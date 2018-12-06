package web.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.ICommunityDao;
import web.dao.impl.CommunityDaoImpl;
import web.entity.Community;

/**
 * 社区管理
 */
@WebServlet("/communityservlet")
public class ScanCommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ICommunityDao communityDao=new CommunityDaoImpl();
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		List<Community> listCommunity = communityDao.selectCommunity();
		session.setAttribute("listCommunity", listCommunity);
		
		request.getRequestDispatcher("/admin/community2.jsp").forward(request, response);
		
	}

}
