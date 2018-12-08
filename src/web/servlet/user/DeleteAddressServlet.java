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
import web.dao.ICommunityAddressDao;
import web.dao.impl.AddressDaoImpl;
import web.dao.impl.CommunityAddressDaoImpl;
import web.entity.Address;
import web.entity.CommunityAddress;
import web.entity.Page;
import web.entity.User;

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
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Integer id=Integer.valueOf(user.getIsLead());
		Integer vipId=Integer.valueOf(user.getVipId());
		//0代表用户
		if(id==0) {
			String pageNow = request.getParameter("pageNow"); 
			System.out.println("pageNow:"+pageNow);
	        Page page = null; 
	        IAddressDao addressDao=new AddressDaoImpl();
	        List<Address> addresses = new ArrayList<Address>(); 
	        
	        //查询总数
	        int totalCount = addressDao.countAddressByvipId(vipId);
	        System.out.println("一共数据条数："+totalCount);
	        if (pageNow != null) { 
	            page = new Page(totalCount, Integer.parseInt(pageNow),5);  
	            addresses=addressDao.selectUserAddressByPage(page.getPageSize(), page.getStartPos(),vipId);
	        } else { 
	            page = new Page(totalCount, 1,5); 
	            addresses=addressDao.selectUserAddressByPage(page.getPageSize(), page.getStartPos(),vipId);
	        } 
	        for (Address address : addresses) {
				System.out.println(address.toString());
			}
	        request.setAttribute("addresses", addresses);
	        request.setAttribute("page", page);  
	        request.getRequestDispatcher("/useraddress.jsp").forward(request, response);
		}else if(id==1) {
			System.out.println("1111111111");
			
			String pageNow = request.getParameter("pageNow"); 
			System.out.println("pageNow:"+pageNow);
	        Page page = null; 
	        ICommunityAddressDao caDao=new CommunityAddressDaoImpl();
	        List<CommunityAddress> cads=new ArrayList<CommunityAddress>();
	        List<CommunityAddress> cad=caDao.selectCommunityAddressByCommunityId(vipId);
	        
	        
	        //查询总数
	        int totalCount = cad.size();
	        System.out.println("一共数据条数："+totalCount);
	        if (pageNow != null) { 
	            page = new Page(totalCount, Integer.parseInt(pageNow),5);  
	            cads=caDao.selectCommunityAddressPage(page.getPageSize(), page.getStartPos(), user.getCommunityId());
	        } else { 
	            page = new Page(totalCount, 1,5); 
	            cads=caDao.selectCommunityAddressPage(page.getPageSize(), page.getStartPos(), user.getCommunityId());
	        } 
	        for (CommunityAddress communityAddress : cads) {
				System.out.println(communityAddress.toString());
			}
	        request.setAttribute("cads", cads);
	        request.setAttribute("page", page);  
	        request.getRequestDispatcher("/leaderaddress.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
