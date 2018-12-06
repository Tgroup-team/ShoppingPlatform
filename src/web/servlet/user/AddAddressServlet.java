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
 * Servlet implementation class AddAddressServlet
 */
@WebServlet("/AddAddressServlet")
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String aName=request.getParameter("uaname");
		String aTel=request.getParameter("uatel");
		String aProvince=request.getParameter("uaprovince");
		String aCity=request.getParameter("uacity");
		String aArea=request.getParameter("uaarea");
		String aDetailAddr=request.getParameter("uadetail");
		System.out.println(aName);
		System.out.println(aTel);
		System.out.println(aProvince);
		System.out.println(aCity);
		System.out.println(aArea);
		System.out.println(aDetailAddr);
	//	Address address=new Address(aName, aTel, aProvince, aCity, aArea, aDetailAddr);
		Address address=new Address(aName, aTel, aProvince, aCity, aArea, aDetailAddr);
		IAddressDao addresDao=new AddressDaoImpl();
		int i=addresDao.insertAddress(address);
		System.out.println(i);
		request.getRequestDispatcher("/personalcenter2.jsp").forward(request, response);
		
	
	}

}
