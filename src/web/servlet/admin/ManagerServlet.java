package web.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import web.dao.ICategoryDao;
import web.dao.IManagerDao;
import web.dao.impl.CategoryDaoImpl;
import web.dao.impl.ManagerDaoImpl;
import web.entity.Category;
import web.entity.Managers;

/**
 * 管理员登录
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IManagerDao managerDao = new ManagerDaoImpl();
	private ICategoryDao categoryDao = new CategoryDaoImpl();

	public ManagerServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();

		String managerName = request.getParameter("managerName");
		String password = request.getParameter("password");

		Managers managers = managerDao.loginManagers(managerName, password);

		List<Category> listCategory = categoryDao.selectCategory();
		session.setAttribute("listCategory", listCategory);
		session.setAttribute("admin", managerName);
		if (managers!= null) {
			request.getRequestDispatcher("/admin/ahome1.jsp").forward(request, response);
		}
	}

}
