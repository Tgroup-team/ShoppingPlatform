package web.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.IAddressDao;
import web.dao.impl.AddressDaoImpl;
import web.entity.Address;
import web.entity.Page;

/**
 * Servlet implementation class DeleteAddressServlet
 */
@WebServlet("/DeleteAddressServlet")
public class DeleteAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer aId=Integer.valueOf(request.getParameter("id"));
		IAddressDao addresDao=new AddressDaoImpl();
		int i=addresDao.deleteByAddressId(aId);
		System.out.println(i);
		
		 //地址修改后，跳转到地址页面
		String pageNow = request.getParameter("pageNow"); 
		System.out.println("pageNow:"+pageNow);
		
        Page page = null; 
        IAddressDao addressDao=new AddressDaoImpl();
        List<Address> addresses = new ArrayList<Address>(); 
        List<Address> addressCount = addressDao.selectAddress();
   
        //查询总数
        int totalCount=addressCount.size();
        System.out.println("一共数据条数："+totalCount);
        
        if (pageNow != null) { 
            page = new Page(totalCount, Integer.parseInt(pageNow),5);  
           // absence=absenceMapper.selectAbsenceByPage(page.getStartPos(), page.getPageSize());
            addresses=addressDao.selectAddressByPage(page.getPageSize(), page.getStartPos());
        } else { 
            page = new Page(totalCount, 1,5); 
            addresses=addressDao.selectAddressByPage(page.getPageSize(), page.getStartPos());
        } 
        for (Address addr : addresses) {
			System.out.println(addr.toString());
		}
        request.setAttribute("addresses", addresses);
        request.setAttribute("page", page);  
        request.getRequestDispatcher("/address2.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
