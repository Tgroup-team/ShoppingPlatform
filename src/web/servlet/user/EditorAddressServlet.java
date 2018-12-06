package web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.IAddressDao;
import web.dao.impl.AddressDaoImpl;
import web.entity.Address;

/**
 * Servlet implementation class EditorAddressServlet
 */
@WebServlet("/editor")
public class EditorAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer aId=Integer.valueOf(request.getParameter("id"));
		System.out.println(aId);
		IAddressDao addressDao=new AddressDaoImpl();
		Address address= addressDao.selectAddressById(aId);
		System.out.println(address);
		request.setAttribute("address",address);
		request.getRequestDispatcher("/editor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
