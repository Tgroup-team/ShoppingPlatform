package web.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.impl.CommunityDaoImpl;
import web.entity.Community;

/**
 * 社区管理
 */
@WebServlet("/CommunityServlet")
public class CommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CommunityDaoImpl communityDao=new CommunityDaoImpl();
       
    
    public CommunityServlet() {
        super();
    }


	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deleteByCommunityId = communityDao.deleteByCommunityId(1);
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Community> listCommunity = communityDao.selectCommunity();
		request.setAttribute("listCommunity", listCommunity);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Community community=new Community();
		community.setCommunityId(1);
		community.setCommunityName("");
		int insertCommunity = communityDao.insertCommunity(community);
	}


	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Community community=new Community();
		community.setCommunityId(1);
		community.setCommunityName("");
		int updateByCommunityId = communityDao.updateByCommunityId(community);
	}

	

}
