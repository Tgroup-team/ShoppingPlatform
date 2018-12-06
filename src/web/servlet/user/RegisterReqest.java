package web.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.ICommunityDao;
import web.dao.impl.CommunityDaoImpl;
import web.entity.Community;

/**
 * Servlet implementation class RegisterReqest
 */
@WebServlet("/RegisterReqest")
public class RegisterReqest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterReqest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ICommunityDao cd=new CommunityDaoImpl();
	    List<Community> communitys =cd.selectCommunity();
	    for (Community community : communitys) {
			System.out.println(community.toString());
		}
	    request.setAttribute("communitys", communitys);
	    request.getRequestDispatcher("/registerTest.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
