package web.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.ManagerDao;
import web.entity.Managers;

/**
 * 管理员登录
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ManagerDao managerDao=new ManagerDao();
       
    public ManagerServlet() {
        super();    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String managerName=request.getParameter("managerName");
		String password=request.getParameter("password");
		System.out.println(managerName);
		System.out.println(password);
		Managers seleteByManagerName = managerDao.seleteByManagerName(managerName);
		Managers seleteByPassword = managerDao.seleteByPassword(password);
		if(seleteByManagerName==null) {
			request.setAttribute("show", "用户名不存在");
		}else {
			if (seleteByPassword==null) {
				request.setAttribute("show", "密码错误");
			}else {
				request.getRequestDispatcher("/admin/ahome1.jsp").forward(request, response);
			}
		}
	}

}
