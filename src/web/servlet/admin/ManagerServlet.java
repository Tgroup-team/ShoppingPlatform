package web.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.impl.ManagerDao;
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
		Managers seleteByManagerName = managerDao.seleteByManagerName("");
		Managers seleteByPassword = managerDao.seleteByPassword("");
		if(seleteByManagerName==null) {
			request.setAttribute("show", "用户名不存在");
		}else {
			if (seleteByPassword==null) {
				request.setAttribute("show", "密码错误");
			}else {
				request.getRequestDispatcher("");
			}
		}
	}

}
