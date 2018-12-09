package web.dao.impl;

import web.dao.IManagerDao;
import web.dao.util.SqlHelper;
import web.entity.Managers;
import web.entity.Order;

public class ManagerDaoImpl implements IManagerDao{
	
	//查询用户名
	@Override
	public Managers seleteByManagerName(String managerName) {
		Managers managers=SqlHelper.executeQueryOne(Managers.class,"select * from T_Manager where managerName='"+managerName+"'");
		return managers;
	}
	
	//查询密码
	@Override
	public Managers seleteByPassword(String password) {
		Managers managers=SqlHelper.executeQueryOne(Managers.class,"select password from T_Manager where password='"+password+"'");
		return managers;
	}

	@Override
	public int updateManager(Managers managers) {
		return SqlHelper.executeUpdate("T_Manager", managers, "where managerId="+managers.getManagerId());
	}

	@Override
	public Managers selectByManagerId(Integer managerId) {
		// TODO Auto-generated method stub
		return SqlHelper.executeQueryOne(Managers.class, "select * from T_Manager where managerId="+managerId);
	}
	
	
	//通过managerId修改
	@Override
	public int updateByManagerId(Managers managers) {
		return SqlHelper.executeUpdate("T_Manager", managers, "where managerId="+managers.getManagerId());
	}
	
	//登录
	@Override
	public Managers loginManagers(String managerName,String password) {
		return SqlHelper.executeQueryOne(Managers.class, "select * from T_Manager where managerName='"+managerName+"' and password='"+password+"'");
	}
	
}
