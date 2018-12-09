package web.dao.impl;

import java.util.List;

import web.dao.ITakeGoodDao;
import web.dao.util.SqlHelper;
import web.entity.Address;
import web.entity.TakeGood;

public class TakeGoodDaoImpl implements ITakeGoodDao {
	
	/*
	 * 收货地址分页
	 */
	@Override
	public List<TakeGood> selectTakeGoodByPage(int pageSize,int pageNow,Integer vipId){
/*		return SqlHelper.executeQuery(TakeGood.class,"SELECT top "+pageSize+
				" o.*,od.ordertime,u.productName,u.productImages,u.suppliers "+
				"FROM T_Order AS o "+
				"LEFT JOIN T_Orderdetails AS od ON o.orderId = od.orderId "+
				"LEFT JOIN T_Product AS u ON od.productId = u.productId where vipId="+vipId+
				" and vipId not in(select top "+pageNow+" vipId from T_Order)");*/
		return SqlHelper.executeQuery(TakeGood.class, "select top "+pageSize+" o.*,od.*,p.* from T_Order o,T_Orderdetails od,T_Product p where od.orderId=o.orderId and p.productId=od.productId and o.vipId="+vipId 
				+"and o.orderId not in(select top "+pageNow+" o.orderId from T_Order o,T_Orderdetails od where od.orderId=o.orderId and o.vipId="+vipId+")");
	}

	/*
	 * 收货地址信息通过vipId
	 */
	public List<TakeGood> selectTakeGoodByvipId(Integer vipId){
/*		return SqlHelper.executeQuery(TakeGood.class, 
				"SELECT o.*,od.ordertime,u.productName,u.productImages,u.suppliers FROM T_Order AS o "+
				"LEFT JOIN T_Orderdetails AS od ON o.orderId = od.orderId "+
				"LEFT JOIN T_Product AS u ON od.productId = u.productId where vipId="+vipId);*/
		return SqlHelper.executeQuery(TakeGood.class, "select o.*,od.*,p.* from T_Order o,T_Orderdetails od,T_Product p where od.orderId=o.orderId and p.productId=od.productId and o.vipId="+vipId);				
	}
	
	public static void main(String[] args) {
		TakeGoodDaoImpl t=new TakeGoodDaoImpl();
		List<TakeGood> ts=t.selectTakeGoodByvipId(2);
		for (TakeGood takeGood : ts) {
			System.out.println(ts.toString());
		}
	}


}
