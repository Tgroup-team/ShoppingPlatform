package web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.impl.UserDaoImpl;
import web.entity.User;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.removeAttribute("loginMsg");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		System.out.println("11111");
		System.out.println(uname);
		System.out.println(pwd);
		UserDaoImpl userDao=new UserDaoImpl();
		User user=userDao.selectByVipName(uname);
		if(user!=null) {
			System.out.println(user.getPassword());
			if(user.getPassword().equals(pwd)) {
				HttpSession session = request.getSession();
				System.out.println("session:"+session);
				session.setAttribute("user", user);

				System.out.println("登录成功");

				session.setAttribute("username", uname);
				session.setAttribute("id", user.getVipId());
				session.setAttribute("communityId", user.getCommunityId());
				if(request.getParameter("redirectUrl")!=null&&!"".equals(request.getParameter("redirectUrl"))) {
					response.sendRedirect(request.getParameter("redirectUrl"));
					return;
				}
				request.getRequestDispatcher("/personalcenter2.jsp").forward(request, response);
			}else {
				request.setAttribute("loginMsg", "密码错误");
				request.getRequestDispatcher("/userlogin.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("loginMsg", "用户不存在");
			request.getRequestDispatcher("/userlogin.jsp").forward(request, response);
		}
	}

}
