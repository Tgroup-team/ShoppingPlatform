package web.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import web.dao.IAddressDao;
import web.dao.IRecordDao;
import web.dao.IUserDao;
import web.dao.impl.AddressDaoImpl;
import web.dao.impl.RecordDaoImpl;
import web.dao.impl.UserDaoImpl;
import web.entity.Address;
import web.entity.Page;
import web.entity.Record;
import web.entity.User;

/**
 * Servlet implementation class UserBalance
 */
@WebServlet("/UserBalance")
public class UserBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBalance() {
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
		
		//String username=(String) session.getAttribute("username");
		User user=(User) session.getAttribute("user");
		System.out.println(user);
		User use=uDao.selectByVipName(user.getVipName());
		System.out.println(user.toString());
		request.setAttribute("user", use);
        request.getRequestDispatcher("/userbalance.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
