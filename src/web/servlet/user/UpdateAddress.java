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

import web.dao.IAddressDao;
import web.dao.impl.AddressDaoImpl;
import web.entity.Address;
import web.entity.Page;
import web.entity.User;

/**
 * Servlet implementation class UpdateAddress
 */
@WebServlet("/updateAddress")
public class UpdateAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("测试");
		Integer aId=Integer.valueOf(request.getParameter("uaId"));

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
		Address address=new Address(aId,aName, aTel, aProvince, aCity, aArea, aDetailAddr);
		IAddressDao addresDao=new AddressDaoImpl();
		int i=addresDao.updateByAddressId(address);
		System.out.println(i);
	
        request.getRequestDispatcher("/page").forward(request, response);
	}

}
