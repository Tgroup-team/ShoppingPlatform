package web.servlet.Leader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.IAddressDao;
import web.dao.IUserDao;
import web.dao.impl.AddressDaoImpl;
import web.dao.impl.UserDaoImpl;
import web.entity.Address;
import web.entity.Page;
import web.entity.User;

/**
 * Servlet implementation class BrowseMemberServlet
 */
@WebServlet("/BrowseMemberServlet")
public class BrowseMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowseMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Integer communityId=(Integer) session.getAttribute("communityId");
		String pageNow = request.getParameter("pageNow"); 
		System.out.println("pageNow:"+pageNow);
		
        Page page = null; 
        IUserDao uDao=new UserDaoImpl();
        List<User> uses = new ArrayList<User>(); 
        List<User> userCount = uDao.selectUser();
        
        //查询用户总数
        int totalCount=userCount.size();
        System.out.println("一共数据条数："+totalCount);

        
        if (pageNow != null) { 
            page = new Page(totalCount, Integer.parseInt(pageNow),5);  
            //uses=uDao.selectUserByPage(page.getPageSize(), page.getStartPos());
           // uses=uDao.se
        } else { 
            page = new Page(totalCount, 1,5); 
            uses=uDao.selectUserByPage(page.getPageSize(), page.getStartPos());
        } 
      for (User user : userCount) {
		System.out.println(user.toString());
	}
        request.setAttribute("uses", uses);
        request.setAttribute("page", page);  
        request.getRequestDispatcher("/userinfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
