package web.servlet.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.IManagerDao;
import web.dao.IRecordDao;
import web.dao.impl.ManagerDaoImpl;
import web.dao.impl.RecordDaoImpl;
import web.entity.Managers;
import web.entity.Record;

/**
 * 提现金额
 */
@WebServlet("/cashwithdrawal")
public class CashWithdrawalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IManagerDao managerDao=new ManagerDaoImpl();
	IRecordDao recordDao=new RecordDaoImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String money=request.getParameter("money");
		String managerId=request.getParameter("managerId");
		String textfield=request.getParameter("textfield");
		BigDecimal bigDecimal=new BigDecimal(textfield);
		
		Managers managers=new Managers();
		managers.setManagerId(Integer.parseInt(managerId));
		managers.setMoney(new BigDecimal(money).subtract(bigDecimal));
		
		managerDao.updateByManagerId(managers);
		
		Record record=new Record();
		record.setRecordtype("提现");
		record.setRecordTime(new Date());
		record.setRecordAmount(textfield);
		recordDao.insertRecord(record);
		
		request.getRequestDispatcher("/admin/baccounts1.jsp").forward(request, response);
		
	}

}
