package web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.impl.UserDao;
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
		UserDao userDao=new UserDao();
		User user=userDao.selectByVipName(uname);
		if(user!=null) {
			System.out.println(user.getPassword());
			if(user.getPassword().equals(pwd)) {
				request.getRequestDispatcher("/personalcenter2.html").forward(request, response);
			}else {
				System.out.println("密码错误");
				response.sendRedirect("/UsersLogin.jsp");
			}
		}else {
			System.out.println("找不到用户");
			response.sendRedirect("/UsersLogin.jsp");
		}
	}

}
