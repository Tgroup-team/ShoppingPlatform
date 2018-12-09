package web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.reflect.Reflection;
import web.dao.IUserDao;
import web.dao.impl.UserDaoImpl;
import web.entity.User;

/**
 * Servlet implementation class AddMoneyServlet
 */
@WebServlet("/addMoneyServlet")
public class AddMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMoneyServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String umoney=request.getParameter("usermoney");
		Integer aBalance=Integer.valueOf(umoney);
		
		HttpSession session=request.getSession();
		User use=(User) session.getAttribute("user");
		IUserDao uDao=new UserDaoImpl();
		User us=uDao.selectByVipName(use.getVipName());
		//System.out.println("Us:"+us.toString());
		
		if(us!=null) {
			int i=0;
			User user=new User();
			user.setVipId(us.getVipId());
			if(us.getaBalance()!=null) {
				aBalance=aBalance+us.getaBalance();
				user.setaBalance(aBalance);
				i=uDao.updateUser(user);
			}else {
				user.setaBalance(aBalance);
				i=uDao.updateUser(user);
			}
			if(i>0) {
				System.out.println("充值成功！！！");
				request.getRequestDispatcher("/UserBalance").forward(request, response);
			}else {
				request.setAttribute("msg", "充值失败");
				request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			}   	
		}else {
			request.setAttribute("msg", "找不到账户");
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
		}
	}

}
