package web.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.IRecordDao;
import web.dao.impl.RecordDaoImpl;
import web.entity.Record;

/**
 * 浏览余额账户
 */
@WebServlet("/scanbaccounts")
public class ScanBaccountsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IRecordDao recordDao=new RecordDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		List<Record> listRecord = recordDao.selectRecord();
		
		session.setAttribute("listRecord", listRecord);
		
		request.getRequestDispatcher("/admin/baccounts1.jsp").forward(request, response);
		
		
	}

}
