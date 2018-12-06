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
 * 添加社区
 */
@WebServlet("/addcommunity")
public class AddCommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ICommunityDao communityDao=new CommunityDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		
		String communityName=request.getParameter("communityName");
		
		
		Community community=new Community();
		community.setCommunityName(communityName);
		
		communityDao.insertCommunity(community);
		
		List<Community> listCommunity = communityDao.selectCommunity();
		session.setAttribute("listCommunity", listCommunity);
		
		request.getRequestDispatcher("/admin/community2.jsp").forward(request, response);
	}

	

}
