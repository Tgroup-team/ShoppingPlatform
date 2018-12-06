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
 * 修改社区
 */
@WebServlet("/updatecommunity1")
public class UpdateCommunityServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private ICommunityDao communityDao=new CommunityDaoImpl();
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
			
		HttpSession session=request.getSession();
		
		String communityName=request.getParameter("communityName");
		int communityId=Integer.parseInt((String) session.getAttribute("communityId"));
		
		Community community=new Community();
		community.setCommunityId(communityId);
		community.setCommunityName(communityName);
		communityDao.updateByCommunityId(community);
		
		List<Community> listCommunity = communityDao.selectCommunity();
		session.setAttribute("listCommunity", listCommunity);
		
		
		request.getRequestDispatcher("/admin/community2.jsp").forward(request, response);
		
		
	}

}
