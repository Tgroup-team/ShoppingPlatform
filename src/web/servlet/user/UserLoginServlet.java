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
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
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
				request.getRequestDispatcher("/personalcenter2.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "密码错误");
				request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "找不到用户");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
		}
	}

}
