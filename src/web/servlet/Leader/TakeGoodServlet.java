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
import web.dao.IOrderDao;
import web.dao.IOrderdetailsDao;
import web.dao.IProductDao;
import web.dao.ITakeGoodDao;
import web.dao.impl.AddressDaoImpl;
import web.dao.impl.OrderDaoImpl;
import web.dao.impl.OrderdetailsDaoImpl;
import web.dao.impl.ProductDaoImpl;
import web.dao.impl.TakeGoodDaoImpl;
import web.entity.Address;
import web.entity.Order;
import web.entity.Orderdetails;
import web.entity.Page;
import web.entity.Product;
import web.entity.TakeGood;
import web.entity.User;

/**
 * Servlet implementation class TakeGoodServlet
 */
@WebServlet("/takeGoodServlet")
public class TakeGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TakeGoodServlet() {
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
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Integer vipId=user.getVipId();
		
        Page page = null; 
        ITakeGoodDao tgdao=new TakeGoodDaoImpl();
        List<TakeGood> takegoods=null;
        List<TakeGood> takegoodsCount=tgdao.selectTakeGoodByvipId(vipId);
        
        //查询总数
        int totalCount=takegoodsCount.size();
        System.out.println("一共数据条数："+totalCount);
        if (pageNow != null) { 
            page = new Page(totalCount, Integer.parseInt(pageNow),5);  
            takegoods=tgdao.selectTakeGoodByPage(page.getPageSize(), page.getStartPos(),vipId);
        } else { 
            page = new Page(totalCount, 1,5); 
            takegoods=tgdao.selectTakeGoodByPage(page.getPageSize(), page.getStartPos(),vipId);
        } 
        for (TakeGood takeGood : takegoodsCount) {
			System.out.println(takeGood.toString());
		}
        request.setAttribute("takegoods", takegoods);
        request.setAttribute("page", page);  
        request.getRequestDispatcher("/manage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
