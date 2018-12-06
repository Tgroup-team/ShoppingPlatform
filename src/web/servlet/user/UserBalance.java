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
import web.dao.IRecordDao;
import web.dao.impl.AddressDaoImpl;
import web.dao.impl.RecordDaoImpl;
import web.entity.Address;
import web.entity.Page;
import web.entity.Record;

/**
 * Servlet implementation class UserBalance
 */
@WebServlet("/UserBalance")
public class UserBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBalance() {
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
        IRecordDao rdDao=new RecordDaoImpl();
        List<Record> resList = new ArrayList<Record>(); 
        List<Record> recordsCount = rdDao.selectRecord();
        
        //查询用户总数
        int totalCount=recordsCount.size();
        System.out.println("一共数据条数："+totalCount);
        if (pageNow != null) { 
            page = new Page(totalCount, Integer.parseInt(pageNow),10);  
            resList=rdDao.selectRecordByPage(page.getPageSize(), page.getStartPos());
        } else { 
            page = new Page(totalCount, 1,10); 
            resList=rdDao.selectRecordByPage(page.getPageSize(), page.getStartPos());
        } 
        for (Record record : resList) {
			System.out.println(record.toString());
		}
        request.setAttribute("resList", resList);
        request.setAttribute("Balancepage", page);  
        request.getRequestDispatcher("/userbalance.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
