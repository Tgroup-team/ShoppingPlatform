package web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.IUserDao;
import web.dao.impl.UserDaoImpl;
import web.entity.User;

/**
 * Servlet implementation class TeamHeaderServlet
 */
@WebServlet("/teamHeader")
public class TeamHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamHeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IUserDao uDao=new UserDaoImpl();
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("username");
		System.out.println("user:"+uname);
		User user=uDao.selectByVipName(uname);
		System.out.println(user);
		request.setAttribute("user", user);      
		request.getRequestDispatcher("/teamheader.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);    
	}

}
