package web.dao.impl;

import java.util.List;

import web.dao.ITakeGoodDao;
import web.dao.util.SqlHelper;
import web.entity.Address;
import web.entity.TakeGood;

public class TakeGoodDaoImpl implements ITakeGoodDao {
	
	
	@Override
	public List<TakeGood> selectTakeGoodByPage(int pageSize,int pageNow,Integer vipId){
		return SqlHelper.executeQuery(TakeGood.class,"SELECT top "+pageSize+
				" o.*,od.ordertime,u.productName,u.productImages,u.suppliers "+
				"FROM T_Order AS o "+
				"LEFT JOIN T_Orderdetails AS od ON o.orderId = od.orderId "+
				"LEFT JOIN T_Product AS u ON od.productId = u.productId where vipId="+vipId+
				" and vipId not in(select top "+pageNow+" vipId from T_Order)");
	}

	public List<TakeGood> selectTakeGoodByvipId(Integer vipId){
		return SqlHelper.executeQuery(TakeGood.class, 
				"SELECT o.*,od.ordertime,u.productName,u.productImages,u.suppliers FROM T_Order AS o "+
				"LEFT JOIN T_Orderdetails AS od ON o.orderId = od.orderId "+
				"LEFT JOIN T_Product AS u ON od.productId = u.productId where vipId="+vipId);
				
	}
	
	public static void main(String[] args) {
		TakeGoodDaoImpl t=new TakeGoodDaoImpl();
		List<TakeGood> ts=t.selectTakeGoodByvipId(2);
		for (TakeGood takeGood : ts) {
			System.out.println(ts.toString());
		}
	}


}
