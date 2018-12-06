package web.servlet.admin;

import java.io.IOException;
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
 * 显示社区
 */
@WebServlet("/updatecommunity")
public class UpdateCommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ICommunityDao communityDao=new CommunityDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
			
		HttpSession session=request.getSession();
		
		String communityId=request.getParameter("communityId");
		
		Community selectByCommunity = communityDao.selectByCommunityId(Integer.parseInt(communityId));
		session.setAttribute("selectByCommunity", selectByCommunity);
		session.setAttribute("communityId", communityId);
		
		request.getRequestDispatcher("/admin/updatecommunity.jsp").forward(request, response);
		
	}

	

}
