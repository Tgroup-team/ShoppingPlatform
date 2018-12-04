package web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.UserDao;
import web.entity.User;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
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
		String vname=request.getParameter("vname");
		String vpwd=request.getParameter("vpwd");
		String vtel=request.getParameter("vtel");
		String vaddress=request.getParameter("vaddress");
		System.out.println(vname);
		System.out.println(vpwd);
		System.out.println(vtel);
		System.out.println(vaddress);
		User user=new User(vname, vpwd, vtel, vaddress);
		UserDao uDao=new UserDao();
		
		
	}

}
