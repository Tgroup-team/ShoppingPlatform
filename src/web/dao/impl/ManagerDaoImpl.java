package web.dao.impl;

import web.dao.IManagerDao;
import web.dao.util.SqlHelper;
import web.entity.Managers;

public class ManagerDaoImpl implements IManagerDao{
	
	//查询用户名
	@Override
	public Managers seleteByManagerName(String managerName) {
		Managers managers=SqlHelper.executeQueryOne(Managers.class,"select managerName from T_Manager where managerName='"+managerName+"'");
		return managers;
	}
	
	//查询密码
	@Override
	public Managers seleteByPassword(String password) {
		Managers managers=SqlHelper.executeQueryOne(Managers.class,"select password from T_Manager where password='"+password+"'");
		return managers;
	}
	
}
