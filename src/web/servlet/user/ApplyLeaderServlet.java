package web.servlet.user;

import java.io.IOException;
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
 * Servlet implementation class ApplyLeaderServlet
 */
@WebServlet("/applyLeaderServlet")
public class ApplyLeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyLeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("username");
		Integer vipId=(Integer) session.getAttribute("id");
		Integer communityId=(Integer) session.getAttribute("communityId");
		
		
		IApplyDao applyDao=new ApplyDaoImpl();
		Apply apply=new Apply();
		apply.setVipId(vipId);
		apply.setCommunityId(communityId);
		int i=applyDao.insertApply(apply);
		System.out.println("结果："+i);
		request.getRequestDispatcher("/teamHeader").forward(request, response);
	}

}
