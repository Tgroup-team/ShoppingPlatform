package web.dao;

import java.util.List;

import org.apache.catalina.Manager;

import web.dao.util.SqlHelper;
import web.entity.Managers;

public class ManagerDao {
	
	//查询用户名
	public Managers seleteByManagerName(String managerName) {
		Managers managers=SqlHelper.executeQueryOne(Managers.class,"select managerName from T_Manager where managerName='"+managerName+"'");
		return managers;
	}
	
	//查询密码
	public Managers seleteByPassword(String password) {
		Managers managers=SqlHelper.executeQueryOne(Managers.class,"select managerName from T_Manager where password='"+password+"'");
		return managers;
	}
	
}
