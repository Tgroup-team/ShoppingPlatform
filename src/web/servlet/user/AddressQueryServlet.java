package web.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.impl.AddressDaoImpl;
import web.entity.Address;
import web.entity.Page;

/**
 * Servlet implementation class AddressQueryServlet
 */
@WebServlet("/page")
public class AddressQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNow = request.getParameter("pageNow"); 
		System.out.println("pageNow:"+pageNow);
		
        Page page = null; 
        AddressDaoImpl addressDao=new AddressDaoImpl();
        List<Address> addresses = new ArrayList<Address>(); 
        List<Address> addressCount = addressDao.selectAddress();
        
        //查询用户总数
        int totalCount=addressCount.size();
        System.out.println("一共数据条数："+totalCount);
        //int totalCount = (int) addressDao.countAddress();
        
        if (pageNow != null) { 
            page = new Page(totalCount, Integer.parseInt(pageNow),5);  
           // absence=absenceMapper.selectAbsenceByPage(page.getStartPos(), page.getPageSize());
            addresses=addressDao.selectAddressByPage(page.getPageSize(), page.getStartPos());
        } else { 
            page = new Page(totalCount, 1,5); 
            addresses=addressDao.selectAddressByPage(page.getPageSize(), page.getStartPos());
        } 
        for (Address address : addresses) {
			System.out.println(address.toString());
		}
        request.setAttribute("addresses", addresses);
        request.setAttribute("page", page);  
        request.getRequestDispatcher("/address2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	
}
